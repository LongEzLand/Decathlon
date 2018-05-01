package events;
import engine.ScoreCalculator;

public class JumpEvent extends FieldEvent{
    public JumpEvent(double a, double b, double c) {
        super(a,b,c);
    }

    @Override
    public Integer getCalculations(Double performance) {
        return ScoreCalculator.jumpScore(a, b, c, performance);
    }

}
