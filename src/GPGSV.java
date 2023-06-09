import java.time.temporal.ValueRange;

public class GPGSV extends GPSReader{
    private int liczbaLinii;

    private int poprzedniaLinia = 1;

    public void parse(String[] data) {
        setLiczbaLinii(Integer.parseInt(data[1]));
        int linia = Integer.parseInt(data[2]);

        if (checkGSVLine(linia)) {
            setPoprzedniaLinia(linia);
            ParsedData.getParsedData().put(Parametry.SUMA, data[data.length - 1]);
            ParsedData.getParsedData().put(Parametry.WIDOCZNE_SATELITY, data[3]);
            ParsedData.getParsedData().put(Parametry.SLEDZONE_SATELITY, data[3]);


            for (int i = 4; i < data.length - 4; i += 4) {
                if (ParsedData.getParsedData().get(Parametry.ID_SATELITY).equals("BRAK")) {
                    ParsedData.getParsedData().put(Parametry.ID_SATELITY, data[i]);
                    ParsedData.getParsedData().put(Parametry.WYNIESIENIE, data[i + 1]);
                    ParsedData.getParsedData().put(Parametry.AZYMUT, data[i + 2]);
                    ParsedData.getParsedData().put(Parametry.SNR, data[i + 3]);
                } else {
                    ParsedData.getParsedData().put(Parametry.ID_SATELITY, ParsedData.getParsedData().get(Parametry.ID_SATELITY) + ", " + data[i]);
                    ParsedData.getParsedData().put(Parametry.WYNIESIENIE, ParsedData.getParsedData().get(Parametry.WYNIESIENIE) + ", " + data[i]);
                    ParsedData.getParsedData().put(Parametry.AZYMUT, ParsedData.getParsedData().get(Parametry.AZYMUT) + ", " + data[i]);
                    ParsedData.getParsedData().put(Parametry.SNR, ParsedData.getParsedData().get(Parametry.SNR) + ", " + data[i]);
                }
            }
        }


    }

    private boolean checkGSVLine(int linia) {
        return linia == 1 || linia - 1 == poprzedniaLinia &&
                (linia <= liczbaLinii &&
                        ValueRange.of(0, 3).isValidValue(linia));
    }

    public void setPoprzedniaLinia(int poprzedniaLinia) {
        this.poprzedniaLinia = poprzedniaLinia;
    }

    public void setLiczbaLinii(int liczbaLinii) {
        this.liczbaLinii = liczbaLinii;
    }
}
