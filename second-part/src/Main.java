import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
  public static void main(String[] args) {

    CSVReader reader = new CSVReader();

    String dataset = "./datasets/dataset1.csv";

    Grafo<Integer> grafo = new GrafoDirigido<>();
    reader.read(grafo, dataset);

    System.out.println(obtenerNMasBuscadosDespuesDe(grafo, "poesía", 3));
  }

  public static ArrayList<String> obtenerNMasBuscadosDespuesDe(Grafo<Integer> grafo, String genero, int N) {
    ArrayList<String> masBuscados = new ArrayList<String>();
    ArrayList<Integer> valoresMasBuscados = new ArrayList<Integer>();
    // Initialize both list with null values
    for (int i = 0; i < N; i++) {
      masBuscados.add(null);
      valoresMasBuscados.add(0);
    }
    Iterator<Arco<Integer>> it = grafo.obtenerArcos(genero);
    while (it.hasNext()) {
      Arco<Integer> next = it.next();
      int i = 0;
      while (i < masBuscados.size()) {
        if (masBuscados.get(i) == null) {
          masBuscados.set(i, next.getVerticeDestino());
          valoresMasBuscados.set(i, next.getEtiqueta());
          i = masBuscados.size();
        } else if (valoresMasBuscados.get(i) < next.getEtiqueta()) {
          masBuscados.set(i, next.getVerticeDestino());
          valoresMasBuscados.set(i, next.getEtiqueta());
          i = masBuscados.size();
        } else
          i++;
      }
    }
    return masBuscados;
  }

}
