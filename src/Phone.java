public class Phone {
    private final String country_code, area_code, number;

    public Phone(String country_code, String area_code, String number) {
        this.country_code = country_code;
        this.area_code = area_code;
        this.number = number;
    }

    public String getPhoneNumber(){
        return country_code + " " + area_code + " " + number;
    }
}
