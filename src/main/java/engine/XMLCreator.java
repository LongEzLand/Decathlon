package engine;

import model.Athlete;
import model.EventResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class XMLCreator implements DocumentCreator {
    @Override
    public void createDocument(List<Athlete> athletes) {

        try {
            DocumentBuilderFactory dbFactory =
                DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element rootElement = doc.createElement("decathlon_results");
            doc.appendChild(rootElement);

            Element athletesElement = doc.createElement("athletes");
            rootElement.appendChild(athletesElement);

            for (Athlete athlete : athletes) {
                Element athleteElement = doc.createElement("athlete");
                Element name = doc.createElement("name");

                name.appendChild(doc.createTextNode(athlete.getAthleteName()));
                athleteElement.appendChild(name);

                Element score = doc.createElement("score");
                score.appendChild(doc.createTextNode(String.valueOf(athlete.getScore())));
                athleteElement.appendChild(score);

                Element place = doc.createElement("place");
                place.appendChild(doc.createTextNode(String.valueOf(athlete.getPlace())));
                athleteElement.appendChild(place);

                Element disciplines = doc.createElement("disciplines");

                for (EventResult event : athlete.getEventResults()){
                    Element discipline = doc.createElement(event.getEvent().name());
                    discipline.appendChild(doc.createTextNode(String.valueOf(event.getValue())));
                    disciplines.appendChild(discipline);
                }
                athleteElement.appendChild(disciplines);
                athletesElement.appendChild(athleteElement);
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("C:\\Users\\Lazarus\\Music/test.xml"));
            transformer.transform(source, result);

            // Output to console for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
