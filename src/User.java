public class User {
    private final String name, surname, gender;
    private int score = 0;
    private Date birthDate;
    private Phone phone;
    private Address address;

    public User(String name, String surname, String gender, Date birthDate, Phone phone, Address address) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthDate = birthDate;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void increaseScore(int num){
        score += num;
    }

    public int getScore() {
        return score;
    }
}
