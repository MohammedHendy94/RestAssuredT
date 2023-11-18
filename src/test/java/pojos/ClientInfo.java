package pojos;

public class ClientInfo {
    private String clientName;
    private String clientEmail;

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
