import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class GrafoDirigido<T> implements Grafo<T> {

  private HashSet<String> vertices;
  private HashSet<Arco<T>> arcos;

  public GrafoDirigido() {
    this.vertices = new HashSet<String>();
    this.arcos = new HashSet<Arco<T>>();
  }

  // Complejidad: O(1)
  @Override
  public void agregarVertice(String verticeId) {
    this.vertices.add(verticeId);
  }

  // Complejidad: O(n+a) donde n es el numero de vertices y a el numero de arcos
  @Override
  public void borrarVertice(String verticeId) {
    boolean deleted = false;
    Iterator<String> it = this.vertices.iterator();
    while (it.hasNext() && !deleted) {
      String next = it.next();
      if (next.equals(verticeId)) {
        Iterator<Arco<T>> itArco = this.arcos.iterator();
        while (itArco.hasNext()) {
          Arco<T> arco = itArco.next();
          if (arco.getVerticeOrigen().equals(verticeId) || arco.getVerticeDestino().equals(verticeId)) {
            itArco.remove();
          }
        }
        this.vertices.remove(next);
        deleted = true;
      }
    }
  }

  // Complejidad: O(1)
  @Override
  public void agregarArco(String verticeId1, String verticeId2, T etiqueta) {
    this.arcos.add(new Arco<T>(verticeId1, verticeId2, etiqueta));
  }

  // Complejidad: O(n) donde n es el numero de arcos
  @Override
  public void borrarArco(String verticeId1, String verticeId2) {
    for (Arco<T> arco : this.arcos) {
      if (arco.getVerticeOrigen().equals(verticeId1) && arco.getVerticeDestino().equals(verticeId2)) {
        this.arcos.remove(arco);
        break;
      }
    }
  }

  // Complejidad: O(1) debido al hasCode y equals del hashset
  @Override
  public boolean contieneVertice(String verticeId) {
    return this.vertices.contains(verticeId);
  }

  // Complejidad: O(1) debido al hasCode y equals del hashset
  @Override
  public boolean existeArco(String verticeId1, String verticeId2) {
    return this.arcos.contains(new Arco<T>(verticeId1, verticeId2, null));
  }

  // Complejidad: O(n) donde n es el numero de arcos
  @Override
  public Arco<T> obtenerArco(String verticeId1, String verticeId2) {
    for (Arco<T> arco : this.arcos) {
      if (arco.getVerticeOrigen().equals(verticeId1) && arco.getVerticeDestino().equals(verticeId2))
        return arco;
    }
    return null;
  }

  // Complejidad: O(1)
  @Override
  public int cantidadVertices() {
    return this.vertices.size();
  }

  // Complejidad: O(1)
  @Override
  public int cantidadArcos() {
    return this.arcos.size();
  }

  // Complejidad: O(1)
  @Override
  public Iterator<String> obtenerVertices() {
    return this.vertices.iterator();
  }

  // Complejidad: O(n) donde n es el numero de arcos
  // el add dentro del if no suma porque es O(1)
  @Override
  public Iterator<String> obtenerAdyacentes(String verticeId) {
    LinkedList<String> resultado = new LinkedList<String>();
    for (Arco<T> arco : this.arcos) {
      if (arco.getVerticeOrigen().equals(verticeId)) {
        resultado.add(arco.getVerticeDestino());
      }
    }
    return resultado.iterator();
  }

  // Complejidad: O(1)
  @Override
  public Iterator<Arco<T>> obtenerArcos() {
    return this.arcos.iterator();
  }

  // Complejidad: O(n) donde n es el numero de arcos
  // el add dentro del if no suma porque es O(1)
  @Override
  public Iterator<Arco<T>> obtenerArcos(String verticeId) {
    LinkedList<Arco<T>> resultado = new LinkedList<Arco<T>>();
    for (Arco<T> arco : this.arcos) {
      if (arco.getVerticeOrigen().equals(verticeId)) {
        resultado.add(arco);
      }
    }
    return resultado.iterator();
  }

  @Override
  public String toString() {
    return "GrafoDirigido:\n" + "arcos=" + arcos + "\nvertices=" + vertices;
  }

}
