package pojos;

public class LoginInfo {

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String password;
    private String email;

    public LoginInfo(){}
    public LoginInfo(String email, String password){
        setEmail(email);
        setPassword(password);
    }
}
