package admin;

public class AdminCredential {
    private String login;
    private String password;

    public AdminCredential(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public AdminCredential() {
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
