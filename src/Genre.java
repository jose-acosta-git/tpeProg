import java.util.LinkedList;

public class Genre {
  private String name;
  private LinkedList<Book> books;

  public Genre(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void addBook(Book book) {
    this.books.add(book);
  }

  public LinkedList<Book> getBooks() {
    return this.books;
  }

}
