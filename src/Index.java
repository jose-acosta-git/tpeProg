import java.util.ArrayList;
import java.util.HashMap;

public class Index {

    private HashMap<String, ArrayList<String>> books;

    public Index() {
        books = new HashMap<String, ArrayList<String>>();
    }

    public void addBook(String genre, String book) {
        if (book.contains(genre)) {
            books.get(genre).add(book);
        } else {
            ArrayList<String> newList = new ArrayList<>();
            newList.add(book);
            books.put(genre, newList);
        }
    }

    public ArrayList<String> getByGenre(String genre) {
        ArrayList<String> r = new ArrayList<>();
        if (books.containsKey(genre)) {
            r.addAll(books.get(genre));
        }
        return r;
    }

}
