public class FullTimeEmployee extends Employee {

    public FullTimeEmployee(int idNo, String f_name, String l_name, String phoneNo, String address) {
        super(idNo, Employee.STAFF, f_name, l_name, phoneNo, address, Employee.FULLTIMEHOURS);
    }

}
