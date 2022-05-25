import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

    public static void main(String[] args) {
        String csvFile = "./datasets/dataset1.csv";
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
                    newBook.addGenre(genres[i]);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
