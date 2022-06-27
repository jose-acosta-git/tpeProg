import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

  public void read(Grafo<Integer> grafo, String csvFile) {
    String line = "";
    String cvsSplitBy = ",";

    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

      line = br.readLine(); // skip first line
      while ((line = br.readLine()) != null) {

        String[] genres = line.split(cvsSplitBy);

        for (int i = 0; i < genres.length; i++) {
          grafo.agregarVertice(genres[i]);
          if (i > 0) { // guarantee that both vertex are created before add the arc
            String verticeId1 = genres[i - 1];
            String verticeId2 = genres[i];
            if (!grafo.existeArco(verticeId1, verticeId2))
              grafo.agregarArco(verticeId1, verticeId2, 1);
            else {
              Arco<Integer> a = grafo.obtenerArco(verticeId1, verticeId2);
              a.setEtiqueta(a.getEtiqueta() + 1);
            }
          }
        }

      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
