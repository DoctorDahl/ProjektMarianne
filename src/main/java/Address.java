public class Address {

    private String streetAddress;
    private String postNo;
    private String city;

    public Address (String addressAsString) {
        String[] address = addressAsString.split(",");
        this.streetAddress = address[0];
        this.postNo = address[1];
        this.city = address[2];
    }

    public Address (String streetAddress, String postNo, String city) {
        this.streetAddress = streetAddress;
        this.postNo = postNo;
        this.city = city;
    }


    /************************************
     *      Accessors and Mutators      *
     ************************************/

    public String getStreetAddress() { return streetAddress; }
    public void setStreetAddress(String streetAddress) { this.streetAddress = streetAddress; }

    public String getPostNo() { return postNo; }
    public void setPostNo(String postNo) { this.postNo = postNo; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

}
