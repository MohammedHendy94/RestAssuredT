package pojos;

public class UserInfo {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String name;
    private String email;
    private String password;


    public UserInfo(){}
    public UserInfo(String clientName, String clientEmail, String clientPassword){
        setName(clientName);
        setEmail(clientEmail);
        setPassword(clientPassword);
    }


}
