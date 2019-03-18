import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Kindergarten {

    private static CSV_Handler csv_Handler;
    public static List<Child> children;
    public static List<Employee> employees;
    public static List<Roster> rosters;
    public static Map<String,String> logins;

    public Kindergarten() {
        Kindergarten.csv_Handler = new CSV_Handler();
        try {
            Kindergarten.loadAll();
        } catch (IOException e) {
            //TODO - Handle the caught exception.
        }
    }


    /**************************************
     *  Loading from CSV-formatted files  *
     **************************************/

    public static void loadAll() throws IOException {
        loadChildren();
        loadEmployees();
        loadRosters();
        loadLogins();
    }

    public static void loadChildren() throws IOException {
        Path path = Paths.get("src/main/resources/Børn.csv");
        List<String[]> childArray = csv_Handler.readCSV(path);

        for(String[] a : childArray) {
            children.add(new Child(a));
        }
    }

    public static void loadEmployees() throws IOException {

        Path path = Paths.get("src/main/resources/Medarbejdere.csv");
        List<String[]> employeeArray = csv_Handler.readCSV(path);

        for(String[] a : employeeArray) {
            Employee employee;

            if (a[0].equals("Manager")) {

                employee = new Manager(a[0],a[1],a[2],a[3],a[4]);

            } else if (a[0].equals("FullTimeEmployee")){

                employee = new FullTimeEmployee(a[0],a[1],a[2],a[3],a[4]);

            } else if (a[0].equals("PartTimeEmployee")){

                employee = new PartTimeEmployee(a[0],a[1],a[2],a[3],a[4],Float.parseFloat(a[5]));

            } else {

                throw new IOException("Wrong format for Medarbejdere.csv");

            }

            employees.add(employee);
        }
    }

    public static void loadRosters() throws IOException { //TODO - Test that this actually works...
        File rosterFolder = new File("src/main/resources/Vagtplaner/");
        File[] listOfRosters = rosterFolder.listFiles();

        for(File file : listOfRosters) {
            List<String[]> rosterArray = csv_Handler.readCSV(file.toPath());
            rosters.add(new Roster(rosterArray));
        }

    }

    public static void loadLogins() throws IOException {
        Path path = Paths.get("src/main/resources/Logins.csv");
        List<String[]> loginArray = csv_Handler.readCSV(path);

        for(String[] login : loginArray) {
            logins.put(login[0],login[1]);
        }
    }

    /************************************
     *   Saving to CSV-formatted files  *
     ************************************/

    public static void saveAll() throws IOException {
        saveChildren();
        saveEmployees();
        saveRosters();
        saveLogins();
    }

    public static void saveChildren() throws IOException {
        Path path;
        List<String[]> childArray = new ArrayList<String[]>();
        for(Child child : children) {
            childArray.add(child.getAllInfo());
        }
        path = Paths.get("src/main/resources/Børn.csv");
        csv_Handler.writeCSV(childArray, path);
    }

    public static void saveEmployees() throws IOException {
        Path path;
        List<String[]> employeeArray = new ArrayList<String[]>();
        for(Employee employee : employees) {
            employeeArray.add(employee.getAllInfo());
        }
        path = Paths.get("src/main/resources/Medarbejdere.csv");
        csv_Handler.writeCSV(employeeArray, path);
    }

    public static void saveRosters() throws IOException {
        Path path;
        List<String[]> rosterArray;

        for(Roster roster : rosters) {
            rosterArray = roster.getRoster();
            path = Paths.get("src/main/resources/Vagtplaner/Uge" + rosterArray.get(0)[0] + ".csv");
            csv_Handler.writeCSV(rosterArray, path);
        }
    }

    public static void saveLogins() throws IOException {
        //TODO - Implement.
    }

}
