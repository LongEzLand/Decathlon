package engine;

import dto.DataDto;
import events.Event;
import model.Athlete;
import model.EventResult;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static List<Athlete> convertToAthlete(DataDto[] dto) {
        List<Athlete> athletes = new ArrayList<>();

        for (int i = 0; i < dto.length; i++) {
            Athlete athlete = new Athlete();
            athlete.setAthleteName(dto[i].name);
            Event[] disciplines = Event.values();
            for (int j = 0; j < disciplines.length; j++) {
                Event disc = disciplines[j];
                athlete.getEventResults().add(
                    EventResult.get(disc, dto[i].data[disc.ordinal() + 1])
                );
            }
            athletes.add(athlete);
        }
        return athletes;
    }
}

