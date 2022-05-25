import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVWritter {

        public void write(ArrayList<String> books, String genre) {
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

                for (String book: books) {
                    bw.write(book);
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
