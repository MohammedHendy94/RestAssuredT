package pojos;

public class ProductCreatInfo {


    private String description;
    private String price;
    private String discountPercentage;
    private String rate;
    private String title;

    public ProductCreatInfo (String titl,String desc, String pric, String disc, String rat){
        setDescription(desc);
        setPrice(pric);
        setDiscountPercentage(disc);
        setRate(rat);
        setTitle(titl);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(String discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }






}
