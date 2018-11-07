package entities;

public class User {

    // String login;
    String password;
    String name;
    String displayedName;

    public User(String name, String pass, String displayedName) {
        this.name = name;
        this.password = pass;
        this.displayedName = displayedName;
    }

    public static User PITER = new User("epam", "1234", "PITER CHAILOVSKII");

    public String getDisplayedName() {
        return displayedName;
    }
}