import java.util.ArrayList;
import java.util.Iterator;

public class SecuenciaAltoValor {
  Grafo<Integer> grafo;
  ArrayList<String> candidatos;
  ArrayList<String> mejorSecuencia;

  public SecuenciaAltoValor(Grafo<Integer> grafo) {
    this.grafo = grafo;
    this.candidatos = new ArrayList<String>();
    this.mejorSecuencia = new ArrayList<String>();
  }

  // Implementar si o si con greedy para tiempo polinomial
  public ArrayList<String> encontrarSecuencia(String genero) {
    this.mejorSecuencia.add(genero);

    Iterator<String> itCandidatos = this.grafo.obtenerAdyacentes(genero);

    while (itCandidatos.hasNext()) {
      // Selecciona como estrategia greedy el adyacente que tenga
      // mayor cantidad de adyacentes
      String gen = seleccionar(itCandidatos);
      if (gen != null) {
        this.mejorSecuencia.add(gen);
        itCandidatos = this.grafo.obtenerAdyacentes(gen);
      } else {
        // Clean the iterator for end the while loop
        while (itCandidatos.hasNext())
          itCandidatos.next();
      }
    }

    return this.mejorSecuencia;
  }

  public String seleccionar(Iterator<String> itCandidatos) {
    String gen = null;
    int cantAdyacentes = -1;

    while (itCandidatos.hasNext()) {
      String genero = itCandidatos.next();
      if (!this.mejorSecuencia.contains(genero)) {
        int cant = cantidadElementosIterator(this.grafo.obtenerAdyacentes(genero));
        if (cant > cantAdyacentes) {
          cantAdyacentes = cant;
          gen = genero;
        }
      }
    }

    return gen;
  }

  public int cantidadElementosIterator(Iterator<String> it) {
    int cant = 0;
    while (it.hasNext()) {
      String next = it.next();
      cant++;
    }
    return cant;
  }

}
