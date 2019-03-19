import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
//import java.util.Map;

public class Kindergarten {

    private CSV_Handler csv_Handler;
    private List<Child> children;
    private List<Employee> employees;
    private List<Roster> rosters;
    //private Map<String,String> logins;

    public Kindergarten() {
        csv_Handler = new CSV_Handler();
        this.children = csv_Handler.readChildren();
        this.employees = csv_Handler.readEmployees();
        this.rosters = csv_Handler.readRosters();
        //this.logins = csv_Handler.readLogins();
    }

    public void enrollChild(String[] childInfo) {
        Child child = new Child(childInfo);
        children.add(child);
        csv_Handler.writeChildren(this);
    }

    public void disenrollChild(String socialSecNo) {
        for(Child child : children) {
            if(child.getSocialSecNo().equals(socialSecNo)) {
                children.remove(child);
                break;
            }
        }
        csv_Handler.writeChildren(this);
    }


    public void addEmployee(String[] employeeInfo) {
        Employee employee = new Employee(employeeInfo);
        employees.add(employee);
        csv_Handler.writeEmployees(this);
    }

    public void removeEmployee(String idNo) {
        for(Employee employee : employees) {
            if(employee.getIdNo().equals(idNo)) {
                employees.remove(employee);
                break;
            }
        }
        csv_Handler.writeEmployees(this);
    }

    public void createNewRoster(String year) {
        //TODO - Check if year exists?
        Roster roster = new Roster(year);
        rosters.add(roster);
        csv_Handler.writeRosters(this);
    }

    public void removeRoster(String year) {
        for(Roster roster : rosters) {
            if(roster.getYear().equals(year)) {
                rosters.remove(roster);
                break;
            }
        }
        try {
            Files.deleteIfExists(Paths.get("src/main/resources/Vagtplaner/År" + year + ".csv"));
        } catch (IOException e) {
            System.out.println("Trouble deleting roster file");
        }
    }

    public void addValueRoster(String year, int weekNo, String day, String shift, String value) {
        for(Roster roster : rosters) {
            if(roster.getYear().equals(year)) {
                String currentShift = roster.getShift(weekNo, day, shift);
                if(currentShift == null) {
                    roster.setShift(weekNo, day, shift, value);
                } else {
                    roster.setShift(weekNo, day, shift, currentShift + "," + value);
                }
                csv_Handler.writeRosters(this);
            }
        }
        //TODO - Roster doesn't exist
    }

    public void removeValueRoster(String year, int weekNo, String day, String shift, String value) {
        for(Roster roster : rosters) {
            if(roster.getYear().equals(year)) {
                String currentShift = roster.getShift(weekNo, day, shift);
                if(currentShift.contains(","+value)) {
                    currentShift = currentShift.replace(","+value,"");
                } else {
                    currentShift = currentShift.replace(value+",","");
                }
                roster.setShift(weekNo, day, shift, currentShift);
                csv_Handler.writeRosters(this);
            }
        }
        //TODO - Roster doesn't exist
    }

    public List<String[]> getWeekRoster(String year, int weekNo) {
        for(Roster roster : rosters) {
            if(roster.getYear().equals(year)) {
                return roster.getWeekRoster(weekNo);
            }
        }
        //TODO - Roster doesn't exist
        return null;
    }

    //createNewLogin
    //removeLogin


    /***********************************
     *            Accessors            *
     ***********************************/

    public List<Child> getChildren() { return children; }
    public List<Employee> getEmployees() { return employees; }
    public List<Roster> getRosters() { return rosters; }
    //public Map<String, String> getLogins() { return logins; }

}
