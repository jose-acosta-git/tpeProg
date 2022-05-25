import java.util.ArrayList;
import java.util.HashMap;

public class Index {

    private HashMap<String, ArrayList<Book>> books;

    public Index() {
        books = new HashMap<String, ArrayList<Book>>();
    }

    public void addBook(String genre, Book book) {
        if (books.containsKey(genre)) {
            books.get(genre).add(book);
        } else {
            ArrayList<Book> newList = new ArrayList<Book>();
            newList.add(book);
            books.put(genre, newList);
        }
    }

    public ArrayList<Book> getByGenre(String genre) {
        ArrayList<Book> r = new ArrayList<Book>();
        if (books.containsKey(genre)) {
            r.addAll(books.get(genre));
        }
        return r;
    }

}
