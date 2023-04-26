public class GPRMC extends GPSReader{
    @Override
    public void parse(String[] data) {
        ParsedData.getParsedData().put(Parametry.DATA, data[9]);
        ParsedData.getParsedData().put(Parametry.CZAS, data[1]);
        ParsedData.getParsedData().put(Parametry.ODCHYLENIE, data[10]);
        ParsedData.getParsedData().put(Parametry.SUMA, data[data.length - 1]);
        ParsedData.getParsedData().put(Parametry.SZEROKOSC, data[3] + " " + data[4]);
        ParsedData.getParsedData().put(Parametry.DLUGOSC, data[5] + " " + data[6]);
        ParsedData.getParsedData().put(Parametry.PREDKOSC, data[7]);
        ParsedData.getParsedData().put(Parametry.KAT, data[8]);
        ParsedData.getParsedData().put(Parametry.STATUS, data[2]);
    }
}
