package engine;

public class ScoreCalculator {
    public static int trackScore(double a, double b, double c, Double p) {
        double x = Math.abs(b - p);
        return  (int) Math.round(a * Math.pow(x, c));
   }
    public static int fieldScore(double a, double b, double c, Double p) {
        double x = Math.abs(p - b);
        return (int) Math.round(a * Math.pow(x, c));
    }
    public static int jumpScore(double a, double b, double c, Double p) {
        p *= 100;
        double x = Math.abs(p - b);
        return (int) Math.round(a * Math.pow(x, c));
    }
}


//  performance = performance.trim( ).replaceAll("[^\\d.]", ".");
//
//        while (performance.contains("..")) {
//            performance = performance.replace("..", ".");

// Should take in values from EventParameters, EventResults and model.Athlete and calculate score and place using
// given formulae.

    /* The 2001 IAAF points tables use the following formulae:

     Points = INT(A((B — P)powC)) for track events (faster time produces a better score)
     Points = INT(A((P — B)powC)) for field events (greater distance or height produces a better score)
     A, B and C are parameters that vary by discipline, as shown in the table on the right, while P is the performance by the athlete,
     measured in seconds (running), metres (throwing), or centimetres (jumping).

     need to think about and test 1500m dash, where there is hundredth of a second in results...
     */