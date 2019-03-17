import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Path pathIn = Paths.get("src/main/resources/children.csv");
        //Path pathOut = Paths.get("src/main/resources/test2.csv");
        CSV_Handler csv_Handler = new CSV_Handler();
        List<String[]> values = null;

        try {
            values = csv_Handler.readCSV(pathIn);

            for(String[] arr : values) {
                System.out.println(Arrays.toString(arr));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
/*
        try{
            csv_Handler.writeCSV(values, pathOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
    }

}
