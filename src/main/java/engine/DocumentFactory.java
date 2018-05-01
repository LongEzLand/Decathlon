package engine;

public class DocumentFactory {
    public static DocumentCreator get(String[] args) {
        return new XMLCreator();
    }
}
