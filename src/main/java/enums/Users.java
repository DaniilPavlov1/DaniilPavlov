package enums;

public enum Users {

    PITER_CHALOVSKII("epam", "1234", "PITER CHAILOVSKII");
    public String login;
    public String password;
    public String name;

    Users(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }

    public String[] getEntity() {
        String[] entity = {login, password};
        return entity;
    }

    public static Users getUserEnumByName(String userName) {
        if (userName.equals(PITER_CHALOVSKII.name)) {
            return PITER_CHALOVSKII;
        } else {
            throw new UnsupportedOperationException("User with such name " + userName + " not found!");
        }
    }
}
