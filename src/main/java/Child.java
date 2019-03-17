public class Child {

    private final String socialSecNo;
    private String f_name, l_name;
    private String specialConditions;
    private String parent1Name,parent2Name;
    private String parent1Phone, parent2Phone;
    private Address address, parent1Address, parent2Address;

    public Child(String[] childInfo) throws Exception {

        if(childInfo.length != 11) {
            throw new Exception("Wrong format for childInfo");
        }

        this.socialSecNo = childInfo[0];
        this.f_name = childInfo[1];
        this.l_name = childInfo[2];
        this.specialConditions = childInfo[3];
        this.address = new Address(childInfo[4]);
        this.parent1Name = childInfo[5];
        this.parent1Phone = childInfo[6];
        this.parent1Address = new Address(childInfo[7]);
        this.parent2Name = childInfo[8];
        this.parent2Phone = childInfo[9];
        this.parent2Address = new Address(childInfo[10]);

    }


    /************************************
     *      Accessors and Mutators      *
     ************************************/

    public String getSocialSecNo() { return socialSecNo; }

    public String getF_name() { return f_name; }
    public void setF_name(String f_name) { this.f_name = f_name; }

    public String getL_name() { return l_name; }
    public void setL_name(String l_name) { this.l_name = l_name; }

    public String getSpecialConditions() { return specialConditions; }
    public void setSpecialConditions(String specialConditions) { this.specialConditions = specialConditions; }

    public String getParent1Name() { return parent1Name; }
    public void setParent1Name(String parent1Name) { this.parent1Name = parent1Name; }

    public String getParent2Name() { return parent2Name; }
    public void setParent2Name(String parent2Name) { this.parent2Name = parent2Name; }

    public String getParent1Phone() { return parent1Phone; }
    public void setParent1Phone(String parent1Phone) { this.parent1Phone = parent1Phone; }

    public String getParent2Phone() { return parent2Phone; }
    public void setParent2Phone(String parent2Phone) { this.parent2Phone = parent2Phone; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    public Address getParent1Address() { return parent1Address; }
    public void setParent1Address(Address parent1Address) { this.parent1Address = parent1Address; }

    public Address getParent2Address() { return parent2Address; }
    public void setParent2Address(Address parent2Address) { this.parent2Address = parent2Address; }

}
