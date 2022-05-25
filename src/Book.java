import java.util.HashSet;

public class Book {
    private String title;
    private String author;
    private int pages;
    private HashSet<String> genres;

    public Book(String title, String author, int pages, HashSet<String> genres) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.genres = genres;
    }

    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
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

    public void setGenres(HashSet<String> genres) {
        this.genres = genres;
    }

    public boolean containsGenre(String genre) {
        return this.genres.contains(genre);
    }

}
