import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Index {

  private ArrayList<Genre> books;

  public Index() {
    books = new ArrayList<Genre>();
  }

  public void addBook(String genre, Book book) {
    if (books.isEmpty()) {
      Genre newGenre = new Genre(genre);
      newGenre.addBook(book);
      this.books.add(newGenre);
    } else {
      addBookOrdered(genre, book, 0, books.size()-1);
    }
  }

  public void addBookOrdered(String genre, Book book, int start, int end) {
    int mid = 1;
    if (end < start) {
      Genre newGenre = new Genre(genre);
      newGenre.addBook(book);
      this.books.add(start, newGenre);
    } else {
      mid = (start + end) / 2;
      if ( genre.compareTo(books.get(mid).getName()) > 0 ) {
        addBookOrdered(genre, book, mid+1, end);
      } else {
        if ( genre.compareTo(books.get(mid).getName()) < 0 ) {
          addBookOrdered(genre, book, start, mid-1);
        } else {
          books.get(mid).addBook(book);
        }
      }
    }
  }

  public LinkedList<Book> getByGenre(String genre) {
    return search(genre, 0, books.size()-1);
  }

  public LinkedList<Book> search(String search, int start, int end) {
    int mid = 1;
    if (end < start) {
      return new LinkedList<>();
    } else {
      mid = (start+end) / 2;
      if (search.compareTo(books.get(mid).getName()) > 0) {
        return search(search, mid+1, end);
      } else {
        if (search.compareTo(books.get(mid).getName()) < 0) {
          return search(search, start, mid-1);
        } else {
          return books.get(mid).getBooks();
        }
      }
    }
  }

}
