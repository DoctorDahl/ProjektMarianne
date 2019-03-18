public class FullTimeEmployee extends Employee {

    public FullTimeEmployee(String idNo, String f_name, String l_name, String phoneNo, String address) {
        super("FullTimeEmployee", idNo, f_name, l_name, phoneNo, address, Employee.FULLTIMEHOURS);
    }

}
