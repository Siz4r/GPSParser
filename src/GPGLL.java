public class GPGLL extends GPSReader{
    public void parse(String[] data) {
        // Wypisz informacje systemowe
        ParsedData.getParsedData().put(Parametry.CZAS_USTALANIA_POZYCJI, data[5]);
        ParsedData.getParsedData().put(Parametry.SUMA, data[data.length - 1]);
        ParsedData.getParsedData().put(Parametry.SZEROKOSC, data[1] + " " + data[2]);
        ParsedData.getParsedData().put(Parametry.DLUGOSC, data[3] + " " + data[4]);
        ParsedData.getParsedData().put(Parametry.STATUS, data[6]);
    }
}
