public class PartTimeEmployee extends Employee {

    public PartTimeEmployee(String idNo, String f_name, String l_name, String phoneNo, String address, float numWorkHours) {
        super(Employee.STAFF, idNo, f_name, l_name, phoneNo, address, numWorkHours);
    }

    protected String getType() {
        return "PartTimeEmployee";
    }

}
