import java.util.Iterator;
import java.util.LinkedList;

public class Index {

  private LinkedList<Genre> books;

  public Index() {
    books = new LinkedList<Genre>();
  }

  public void addBook(String genre, Book book) {
    boolean found = false;
    Iterator<Genre> it = this.books.iterator();

    while (it.hasNext() && !found) {
      Genre current = it.next();
      if (current.getName().equals(genre)) {
        found = true;
        current.addBook(book);
      }
    }

    if (!found) {
      Genre newGenre = new Genre(genre);
      newGenre.addBook(book);
      this.books.add(newGenre);
    }

  }

  public LinkedList<Book> getByGenre(String genre) {
    Iterator<Genre> it = this.books.iterator();

    while (it.hasNext()) {
      Genre current = it.next();
      if (current.getName().equals(genre)) {
        return current.getBooks();
      }
    }

    return new LinkedList<Book>();
  }

}
