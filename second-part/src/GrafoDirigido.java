import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class GrafoDirigido<T> implements Grafo<T> {

  private HashSet<Integer> vertices;
  private HashSet<Arco<T>> arcos;

  public GrafoDirigido() {
    this.vertices = new HashSet<Integer>();
    this.arcos = new HashSet<Arco<T>>();
  }

  // Complejidad: O(1)
  @Override
  public void agregarVertice(int verticeId) {
    this.vertices.add(verticeId);
  }

  // Complejidad: O(n+a) donde n es el numero de vertices y a el numero de arcos
  @Override
  public void borrarVertice(int verticeId) {
    boolean deleted = false;
    Iterator<Integer> it = this.vertices.iterator();
    while (it.hasNext() && !deleted) {
      int next = it.next();
      if (next == verticeId) {
        Iterator<Arco<T>> itArco = this.arcos.iterator();
        while (itArco.hasNext()) {
          Arco<T> arco = itArco.next();
          if (arco.getVerticeOrigen() == verticeId || arco.getVerticeDestino() == verticeId) {
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
  public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
    this.arcos.add(new Arco<T>(verticeId1, verticeId2, etiqueta));
  }

  // Complejidad: O(n) donde n es el numero de arcos
  @Override
  public void borrarArco(int verticeId1, int verticeId2) {
    for (Arco<T> arco : this.arcos) {
      if (arco.getVerticeOrigen() == verticeId1 && arco.getVerticeDestino() == verticeId2) {
        this.arcos.remove(arco);
        break;
      }
    }
  }

  // Complejidad: O(n) donde n es el numero de vertices
  @Override
  public boolean contieneVertice(int verticeId) {
    for (Integer vertice : this.vertices) {
      if (vertice == verticeId)
        return true;
    }
    return false;
  }

  // Complejidad: O(1) debido al hasCode y equals del hashset
  @Override
  public boolean existeArco(int verticeId1, int verticeId2) {
    return this.arcos.contains(new Arco<T>(verticeId1, verticeId2, null));
  }

  // Complejidad: O(n) donde n es el numero de arcos
  @Override
  public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
    for (Arco<T> arco : this.arcos) {
      if (arco.getVerticeOrigen() == verticeId1 && arco.getVerticeDestino() == verticeId2)
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
  public Iterator<Integer> obtenerVertices() {
    return this.vertices.iterator();
  }

  // Complejidad: O(n) donde n es el numero de arcos
  // el add dentro del if no suma porque es O(1)
  @Override
  public Iterator<Integer> obtenerAdyacentes(int verticeId) {
    LinkedList<Integer> resultado = new LinkedList<Integer>();
    for (Arco<T> arco : this.arcos) {
      if (arco.getVerticeOrigen() == verticeId) {
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
  public Iterator<Arco<T>> obtenerArcos(int verticeId) {
    LinkedList<Arco<T>> resultado = new LinkedList<Arco<T>>();
    for (Arco<T> arco : this.arcos) {
      if (arco.getVerticeOrigen() == verticeId) {
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
