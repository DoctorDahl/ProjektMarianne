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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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




    /**************************************
     *  Reading from CSV-formatted files  *
     **************************************/

    public List<Child> readChildren() throws IOException {
        List<Child> children = new ArrayList<>();
        Path path = Paths.get("src/main/resources/Børn.csv");
        if(Files.exists(path)) {
            List<String[]> childArray = readCSV(path);
            for (String[] a : childArray) {
                children.add(new Child(a));
            }
        }
        return children;
    }

    public List<Employee> readEmployees() throws IOException {
        List<Employee> employees = new ArrayList<>();
        Path path = Paths.get("src/main/resources/Medarbejdere.csv");
        if(Files.exists(path)) {
            List<String[]> employeeArray = readCSV(path);
            for (String[] a : employeeArray) {
                Employee employee;
                switch (a[0]) {
                    case "Manager":
                        employee = new Manager(a[0], a[1], a[2], a[3], a[4]);
                        break;
                    case "FullTimeEmployee":
                        employee = new FullTimeEmployee(a[0], a[1], a[2], a[3], a[4]);
                        break;
                    case "PartTimeEmployee":
                        employee = new PartTimeEmployee(a[0], a[1], a[2], a[3], a[4], Float.parseFloat(a[5]));
                        break;
                    default:
                        throw new IOException("Wrong format for Medarbejdere.csv");
                }
                employees.add(employee);
            }
        }
        return employees;
    }

    public List<Roster> readRosters() throws IOException { //TODO - Test that this actually works...
        List<Roster> rosters = new ArrayList<>();
        File rosterFolder = new File("src/main/resources/Vagtplaner/");
        File[] listOfRosters = rosterFolder.listFiles();
        for(File file : listOfRosters) {
            List<String[]> rosterArray = readCSV(file.toPath());
            rosters.add(new Roster(rosterArray));
        }
        return rosters;
    }

    public Map<String,String> readLogins() throws IOException {
        Map<String,String> logins = new HashMap<>();
        Path path = Paths.get("src/main/resources/Logins.csv");
        if(Files.exists(path)) {
            List<String[]> loginArray = readCSV(path);
            for (String[] login : loginArray) {
                logins.put(login[0], login[1]);
            }
        }
        return logins;
    }




    /************************************
     *  Writing to CSV-formatted files  *
     ************************************/

    public void saveAll(Kindergarten kindergarten) throws IOException {
        saveChildren(kindergarten);
        saveEmployees(kindergarten);
        saveRosters(kindergarten);
        saveLogins(kindergarten);
    }

    public void saveChildren(Kindergarten kindergarten) throws IOException {
        Path path = Paths.get("src/main/resources/Børn.csv");
        List<String[]> childArray = new ArrayList<>();
        for(Child child : kindergarten.getChildren()) {
            childArray.add(child.getAllInfo());
        }
        writeCSV(childArray, path);
    }

    public void saveEmployees(Kindergarten kindergarten) throws IOException {
        Path path = Paths.get("src/main/resources/Medarbejdere.csv");
        List<String[]> employeeArray = new ArrayList<>();
        for(Employee employee : kindergarten.getEmployees()) {
            employeeArray.add(employee.getAllInfo());
        }
        writeCSV(employeeArray, path);
    }

    public void saveRosters(Kindergarten kindergarten) throws IOException {
        Path path;
        List<String[]> rosterArray;
        for(Roster roster : kindergarten.getRosters()) {
            rosterArray = roster.getRoster();
            path = Paths.get("src/main/resources/Vagtplaner/År" + rosterArray.get(0)[0] + ".csv");
            writeCSV(rosterArray, path);
        }
    }

    public void saveLogins(Kindergarten kindergarten) throws IOException {
        Path path = Paths.get("src/main/resources/Logins.csv");
        List<String[]> loginArray = new ArrayList<>();

        for(Map.Entry<String,String> entry : kindergarten.getLogins().entrySet()) {
            String[] login = {entry.getKey(),entry.getValue()};
            loginArray.add(login);
        }
        writeCSV(loginArray, path);
    }

}
