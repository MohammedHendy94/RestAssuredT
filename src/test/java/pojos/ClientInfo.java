package pojos;

public class ClientInfo {
    private String ClientName;
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
        return ClientName;
    }
    public void setClientName(String clientName) {
        this.ClientName = clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }
    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }



}
