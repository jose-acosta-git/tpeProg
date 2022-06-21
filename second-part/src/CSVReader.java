import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

  public void read(Grafo grafo, String csvFile) {
    String line = "";
    String cvsSplitBy = ",";

    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

      line = br.readLine(); // skip first line
      while ((line = br.readLine()) != null) {

        String[] genres = line.split(cvsSplitBy);

        for (int i = 0; i < genres.length; i++) {
          // grafo.agregarVertice(genres[i]);
          grafo.agregarVertice(i); // only add number of for loop for test
        }

      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
