import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        Path path = Paths.get("src/main/resources/testA.csv");
        CSV_Handler csv_Handler = new CSV_Handler();

        try {
            csv_Handler.readCSV(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
