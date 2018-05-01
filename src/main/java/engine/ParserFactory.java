package engine;

import java.io.File;

public class ParserFactory {

    public static File read(String fileName) {
        ClassLoader classLoader = ParserFactory.class.getClassLoader();
        return new File(classLoader.getResource(fileName).getFile());
    }

    public static InputParser get(String fileName) {
        if (!fileName.isEmpty()) {
            return new CSVParser(read(fileName));
        }
        return new CSVParser(read(fileName));
    }
}
