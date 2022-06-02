import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;

public class CSVReader {

  public void read(Library library) {
    String csvFile = "./datasets/dataset4.csv";
    String line = "";
    String cvsSplitBy = ",";

    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

      line = br.readLine(); // skip first line
      while ((line = br.readLine()) != null) {

        String[] items = line.split(cvsSplitBy);

        String title = items[0];
        String author = items[1];
        int pages = Integer.parseInt(items[2]);
        String[] genres = items[3].split(" ");

        Book newBook = new Book(title, author, pages);

        for (int i = 0; i < genres.length; i++) {
          // String genre = Normalizer.normalize(genres[i], Normalizer.Form.NFD);
          // genre = genre.replaceAll("[^a-z,^A-Z,^0-9]", "");
          // newBook.addGenre(genre);
          newBook.addGenre(genres[i]);
        }

        library.addBook(newBook);

      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
