public class Manager extends Employee {

    public Manager(String idNo, String f_name, String l_name, String phoneNo, String address) {
        super(Employee.MANAGER, idNo, f_name, l_name, phoneNo, address, Employee.FULLTIMEHOURS);
    }

    protected String getType() {
        return "Manager";
    }

}
