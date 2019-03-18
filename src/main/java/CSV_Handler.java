import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CSV_Handler {

    public List<String[]> readCSV(Path path) throws IOException {

        Reader reader = Files.newBufferedReader(path);
        CSVReader csvReader = new CSVReader(reader);

        List<String[]> values = csvReader.readAll();

        reader.close();
        csvReader.close();

        return values;

    }

    public void writeCSV(List<String[]> values, Path path) throws IOException {

        CSVWriter csvWriter = new CSVWriter(new FileWriter(path.toString()));
        csvWriter.writeAll(values);
        csvWriter.close();

    }

}
