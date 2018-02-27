import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

public class CSVParser implements InputParser<File> {


    //maybe change to static method later on...

    public File getFileFromDisk(String fileName){
        ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource(fileName).getFile());
    }

    @Override
    public List<Athlete> parseData(File file) {
        List<Athlete> athletes = new ArrayList<>();
        BufferedReader br = null;
        FileReader fr = null;


        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null ) {
                if(!sCurrentLine.isEmpty()){
                    String[] lineValues = sCurrentLine.trim().split(";");

                    Athlete athlete = new Athlete();
                    athlete.setAthleteName(lineValues[0]);

                    List res = Arrays.asList(
                        getEventResult(Event.HUNDREDDASH, lineValues[1]),
                        getEventResult(Event.LONGJUMP, lineValues[2]),
                        getEventResult(Event.SHOTPUT, lineValues[3]),
                        getEventResult(Event.HIGHJUMP,lineValues[4]),
                        getEventResult(Event.FOURHUNDREDDASH,lineValues[5]),
                        getEventResult(Event.HUNDRETENHURDLES,lineValues[6]),
                        getEventResult(Event.DISCUSTHROW,lineValues[7]),
                        getEventResult(Event.POLEVAULT,lineValues[8]),
                        getEventResult(Event.JAVELINTHROW,lineValues[9])
                        //getEventResult(Event.THOUSANDFIVEHUNDRED, lineValues[10]) need to think some logic here to parse to double
                    );
                    athlete.getEventResults().addAll(res);
                    athletes.add(athlete);
                }
            }
        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }
        //got result from csv. Data should go to calculator

        return athletes;
    }

    private EventResult getEventResult(Event event, String rawValue) {
        return new EventResult(event, rawValue);
    }
}
