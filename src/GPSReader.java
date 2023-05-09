import java.util.Map;

public abstract class GPSReader {
    @Override
    public String toString() {
        var dataForRead = new StringBuilder(10000);
        dataForRead.append("Informacje systemowe:\n");
        for (Map.Entry<Parametry, String> record :
                ParsedData.getParsedData().entrySet()) {
            dataForRead.append(record.getKey().name)
                    .append(record.getValue().equals("BRAK") ?
                            "BRAK" : record.getKey().mappingFunction.apply(record.getValue())).append("\n");
        }

        return dataForRead.toString();
    }

    static void parseNMEA(String input) {
        String[] parts = input.split(",");
        String dataType = parts[0];
        try {
            if (GPSReader.validNmeaChecksum(input)) {
                switch (dataType) {
                    case "$GPRMC" -> new GPRMC().parse(parts);
                    case "$GPGGA" -> new GPGGA().parse(parts);
                    case "$GPGSA" -> new GPGSA().parse(parts);
                    case "$GPGSV" -> new GPGSV().parse(parts);
                    case "$GPGLL" -> new GPGLL().parse(parts);
                    case "$GPVTG" -> new GPVTG().parse(parts);
                    default -> System.out.println("Nieznany format danych.");
                }
            } else {
                System.out.println("Zla checksuma");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Zly format");
        }
    }

    static boolean validNmeaChecksum(String nmeaSentence) {
        String[] splitSentence = nmeaSentence.split("\\*");
        String sentenceWithoutChecksum = splitSentence[0];
        String checksumString = splitSentence[1];

        int correctChecksum = computeNmeaChecksum(sentenceWithoutChecksum);
        int actualChecksum = Integer.parseInt(checksumString, 16);

        return correctChecksum == actualChecksum;
    }

    private static int computeNmeaChecksum(String sentenceWithoutChecksum) {
        int checksum = sentenceWithoutChecksum.charAt(1);

        for (int i = 2; i < sentenceWithoutChecksum.length(); i++) {
            checksum = checksum ^ sentenceWithoutChecksum.charAt(i);
        }

        checksum = checksum & 0xff;

        return checksum;
    }
}
