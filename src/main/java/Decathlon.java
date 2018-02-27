import java.util.List;


public class Decathlon {

    public static void main(String[] args) {

        CSVParser converter = new CSVParser( );

        List<Athlete> athletes = converter.parseData(converter.getFileFromDisk("results.csv"));
        System.out.println(athletes );

        for (Athlete athlete : athletes) {

            for (EventResult result : athlete.getEventResults()) {
                EventParameters parameters = EventParameters.getEventParameters(result.getEvent());

                if (parameters.getIsTrackEvent()) {
                    String athleteEventResult = result.getValue();
                    System.out.println(athleteEventResult );
                    System.out.println("was trackevent");
                    // one logic

                } else {
                    String athleteEventResult = result.getValue();
                    System.out.println(athleteEventResult );
                    System.out.println("was fieldevent" );
                    // diff logic
                }


            }

        }


    }

}







