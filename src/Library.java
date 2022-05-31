import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class Library {

    private LinkedList<Book> books;
    private Index index;

    public Library() {
        books = new LinkedList<>();
        index = new Index();
    }

    public void addBook(Book b) {
        books.add(b);
        for (String genre:b.getGenres()) {
            index.addBook(genre, b);
        }
    }

    public ArrayList<Book> getByGenre(String genre) {
        return index.getByGenre(genre);
    }

}
