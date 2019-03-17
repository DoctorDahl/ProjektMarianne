public abstract class Employee {

    protected static final int STAFF = 0;
    protected static final int MANAGER = 1;
    protected static final float FULLTIMEHOURS = (float) 37.5;

    private final int idNo;
    private int clearanceLvl; //'0' for normal staff - '1' for Manager
    private String f_name;
    private String l_name;
    private int phoneNo;
    private Address address;
    private float numWorkHours;

    protected Employee(int idNo, int clearanceLvl, String f_name, String l_name, int phoneNo, Address address, float numWorkHours){
        this.idNo = idNo;
        this.clearanceLvl = clearanceLvl;
        this.f_name = f_name;
        this.l_name = l_name;
        this.phoneNo = phoneNo;
        this.address = address;
        this.numWorkHours = numWorkHours;
    };


    /************************************
     *      Accessors and Mutators      *
     ************************************/

    public int getIdNo() { return idNo; }

    public int getClearanceLvl() { return clearanceLvl; }
    public void setClearanceLvl(int clearanceLvl) { this.clearanceLvl = clearanceLvl; }

    public String getF_name() { return f_name; }
    public void setF_name(String f_name) { this.f_name = f_name; }

    public String getL_name() { return l_name; }
    public void setL_name(String l_name) { this.l_name = l_name; }

    public int getPhoneNo() { return phoneNo; }
    public void setPhoneNo(int phoneNo) { this.phoneNo = phoneNo; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    public float getNumWorkHours() { return numWorkHours; }
    public void setNumWorkHours(float numWorkHours) { this.numWorkHours = numWorkHours; }


}
