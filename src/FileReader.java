import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {
    public static void readFile(String path) {
        try {
            System.out.println("Reading Lines");
            var allLines = Files.readAllLines(Path.of(path));

            for (String line :
                    allLines) {
                System.out.println(":::::: " + line + " ::::::");
                GPSReader.parseNMEA(line);
            }

            System.out.println("File read!");
        } catch (IOException e) {
            System.out.println("Error while reading a file");
            e.printStackTrace();
        }
    }
}
