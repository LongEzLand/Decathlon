import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Decathlon {

    public static void main(String[] args) {

        CSVParser converter = new CSVParser( );



        String performance = "21,09,  df54  ";
        performance = performance.trim().replaceAll("[^\\d]", ".");//trims input string and replaces all non-digit values with dots
        while (performance.contains("..")){
            performance = performance.replace("..","." );//finds all occurances of ".." and replaces them with "." until there is none
        }


        System.out.println(performance );

        List<Character> newPerformance = new ArrayList<>();
        for (int i=0; i<performance.length();i++){
            newPerformance.add(performance.charAt(i));
        }




        System.out.println(newPerformance);


       /* String performanc[] = performance.split("");
        if (newString.get(0).equals("1"))
        for (int i=0; i<performanc.length; i++){
                System.out.println(performanc[i]);
            if(performanc[i].equals(".")){
                newString.add(performanc[i]);
                String currvalue = newString.get(i);
                String nextValue = performanc[i+1];
                if(currvalue.equals(".") && nextValue.equals(".")){
                    newString.remove(currvalue);
                }


            }else newString.add(performanc[i]);
        }


        System.out.println(newString);

*/

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







