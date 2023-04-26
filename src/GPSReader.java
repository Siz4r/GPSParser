import java.util.Map;

public abstract class GPSReader {
    public abstract void parse(String[] data);

    @Override
    public String toString() {
        var dataForRead = new StringBuilder(10000);
        dataForRead.append("Informacje systemowe:\n");
        for (Map.Entry<Parametry, String> record :
                ParsedData.getParsedData().entrySet()) {
            dataForRead.append(record.getKey().name)
                    .append(record.getValue().equals("BRAK") ? "BRAK" : record.getKey().mappingFunction.apply(record.getValue())).append("\n");
        }

        return dataForRead.toString();
    }
}
