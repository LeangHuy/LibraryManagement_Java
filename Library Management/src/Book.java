public class Book {

    private int ID;
    String title;

    String publishYear;

    boolean status;

    private Author author;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setID(int ID){
        this.ID = ID;
    }

    public int getID(){
        return ID;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }



    public void setPublishYear(String publishYear){
        this.publishYear = publishYear;
    }

    public String getPublishYear(){
        return publishYear;
    }

    public void setStatus(boolean status){
        this.status = status;
    }

    public boolean getStatus(){
        return status;
    }

    public Book(int ID, String title, String publishYear, Author author){
        this.ID = ID;
        this.title = title;
        this.publishYear = publishYear;
        this.status = true;
        this.author = author;
    }


}
