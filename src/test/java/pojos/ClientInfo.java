package pojos;

public class ClientInfo {
    private String clientName;
    private String clientEmail;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    private String accessToken;

    public ClientInfo(){}
    public ClientInfo(String clntName, String clntEmail){
        setClientEmail(clntEmail);
        setClientName(clntName);
    }


    public String getClientName() {
        return clientName;
    }
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }
    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }



}
