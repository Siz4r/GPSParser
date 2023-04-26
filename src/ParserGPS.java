import java.util.Objects;
import java.util.Scanner;

public class ParserGPS {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Wprowadź dane NMEA:");
            String input;
            while (!Objects.equals(input = scanner.nextLine(), "END")) {
                parseNMEA(input);
            }
            scanner.close();
            System.out.println(new GPGLL());
        }

        private static void parseNMEA(String input) {
            String[] parts = input.split(",");
            String dataType = parts[0];
            switch (dataType) {
                case "$GPRMC" -> new GPRMC().parse(parts);
                case "$GPGGA" -> new GPGGA().parse(parts);
                case "$GPGSA" -> new GPGSA().parse(parts);
                case "$GPGSV" -> new GPGSV().parse(parts);
                case "$GPGLL" -> new GPGLL().parse(parts);
                default -> System.out.println("Nieznany format danych.");
            }
        }

}
