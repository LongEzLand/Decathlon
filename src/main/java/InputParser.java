import java.io.File;
import java.util.List;

public interface InputParser<T> {

    List<Athlete> parseData(File file);
}
