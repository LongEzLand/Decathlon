package events;

import engine.ScoreCalculator;

public class TrackEvent extends BaseEvent{
    public TrackEvent(double a, double b, double c) {
        super(a,b,c);
    }

    @Override
    public Integer getCalculations(Double performance) {
        return ScoreCalculator.trackScore(a, b, c, performance);
    }
}

