import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Path path = Paths.get("src/main/resources/children.csv");
        CSV_Handler csv_Handler = new CSV_Handler();
        List<String[]> values;

        try {
            values = csv_Handler.readCSV(path);

            for(String[] arr : values) {
                System.out.println(Arrays.toString(arr));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
