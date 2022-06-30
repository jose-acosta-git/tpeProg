import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class GenerosAfines {
  GrafoDirigido<Integer> grafo;
  GrafoDirigido<Integer> grafoSolucion;
  LinkedList<String> recorridoActual;
  HashMap<String, String> colores;
  String generoOrigen;

  public GenerosAfines(GrafoDirigido<Integer> grafo) {
    this.grafo = grafo;
    grafoSolucion = new GrafoDirigido<Integer>();
    colores = new HashMap<String, String>();
    recorridoActual = new LinkedList<String>();
  }

  public GrafoDirigido<Integer> encontrarGenerosAfines(String genero) {
    this.generoOrigen = genero;
    Iterator<String> it = grafo.obtenerVertices();
    while (it.hasNext()) {
      String vertice = it.next();
      colores.put(vertice, "blanco");
    }
    this.dfsVisit(genero);
    Iterator<Arco<Integer>> itArcos = grafo.obtenerArcos();
    while (itArcos.hasNext()) {
      Arco<Integer> aux = itArcos.next();
      if (grafoSolucion.contieneVertice(aux.getVerticeOrigen())
          && grafoSolucion.contieneVertice(aux.getVerticeDestino()))
        grafoSolucion.agregarArco(aux.getVerticeOrigen(), aux.getVerticeDestino(), aux.getEtiqueta());
    }
    return grafoSolucion;
  }

  private void dfsVisit(String genero) {
    this.colores.put(genero, "amarillo");
    recorridoActual.add(genero);

    Iterator<String> itVertices = grafo.obtenerAdyacentes(genero);
    while (itVertices.hasNext()) {
      String current = itVertices.next();
      if (this.colores.get(current).equals("blanco")) {
        dfsVisit(current);
      } else if (this.colores.get(current).equals("amarillo")) {
        if (current.equals(generoOrigen)) {
          for (String v : recorridoActual) {
            // Agrego vertice al grafo solucion - los arcos los agrego antes de retornar
            // la respuesta para recorrer una sola vez el hashset de arcos
            grafoSolucion.agregarVertice(v);
          }
        }
      } else {
        // Si llegue a un vertice negro el cual tiene retorno al genero origen,
        // entonces en el camino actual tambien podre llegar al origen
        if (grafoSolucion.contieneVertice(current)) {
          for (String v : recorridoActual) {
            grafoSolucion.agregarVertice(v);
          }
        }
      }

    }

    this.colores.put(genero, "negro");
    recorridoActual.remove(genero);
  }
}
