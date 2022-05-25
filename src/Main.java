import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.Normalizer;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        Library library = new Library();

        CSVReader reader = new CSVReader();
        CSVWritter writer = new CSVWritter();

        reader.read(library);

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String genre = "";
        boolean error = false;
        do {
            try {
                System.out.println("Ingrese un género para realizar la búsqueda");
                genre = Normalizer.normalize(input.readLine(), Normalizer.Form.NFD);
                genre = genre.replaceAll("[^a-z,^A-Z,^0-9]", "");
                error = false;
            } catch (Exception e) {
                System.out.println("Ingreso inválido: " + e);
                error = true;
            }
        } while (error);

        writer.write(library.getByGenre(genre), genre);
    }

}
