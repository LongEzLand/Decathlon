public class EventParameters {///Class
    private double a;
    private double b;
    private double c;
    private Boolean isTrackEvent;

    public Boolean getIsTrackEvent() {
        if (isTrackEvent){
            return true;
        }else return false;
    }


    public EventParameters(Boolean isTrackEvent, double a, double b, double c) {//constructor
        this.a = a;
        this.b = b;
        this.c = c;
        this.isTrackEvent = isTrackEvent;

    }

    public double getA() { // getterMethod
        return a;
    }

    public void setA(double a) { this.a = a; }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) { this.c = c; }

    public static EventParameters getEventParameters(Event originalEvent) {
        EventParameters event = null;

        switch (originalEvent) {
            case HUNDREDDASH:
                event = new EventParameters(true, 25.4347, 18.00, 1.81);
                break;
            case LONGJUMP:
                event = new EventParameters(false,0.14354, 220, 1.4);
                break;
            case SHOTPUT:
                event = new EventParameters(false, 51.39, 1.5, 1.05);
                break;
            case HIGHJUMP:
                event = new EventParameters(false, 0.8465, 75, 1.42);
                break;
            case FOURHUNDREDDASH:
                event = new EventParameters(true, 1.53775, 82, 1.81);
                break;
            case HUNDRETENHURDLES:
                event = new EventParameters(true, 5.74352, 28.5, 1.92);
                break;
            case DISCUSTHROW:
                event = new EventParameters(false,12.91, 4, 1.1);
                break;
            case POLEVAULT:
                event = new EventParameters(false, 0.2797, 100, 1.35);
                break;
            case JAVELINTHROW:
                event = new EventParameters(false, 10.14, 7, 1.08);
                break;
            case THOUSANDFIVEHUNDRED:
                event = new EventParameters(true, 0.03768, 480, 1.85);
                break;

        }

        return event;
    }
}
