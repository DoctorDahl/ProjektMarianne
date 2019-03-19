import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Kindergarten {

    private CSV_Handler csv_Handler;
    private List<Child> children;
    private List<Employee> employees;
    private List<Roster> rosters;
    private Map<String,String> logins;

    public Kindergarten() throws IOException {
        csv_Handler = new CSV_Handler();
        this.children = csv_Handler.readChildren();
        this.employees = csv_Handler.readEmployees();
        this.rosters = csv_Handler.readRosters();
        this.logins = csv_Handler.readLogins();
    }

    public void enrollChild(String[] childInfo) throws IOException {
        Child child = new Child(childInfo);
        children.add(child);
        csv_Handler.writeChildren(this);
    }

    public void disenrollChild(String socialSecNo) throws IOException {
        for(Child child : children) {
            if(child.getSocialSecNo().equals(socialSecNo)) {
                children.remove(child);
                break;
            }
        }
        csv_Handler.writeChildren(this);
    }


    //TODO - Implement the following methods

    //addManager
    //addFullTimeEmployee
    //addPartTimeEmployee
    //removeEmployee

    public void createNewRoster(String year) throws IOException {
        //TODO - Check if year exists?
        Roster roster = new Roster(year);
        csv_Handler.writeRosters(this);
    }

    public void addValueRoster(String year, int weekNo, String day, String shift, String value) {
        for(Roster roster : rosters) {
            if(roster.getYear().equals(year)) {
                String currentShift = roster.getShift(weekNo, day, shift);
                currentShift += ","+value;
            } else {
                //TODO - Roster doesn't exist
            }
        }
    }

    public void removeValueRoster(String year, int weekNo, String day, String shift, String value) {
        for(Roster roster : rosters) {
            if(roster.getYear().equals(year)) {
                /*
                String[] currentShift = roster.getShift(weekNo, day, shift);

                for(String empID : currentShift) {
                    if(empID.equals(value)) {
                        ...
                    }
                }
                */
                String currentShift = roster.getShift(weekNo, day, shift);
                if(currentShift.contains(","+value)) {
                    currentShift.replace(","+value,"");
                } else {
                    currentShift.replace(value+",","");
                }

            } else {
                //TODO - Roster doesn't exist
            }
        }
    }

    public void updateRoster(String year) throws IOException {
        for(Roster roster : rosters) {
            if(roster.getYear().equals(year)) {

            }
        }
    }

    //createNewLogin
    //removeLogin


    /***********************************
     *            Accessors            *
     ***********************************/

    public List<Child> getChildren() { return children; }
    public List<Employee> getEmployees() { return employees; }
    public List<Roster> getRosters() { return rosters; }
    public Map<String, String> getLogins() { return logins; }

}
