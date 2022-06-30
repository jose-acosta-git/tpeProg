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

  public ArrayList<String> encontrarSecuencia(String genero) {
    this.mejorSecuencia.add(genero);

    Iterator<Arco<Integer>> itCandidatos = this.grafo.obtenerArcos(genero);

    while (itCandidatos.hasNext()) {
      // Selecciona el adyacente con mayor valor en la etiqueta
      String gen = seleccionar(itCandidatos);
      if (gen != null) {
        this.mejorSecuencia.add(gen);
      }
      itCandidatos = this.grafo.obtenerArcos(gen);
    }

    return this.mejorSecuencia;
  }

  public String seleccionar(Iterator<Arco<Integer>> itArcos) {
    Arco<Integer> mejorArco = null;

    while (itArcos.hasNext()) {
      Arco<Integer> arco = itArcos.next();
      if (!this.mejorSecuencia.contains(arco.getVerticeDestino())) {
        if (mejorArco == null || arco.getEtiqueta() > mejorArco.getEtiqueta())
          mejorArco = arco;
      }
    }
    if (mejorArco != null)
      return mejorArco.getVerticeDestino();
    else
      return null;
  }

}
