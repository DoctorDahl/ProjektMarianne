public class Employee {

    protected static final float FULLTIMEHOURS = 37.0f;

    private String type; //Should be enum
    private final String idNo;
    private String f_name;
    private String l_name;
    private String phoneNo;
    private String address;
    private float numWorkHours;

    public Employee(String[] employeeInfo) {

        if(employeeInfo.length != 6 && employeeInfo.length != 7) {
            throw new IllegalArgumentException("String array employeeInfo must be of length 6 or 7.");
        } else {
            this.type = employeeInfo[0];
            this.idNo = employeeInfo[1];
            this.f_name = employeeInfo[2];
            this.l_name = employeeInfo[3];
            this.phoneNo = employeeInfo[4];
            this.address = employeeInfo[5];

            if (employeeInfo.length == 7) {
                this.numWorkHours = Float.parseFloat(employeeInfo[6]);
            } else {
                this.numWorkHours = FULLTIMEHOURS;
            }
        }
    }

    public String[] getAllInfo() {
        String[] employeeInfo = new String[6];
        employeeInfo[0] = getType();
        employeeInfo[1] = idNo;
        employeeInfo[2] = f_name;
        employeeInfo[3] = l_name;
        employeeInfo[4] = phoneNo;
        employeeInfo[5] = address;

        return employeeInfo;
    }

    /************************************
     *      Accessors and Mutators      *
     ************************************/

    public String getIdNo() { return idNo; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getF_name() { return f_name; }
    public void setF_name(String f_name) { this.f_name = f_name; }

    public String getL_name() { return l_name; }
    public void setL_name(String l_name) { this.l_name = l_name; }

    public String getPhoneNo() { return phoneNo; }
    public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public float getNumWorkHours() { return numWorkHours; }
    public void setNumWorkHours(float numWorkHours) { this.numWorkHours = numWorkHours; }


}
