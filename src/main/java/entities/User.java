package entities;

import com.epam.commons.DataClass;

public class User extends DataClass {
    public String name;
    public String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
