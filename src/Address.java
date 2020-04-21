public class Address {
    private final String street, no, town, city, country;

    public Address(String street, String no, String town, String city, String country) {
        this.street = street;
        this.no = no;
        this.town = town;
        this.city = city;
        this.country = country;
    }

    public String getAddress(){
        return street+" "+no+" "+town+" "+city+" "+country;
    }
}
