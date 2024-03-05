public class Author{
    private String authorName;
    private String yearActive;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getYearActive() {
        return yearActive;
    }

    public void setYearActive(String yearActive) {
        this.yearActive = yearActive;
    }

    public Author(String authorName,String yearActive){
        this.authorName = authorName;
        this.yearActive = yearActive;
    }
}
