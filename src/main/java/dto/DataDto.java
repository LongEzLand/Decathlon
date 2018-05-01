package dto;

public class DataDto {
    public String name;
    public Double[] data;

    public DataDto(Double[] data, String[] name) {
        this.data = data;
        this.name = name[0];
    }
}
