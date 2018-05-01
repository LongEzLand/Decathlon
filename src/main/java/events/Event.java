package events;

public enum Event {
    HUNDREDDASH(25.4347, 18.00, 1.81),
    LONGJUMP(0.14354, 220, 1.4),
    SHOTPUT (51.39, 1.5, 1.05),
    HIGHJUMP (0.8465, 75, 1.42),
    FOURHUNDREDDASH(1.53775, 82, 1.81),
    HUNDRETENHURDLES(5.74352, 28.5, 1.92),
    DISCUSTHROW(12.91, 4, 1.1),
    POLEVAULT(0.2797, 100, 1.35),
    JAVELINTHROW(10.14, 7, 1.08),
    THOUSANDFIVEHUNDRED(0.03768, 480, 1.85);

    private final double a;
    private final double b;
    private final double c;


    Event(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double a() {
        return a;
    }

    public double b() {
        return b;
    }
    public double c() {
        return c;
    }
}
