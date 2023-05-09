public class GPVTG extends GPSReader{
    public void parse(String[] data) {
        ParsedData.getParsedData().put(Parametry.SCIEZKA, data[1] + data[2]);
        ParsedData.getParsedData().put(Parametry.SCIEZKA_MAGN, data[3] + data[4]);
        ParsedData.getParsedData().put(Parametry.PREDKOSC, data[5] + data[6]);
        ParsedData.getParsedData().put(Parametry.PREDKOSC_KM, data[7] + data[8].split("\\*")[0]);
    }
}
