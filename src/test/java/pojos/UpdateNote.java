package pojos;

public class UpdateNote {

    private String title;

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

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    private String description;
    private String category;

    private String completed;

    public UpdateNote(){}

    public UpdateNote(String title,String description ,String completed, String category){

        setCategory(category);
       setCompleted(completed);
        setTitle(title);
        setDescription(description);
    }

}
