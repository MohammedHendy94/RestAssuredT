package pojos;

public class ChangePassword {

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    private String currentPassword;
    private String newPassword;

    public ChangePassword(){}

    public ChangePassword(String currentPassword, String newPassword){
        setCurrentPassword(currentPassword);
        setNewPassword(newPassword);
    }

}
