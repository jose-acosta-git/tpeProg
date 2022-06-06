import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class CSVWritter {

  public void write(LinkedList<Book> books, String genre) {
    BufferedWriter bw = null;
    try {
      File file = new File("output/salida.csv");
      if (!file.exists()) {
        file.createNewFile();
      }

      FileWriter fw = new FileWriter(file);
      bw = new BufferedWriter(fw);

      bw.write("Lista de libros del género: " + genre);
      bw.newLine();

      for (Book book : books) {
        bw.write(book.getTitle());
        bw.newLine();
      }

    } catch (IOException ioe) {
      ioe.printStackTrace();
    } finally {
      try {
        if (bw != null)
          bw.close();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  }

}
