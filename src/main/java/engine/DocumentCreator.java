package engine;

import model.Athlete;

import java.util.List;

public interface DocumentCreator {
    void createDocument(List<Athlete> athletes);
}
