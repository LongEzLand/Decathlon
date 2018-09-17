package engine;

import model.Athlete;
import model.EventResult;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;
import java.util.Map;

public class XML implements Document {
    private static final String OUTPUT_PATH = "\\";

    @Override
    public void createDocument(Map<Integer, List<Athlete>> mappedAthletes) {
        try {
            DocumentBuilderFactory dbFactory =
                DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            org.w3c.dom.Document doc = dBuilder.newDocument();

            Element rootElement = doc.createElement("decathlon_results");
            doc.appendChild(rootElement);

            Element positions = doc.createElement("positions");
            rootElement.appendChild(positions);

            int i = 0; // Placement helper (since all of the values are in TreeMap, which is ordered map)

            for (Map.Entry<Integer, List<Athlete>> pair : mappedAthletes.entrySet()) {
                int score = pair.getKey();
                List<Athlete> athletes = pair.getValue();

                Element position = doc.createElement("position");
                positions.appendChild(position);

                Element placeElement = doc.createElement("place");
                placeElement.appendChild(doc.createTextNode(String.valueOf(++i)));
                position.appendChild(placeElement);

                Element scoreElement = doc.createElement("score");
                scoreElement.appendChild(doc.createTextNode(String.valueOf(score)));
                position.appendChild(scoreElement);

                Element athletesListElement = doc.createElement("athletes");
                position.appendChild(athletesListElement);

                for (Athlete athleteIterator : athletes) {
                    Element athlete = athleteElement(doc, athleteIterator);
                    athletesListElement.appendChild(athlete);
                }
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(OUTPUT_PATH));
            transformer.transform(source, result);

            // Output to console for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private Element athleteElement(org.w3c.dom.Document doc,
                                 Athlete athlete) {
        Element athleteElement = doc.createElement("athlete");
        Element name = doc.createElement("name");

        name.appendChild(doc.createTextNode(athlete.getAthleteName()));
        athleteElement.appendChild(name);

        Element disciplines = doc.createElement("disciplines");

        for (EventResult event : athlete.getEventResults()){
            Element discipline = doc.createElement(event.getEvent().name());
            discipline.appendChild(doc.createTextNode(String.valueOf(event.getValue())));
            disciplines.appendChild(discipline);
        }
        athleteElement.appendChild(disciplines);

        return athleteElement;
    }
}
