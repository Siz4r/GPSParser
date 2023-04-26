public class GPGGA extends GPSReader {

    @Override
    public void parse(String[] data) {
        ParsedData.getParsedData().put(Parametry.WYSOKOSC_GEOID, data[9] + " " + data[10]);
        ParsedData.getParsedData().put(Parametry.DLUGOSC, data[4] + " " + data[5]);
        ParsedData.getParsedData().put(Parametry.SUMA, data[data.length - 1]);
        ParsedData.getParsedData().put(Parametry.SZEROKOSC, data[2] + " " + data[3]);
        ParsedData.getParsedData().put(Parametry.POMIAR, data[6]);
        ParsedData.getParsedData().put(Parametry.SLEDZONE_SATELITY, data[7]);
        ParsedData.getParsedData().put(Parametry.PRECYZJA_H, data[8]);
        ParsedData.getParsedData().put(Parametry.WYSOKOSC, data[9] + " " + data[10]);
        ParsedData.getParsedData().put(Parametry.CZAS, data[1]);
    }
}
