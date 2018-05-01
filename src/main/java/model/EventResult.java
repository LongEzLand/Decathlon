package model;

import events.Event;

public class EventResult {
    private Event event;
    private Double value;


    public EventResult(Event event, Double value) {
        this.event = event;
        this.value = value;
    }

    public static EventResult get(Event event, Double value){
        return new EventResult(event, value);
    }

    public Event getEvent() { return event; }

    public Double getValue() {
        return value;
    }

}
