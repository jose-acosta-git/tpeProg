import java.util.Iterator;
import java.util.LinkedList;

public class ObtenerNMasBuscados {

  public LinkedList<String> obtenerNMasBuscadosDespuesDe(Grafo<Integer> grafo, String genero, int N) {
    Arco<Integer> masBuscados[] = new Arco[N];
    for (int i = 0; i < N; i++) {
      masBuscados[i] = null;
    }
    Iterator<Arco<Integer>> it = grafo.obtenerArcos();
    while (it.hasNext()) {
      Arco<Integer> next = it.next();
      if (next.getVerticeOrigen().equals(genero)) {
        int i = 0;
        while (i < masBuscados.length) {
          if (masBuscados[i] == null) {
            masBuscados[i] = next;
            i = masBuscados.length;
          } else if (masBuscados[i].getEtiqueta() <= next.getEtiqueta()) {
            corrimientoDerecha(masBuscados, i);
            masBuscados[i] = next;
            i = masBuscados.length;
          } else {
            i++;
          }
        }
      }
    }
    LinkedList<String> generosMasBuscados = new LinkedList<String>();
    for (int i = 0; i < masBuscados.length; i++) {
      if (masBuscados[i] != null)
        generosMasBuscados.add(masBuscados[i].getVerticeDestino());
    }
    return generosMasBuscados;
  }

  private void corrimientoDerecha(Arco<Integer>[] array, int i) {
    int aux = array.length - 1;
    while (i < aux) {
      array[aux] = array[aux - 1];
      aux--;
    }
  }

}
