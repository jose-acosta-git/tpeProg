import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        CSVReader reader = new CSVReader();
        CSVWritter writer = new CSVWritter();
        HashSet<Book> books = new HashSet<>();
        Index index = new Index();

        reader.read(books, index);

        writer.write();
    }

}
