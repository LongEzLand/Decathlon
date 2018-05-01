package events;

public class BaseEvent {
    protected double a;
    protected double b;
    protected double c;

    public static BaseEvent getEvent(Event event) {
        if (event == Event.HUNDREDDASH
                || event == Event.FOURHUNDREDDASH
                || event == Event.HUNDRETENHURDLES
                || event == Event.THOUSANDFIVEHUNDRED) {
            return new FieldEvent(event.a(), event.b(), event.c());

        } else if (event == Event.LONGJUMP
                || event == Event.HIGHJUMP
                || event == Event.POLEVAULT) {
            return new JumpEvent(event.a(), event.b(), event.c());

        } else if (event == Event.SHOTPUT
                || event == Event.DISCUSTHROW
                || event == Event.JAVELINTHROW) {
            return new TrackEvent(event.a(), event.b(), event.c());
        }
        return null;
    }

    protected BaseEvent(double a, double b, double c) {//constructor
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Integer getCalculations(Double performance){
        return null;
    }
}


