import com.sun.xml.internal.bind.v2.TODO;

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
    public int trackScore(double a, double b, String performance, double c) {

        // TODO: 21.02.2018  check for performance input delimiter type(comma, dot etc..)

        performance = performance.trim( ).replaceAll("[^\\d.]", ".");//trims beginning + end and
        // replaces all non-digit chars in string with "." which results a string with only digits and dots

        while (performance.contains("..")) {
            performance = performance.replace("..", ".");//finds all occurances of ".." and replaces them with "." until there is none
        }

        double p = Double.parseDouble(performance);
        double x = b - p;
        double z = Math.pow(x, c);
        int points = (int) Math.round(a * z);
        return points;
    }

    public int fieldScore(double a, double b, String performance, double c) {

        performance = performance.trim( ).replaceAll("[^\\d.]", ".");

                while (performance.contains("..")) {
            performance = performance.replace("..", ".");

        }
        double p = Double.parseDouble(performance);
        double x = p - b;
        double z = Math.pow(x, c);
        int points = (int) Math.round(a * z);
        return points;
    }
}
