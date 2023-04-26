import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParsedData {
    private static Map<Parametry, String> parsedData;

    public static Map<Parametry, String> getParsedData() {
        if (parsedData == null) {
            return (parsedData =  Stream.of(Parametry.DATA, Parametry.CZAS, Parametry.ODCHYLENIE, Parametry.WYSOKOSC_GEOID, Parametry.OKRESLENIE_POZYCJI,
                            Parametry.POMIAR, Parametry.SUMA, Parametry.SZEROKOSC, Parametry.DLUGOSC, Parametry.PREDKOSC, Parametry.KAT, Parametry.WYSOKOSC,
                            Parametry.PRECYZJA_H, Parametry.PRECYZJA_W, Parametry.PRECYZJA_O, Parametry.SLEDZONE_SATELITY, Parametry.NUMERY_SATELITOW,
                            Parametry.STATUS, Parametry.CZAS_USTALANIA_POZYCJI, Parametry.WIDOCZNE_SATELITY, Parametry.ID_SATELITY, Parametry.WYNIESIENIE,
                            Parametry.AZYMUT, Parametry.SNR)
                    .collect(Collectors.toMap(k -> k, v -> "BRAK")));
        }

        return parsedData;
    }

    private ParsedData() {
    }
}
