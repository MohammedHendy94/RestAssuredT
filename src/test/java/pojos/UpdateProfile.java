package pojos;

public class UpdateProfile {


    private String name;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    private String company;

    public UpdateProfile(){}

    public UpdateProfile(String name, String phone, String company){
        setCompany(company);
        setPhone(phone);
        setName(name);
    }



}
