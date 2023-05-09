import java.io.File;
import java.util.Objects;
import java.util.Scanner;

public class ParserGPS {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Wprowadź dane NMEA:");
            String input;
            while (!Objects.equals(input = scanner.nextLine(), "END")) {
                if (input.contains(File.separator)) {
                    FileReader.readFile(input);
                } else {
                    GPSReader.parseNMEA(input);
                }
            }
            scanner.close();
            System.out.println(new GPGLL());
        }
}
