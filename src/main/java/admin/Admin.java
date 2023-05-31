package admin;

import org.apache.commons.lang3.RandomStringUtils;

public class Admin {

    private String login;
    private String password;
    private String firstName;


    public Admin() {
    }

    public Admin(String login, String password, String firstName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
    }

    public static Admin getRandomCourier() {
        final String courierLogin = RandomStringUtils.random(10, true, true);
        final String courierPassword = RandomStringUtils.random(10, true, true);
        final String courierFirstName = RandomStringUtils.randomAlphabetic(10);
        return new Admin(courierLogin, courierPassword, courierFirstName);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }
}