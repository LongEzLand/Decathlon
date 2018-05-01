package engine;

import dto.DataDto;
import engine.InputParser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Pattern;

public class CSVParser implements InputParser {
    private File file;

    public CSVParser(File file) {
        this.file = file;
    }
    public String[][] parseInput() {
        List<String[]> output = new ArrayList();
        try (FileReader fr = new FileReader(this.file);
             BufferedReader br = new BufferedReader(fr)) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null ) {
                if (!sCurrentLine.isEmpty()) {
                    String[] lineValues = sCurrentLine.trim().split(";");
                    output.add(lineValues);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output.stream().toArray(String[][]::new);
    }

    private boolean isMinutes(String a) {
        return a.split(Pattern.quote(".")).length > 2;
    }

    public DataDto[] normalizeData(String [][] data) {
        DataDto[] output = new DataDto[data.length];
        for (int i = 0; i < data.length; i++) {
            Double[] parsedData = new Double[data[i].length];
            for (int j = 1; j < data[i].length; j++) {
                if (isMinutes(data[i][j])) {
                   String[] timeUnit =  data[i][j].split(Pattern.quote("."));
                   Double min = Double.parseDouble(timeUnit[0]) * 60;
                   Double sec = Double.parseDouble(timeUnit[1] + "." + timeUnit[2]);
                   data[i][j] = String.valueOf(min + sec);
                }
                parsedData[j] = Double.parseDouble(data[i][j]);
            }
            output[i] = new DataDto(parsedData, data[i]);
        }
        return output;
    }
}
