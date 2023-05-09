import java.util.Arrays;

public class GPGSA extends GPSReader{
    public void parse(String[] data) {
        ParsedData.getParsedData().put(Parametry.OKRESLENIE_POZYCJI, data[1] + data[2]);
        ParsedData.getParsedData().put(Parametry.SUMA, data[data.length - 1]);
        ParsedData.getParsedData().put(Parametry.PRECYZJA_H, data[15]);
        ParsedData.getParsedData().put(Parametry.PRECYZJA_W, data[16]);
        ParsedData.getParsedData().put(Parametry.PRECYZJA_O, data[17]);
        ParsedData.getParsedData().put(Parametry.NUMERY_SATELITOW,
                String.join(", ", Arrays.stream(Arrays.copyOfRange(data, 3, data.length - 4)).filter(numer -> !numer.isBlank()).toList()));
    }
}
