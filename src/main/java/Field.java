import java.util.ArrayList;
import java.util.List;

public class Field {
    String coordinate;
    String value;
    String actualvalue;


    public Field (String coordinate, String value){
        this.coordinate = coordinate;
        this.value = value;
        this.actualvalue = "X";

    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getActualvalue() {
        return actualvalue;
    }

    public void setActualvalue(String actualvalue) {
        this.actualvalue = actualvalue;
    }

    public static List<Field> createFields (List<String> wordsInGame) {
        int half = wordsInGame.size() / 2;
        int coordNumber = 1;
        List<Field> fields = new ArrayList<>();

        for (int i = 0; i < wordsInGame.size(); i++) {
            String coordChar = (i < half) ? "A" : "B";
            fields.add(new Field(coordChar + String.valueOf(coordNumber), wordsInGame.get(i)));
            if (coordNumber == half) {
                coordNumber = 0;
            }
            coordNumber++;
        }
        return fields;
    }
}
