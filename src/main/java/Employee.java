public abstract class Employee {

    protected static final int STAFF = 0;
    protected static final int MANAGER = 1;
    protected static final float FULLTIMEHOURS = 37.0f;

    private int clearanceLvl; //'0' for normal staff - '1' for Manager
    private final String idNo;
    private String f_name;
    private String l_name;
    private String phoneNo;
    private String address;
    private float numWorkHours;

    protected Employee(int clearanceLvl, String idNo, String f_name, String l_name, String phoneNo, String address, float numWorkHours){
        this.clearanceLvl = clearanceLvl;
        this.idNo = idNo;
        this.f_name = f_name;
        this.l_name = l_name;
        this.phoneNo = phoneNo;
        this.address = address;
        this.numWorkHours = numWorkHours;
    };

    protected abstract String getType();


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

    public int getClearanceLvl() { return clearanceLvl; }
    public void setClearanceLvl(int clearanceLvl) { this.clearanceLvl = clearanceLvl; }

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
