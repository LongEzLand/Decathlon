import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Decathlon {

    public static void main(String[] args) {

        CSVParser converter = new CSVParser( );

        String performance = "21,09,  54  ";
        performance = performance.trim().replaceAll("[^\\d]", ".");

        List<String> newString = new ArrayList<>();
        String performanc[] = performance.split("");

        for (int i=0; i<performanc.length; i++){

            if((performanc[i] == ".")){
                newString.add(performanc[i]);
                newString.remove(performanc[i-1]);

            }else newString.add(performanc[i]);
        }


        System.out.println(newString);



        List<Athlete> athletes = converter.parseData(converter.getFileFromDisk("results.csv"));

         for (Athlete athlete : athletes) {

            for (EventResult result : athlete.getEventResults()) {
                EventParameters parameters = EventParameters.getEventParameters(result.getEvent());

                if (parameters.getIsTrackEvent()) {
                    String athleteValue = result.getValue();
                    System.out.println("was trackevent");
                    // one logic
                } else {
                    System.out.println("was fieldevent" );
                    // diff logic
                }


            }

        }

        EventParameters.getEventParameters(Event.DISCUSTHROW);

        Object test = EventParameters.getEventParameters(Event.DISCUSTHROW).getA();
        System.out.println(test);

        if (EventParameters.getEventParameters(Event.LONGJUMP).getIsTrackEvent()) {
            System.out.println("Yipee! its track event");
        } else {
            System.out.println("Yay, its field event");
        }
    }

}







