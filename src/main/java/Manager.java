public class Manager extends Employee {

    public Manager(int idNo, String f_name, String l_name, int phoneNo, Address address, float numWorkHours) {
        super(idNo, Employee.MANAGER, f_name, l_name, phoneNo, address, numWorkHours);
    }

}
