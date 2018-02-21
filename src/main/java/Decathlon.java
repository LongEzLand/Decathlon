import java.util.List;

public class Decathlon {

    public static void main(String[] args) {

        CSVParser converter = new CSVParser( );

        List<Athlete> athletes = converter.parseData(converter.getFileFromDisk("results.csv"));

         for (Athlete athlete : athletes) {

            for (EventResult result : athlete.getEventResults()) {
                EventParameters parameters = EventParameters.getEventParameters(result.getEvent());

                if (parameters.getIsTrackEvent()) {
                    double athleteValue = result.getValue();
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







