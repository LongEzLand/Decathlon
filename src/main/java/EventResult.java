public class EventResult {
    private Event event;
    private String value;

    public EventResult(Event event, String value) {
        this.event = event;
        this.value = value;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
