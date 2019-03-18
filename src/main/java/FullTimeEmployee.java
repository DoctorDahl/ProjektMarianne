public class FullTimeEmployee extends Employee {

    public FullTimeEmployee(String idNo, String f_name, String l_name, String phoneNo, String address) {
        super(Employee.STAFF, idNo, f_name, l_name, phoneNo, address, Employee.FULLTIMEHOURS);
    }

    protected String getType() {
        return "FullTimeEmployee";
    }

}
