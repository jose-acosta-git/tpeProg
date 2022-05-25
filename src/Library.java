import java.util.ArrayList;
import java.util.HashSet;

public class Library {

    private HashSet<Book> books;
    private Index index;

    public Library() {
        books = new HashSet<>();
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
