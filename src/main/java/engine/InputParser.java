package engine;

import dto.DataDto;

import java.io.File;
import java.util.List;

public interface InputParser {
    String[][] parseInput();
    DataDto[] normalizeData(String[][] data);
}
