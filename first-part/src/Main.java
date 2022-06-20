import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

  public static void main(String[] args) {
    Library library = new Library();

    CSVReader reader = new CSVReader();
    CSVWritter writer = new CSVWritter();

    String dataset = "./datasets/dataset4.csv";
    File file = new File("output/salida.csv");

    Timer timer = new Timer();

    timer.start();
    reader.read(library, dataset);
    System.out.println("Tiempo de carga: " + timer.stop());

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    String genre = "";
    boolean error = false;
    do {
      try {
        System.out.print("Ingrese un género para realizar la búsqueda: ");
        /* normalizacion
        genre = Normalizer.normalize(input.readLine(), Normalizer.Form.NFD);
        genre = genre.replaceAll("[^a-z,^A-Z,^0-9]", "");*/
        genre = input.readLine();
        error = false;
      } catch (Exception e) {
        System.out.println("Ingreso inválido: " + e);
        error = true;
      }
    } while (error);

    timer.start();
    LinkedList<Book> books = library.getByGenre(genre);
    System.out.println("Tiempo de busqueda: " + timer.stop());
    timer.start();
    writer.write(books, genre, file);
    System.out.println("Tiempo de escritura: " + timer.stop());
  }

}
