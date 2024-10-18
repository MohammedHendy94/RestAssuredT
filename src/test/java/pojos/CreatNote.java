package pojos;

public class CreatNote {

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    private String title;
    private String description;
    private String category;


    public CreatNote(){}

    public CreatNote (String title, String description, String category){
        setCategory(category);
        setDescription(description);
        setTitle(title);
    }

}
