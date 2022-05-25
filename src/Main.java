import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        CSVReader reader = new CSVReader();
        CSVWritter writer = new CSVWritter();
        HashSet<Book> books = new HashSet<>();
        Index index = new Index();

        reader.read(books, index);

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String genre = "";
        boolean error = false;
        do {
            try {
                System.out.println("Ingrese un género para realizar la búsqueda");
                genre = input.readLine();
                error = false;
            } catch (Exception e) {
                System.out.println("Ingreso inválido: " + e);
                error = true;
            }
        } while (error);


        writer.write(index.getByGenre(genre), genre);
    }

}
