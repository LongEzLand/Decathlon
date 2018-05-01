import engine.*;
import events.BaseEvent;
import model.Athlete;
import model.EventResult;
import java.util.List;


public class Decathlon {
    public static void main(String[] args) {
        InputParser parser = ParserFactory.get("results.csv");
        DocumentCreator documentCreator = DocumentFactory.get(args);
        String[][] unmodifiedData = parser.parseInput();

        List<Athlete> athletes = Converter.convertToAthlete(parser.normalizeData(unmodifiedData));
        for (Athlete athlete : athletes) {
            for (EventResult result : athlete.getEventResults()) {
                BaseEvent baseEvent = BaseEvent.getEvent(result.getEvent());
                Integer calculatedResultForAthlete = baseEvent.getCalculations(result.getValue());
                athlete.setScore(calculatedResultForAthlete + athlete.getScore());
            }
        }
        documentCreator.createDocument(athletes);


    }
}







