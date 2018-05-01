package events;


import engine.ScoreCalculator;

public class FieldEvent extends BaseEvent {
    public FieldEvent(double a, double b, double c) {
        super(a,b,c);
    }

    @Override
    public Integer getCalculations(Double performance) {
        return ScoreCalculator.fieldScore(a, b, c, performance);
    }
}
