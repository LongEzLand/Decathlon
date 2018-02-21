public class EventResult {
    private Event event;
    private double value;

    public EventResult(Event event, double value) {
        this.event = event;
        this.value = value;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
