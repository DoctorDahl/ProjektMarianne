public class PartTimeEmployee extends Employee {

    public PartTimeEmployee(int idNo, String f_name, String l_name, int phoneNo, Address address, float numWorkHours) {
        super(idNo, Employee.STAFF, f_name, l_name, phoneNo, address, numWorkHours);
    }

}
