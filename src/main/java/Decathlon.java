import java.util.List;


public class Decathlon {

    public static void main(String[] args) {

        CSVParser converter = new CSVParser( );

        List<Athlete> athletes = converter.parseData(converter.getFileFromDisk("results.csv"));
        System.out.println(athletes );

        for (Athlete athlete : athletes) {

            for (EventResult result : athlete.getEventResults()) {
                EventParameters params = EventParameters.getEventParameters(result.getEvent());

                if (params.getIsTrackEvent()) {
                    String athleteEventResult = result.getValue();
                    Integer computedResult = ScoreCalculator.trackScore(
                        params.getA(), params.getB(), params.getC(),result.getValue());

                    athlete.setScore(athlete.getScore() + computedResult); // computing total score



                    System.out.println(athlete.getAthleteName());
                    System.out.print("trackevent ");
                    System.out.println( result.getEvent());
                    System.out.println("result: " + athleteEventResult );
                    System.out.println("points "+ computedResult);

                    System.out.println("Total Score:" + athlete.getScore() );
                    System.out.println( );

                    // one logic

                } else {
                    String athleteEventResult = result.getValue();
                    Integer computedResult = ScoreCalculator.fieldScore(
                            params.getA(), params.getB(), params.getC(),result.getValue());

                    athlete.setScore(athlete.getScore() + computedResult);

                    System.out.println(athlete.getAthleteName());
                    System.out.print("fieldevent ");
                    System.out.println( result.getEvent());
                    System.out.println("result: " + athleteEventResult );
                    System.out.println("points "+ computedResult);
                    System.out.println("Score:" + athlete.getScore() );
                    System.out.println( );
                    // diff logic
                }


            }

        }


    }

}







