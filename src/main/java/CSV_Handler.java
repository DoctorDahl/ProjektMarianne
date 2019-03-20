import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
//import java.util.Map;
//import java.util.HashMap;

public class CSV_Handler {

    private List<String[]> readCSV(Path path) throws IOException {
        Reader reader = Files.newBufferedReader(path);
        CSVReader csvReader = new CSVReader(reader);
        List<String[]> values = csvReader.readAll();
        reader.close();
        csvReader.close();
        return values;
    }

    private void writeCSV(List<String[]> values, Path path) throws IOException {
        CSVWriter csvWriter = new CSVWriter(new FileWriter(path.toString()));
        csvWriter.writeAll(values);
        csvWriter.close();
    }


    /**************************************
     *  Reading from CSV-formatted files  *
     **************************************/

    public List<Child> readChildren() {
        List<Child> children = new ArrayList<>();
        Path path = Paths.get("src/main/resources/Børn.csv");
        if(Files.exists(path)) {
            try {
                List<String[]> childArray = readCSV(path);
                for (String[] a : childArray) {
                    children.add(new Child(a));
                }
            } catch (IOException e) {
                System.out.println("Trouble reading Børn.csv");
            }
        }
        return children;
    }

    public List<Employee> readEmployees(){
        List<Employee> employees = new ArrayList<>();
        Path path = Paths.get("src/main/resources/Medarbejdere.csv");
        if(Files.exists(path)) {
            try {
                List<String[]> employeeArray = readCSV(path);
                for (String[] a : employeeArray) {
                    employees.add(new Employee(a));
                }
            } catch (IOException e) {
                System.out.println("Trouble reading Medarbejdere.csv");
            }
        }
        return employees;
    }

    public List<Roster> readRosters() {
        List<Roster> rosters = new ArrayList<>();
        File rosterFolder = new File("src/main/resources/Vagtplaner/");
        File[] listOfRosters = rosterFolder.listFiles();
        if(listOfRosters != null) {
            try {
                for (File file : listOfRosters) {
                    List<String[]> rosterArray = readCSV(file.toPath());
                    rosters.add(new Roster(rosterArray));
                }
            } catch (IOException e) {
                System.out.println("Trouble reading roster .csv-files");
            }
        }
        return rosters;
    }

    /*
    public Map<String,String> readLogins() {
        Map<String,String> logins = new HashMap<>();
        Path path = Paths.get("src/main/resources/Logins.csv");
        if(Files.exists(path)) {
            try {
                List<String[]> loginArray = readCSV(path);
                for (String[] login : loginArray) {
                    logins.put(login[0], login[1]);
                }
            } catch (IOException e) {
                System.out.println("Trouble reading Logins.csv");
            }
        }
        return logins;
    }
    */



    /************************************
     *  Writing to CSV-formatted files  *
     ************************************/

    public void writeChildren(Kindergarten kindergarten) {
        Path path = Paths.get("src/main/resources/Børn.csv");
        List<String[]> childArray = new ArrayList<>();
        for(Child child : kindergarten.getChildren()) {
            childArray.add(child.getAllInfo());
        }
        try {
            Files.deleteIfExists(path);
            writeCSV(childArray, path);
        } catch (IOException e) {
            System.out.println("Trouble writing to Børn.csv");
        }
    }

    public void writeEmployees(Kindergarten kindergarten) {
        Path path = Paths.get("src/main/resources/Medarbejdere.csv");
        List<String[]> employeeArray = new ArrayList<>();
        for(Employee employee : kindergarten.getEmployees()) {
            employeeArray.add(employee.getAllInfo());
        }
        try {
            Files.deleteIfExists(path);
            writeCSV(employeeArray, path);
        } catch (IOException e) {
            System.out.println("Trouble writing to Medarbejdere.csv");
        }
    }

    public void writeRosters(Kindergarten kindergarten) {
        Path path;
        List<String[]> rosterArray;
        for(Roster roster : kindergarten.getRosters()) {
            rosterArray = roster.getRoster();
            path = Paths.get("src/main/resources/Vagtplaner/År" + rosterArray.get(0)[0] + ".csv");
            try {
                Files.deleteIfExists(path);
                writeCSV(rosterArray, path);
            } catch (IOException e) {
                System.out.println("Trouble writing roster .csv files");
            }
        }
    }

    /*
    public void writeLogins(Kindergarten kindergarten) {
        Path path = Paths.get("src/main/resources/Logins.csv");
        List<String[]> loginArray = new ArrayList<>();

        for(Map.Entry<String,String> entry : kindergarten.getLogins().entrySet()) {
            String[] login = {entry.getKey(),entry.getValue()};
            loginArray.add(login);
        }
        try {
            Files.deleteIfExists(path);
            writeCSV(loginArray, path);
        } catch (IOException e) {
            System.out.println("Trouble writing to Logins.csv");
        }
    }
    */

}
