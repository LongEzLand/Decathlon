public class ScoreCalculator {

    // Should take in values from EventParameters, EventResults and Athlete and calculate score and place using
    // given formulae.

   /* The 2001 IAAF points tables use the following formulae:

    Points = INT(A((B — P)powC)) for track events (faster time produces a better score)
    Points = INT(A((P — B)powC)) for field events (greater distance or height produces a better score)
    A, B and C are parameters that vary by discipline, as shown in the table on the right, while P is the performance by the athlete,
    measured in seconds (running), metres (throwing), or centimetres (jumping).

    need to think about and test 1500m dash, where there is hundredth of a second in results...
    */
    public int trackScore (double a, double b, double p, double c){

        double x = b - p;
        double z = Math.pow(x, c);
        int points = (int)Math.round(a * z); // Need
        return points;
    }

    public int fieldScore (double a, double b, double p, double c){

        double x = p - b;
        double z = Math.pow(x, c);
        int points = (int)Math.round(a * z);
        return points;

    }

}
