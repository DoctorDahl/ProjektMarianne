public class Address {

    private String streetAddress;
    private int postNo;
    private String city;

    public Address (String streetAddress, int postNo, String city) {
        this.streetAddress = streetAddress;
        this.postNo = postNo;
        this.city = city;
    }

    public String getStreetAddress() { return streetAddress; }
    public void setStreetAddress(String streetAddress) { this.streetAddress = streetAddress; }

    public int getPostNo() { return postNo; }
    public void setPostNo(int postNo) { this.postNo = postNo; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    @Override
    public String toString() {
        return this.streetAddress + "\n" + postNo + " " + city;
    }

}
