import java.util.LinkedList;

public class Genre {
  private String name;
  private LinkedList<Book> books;

  public Genre(String name) {
    this.name = name;
    this.books = new LinkedList<Book>();
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

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof String) {
      return this.name.equals(obj);
    }
    return false;
  }

}
