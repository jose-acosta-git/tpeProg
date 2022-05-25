import java.util.HashSet;

public class Book {
    private String title;
    private String author;
    private int pages;
    private HashSet<String> genres;

    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.genres = new HashSet<String>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void addGenre(String genre) {
        this.genres.add(genre);
    }

    public boolean containsGenre(String genre) {
        return this.genres.contains(genre);
    }

}
