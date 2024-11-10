public class Book extends ReadingItem{
    private String isbn;
    private String edition;
    private String title;

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getEdition() {
        return edition;
    }

    public String getTitle() {
        return title;
    }
}
