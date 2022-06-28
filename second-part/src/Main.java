public class Main {
  public static void main(String[] args) {

    CSVReader reader = new CSVReader();

    String dataset = "./datasets/dataset1.csv";

    GrafoDirigido<Integer> grafo = new GrafoDirigido<Integer>();
    reader.read(grafo, dataset);

    // Servicio 1
    // ObtenerNMasBuscados servicio1 = new ObtenerNMasBuscados();
    // System.out.println(servicio1.obtenerNMasBuscadosDespuesDe(grafo, "poesía",
    // 3));

    // Servicio 2
    SecuenciaAltoValor servicio2 = new SecuenciaAltoValor(grafo);
    System.out.println(servicio2.encontrarSecuencia("poesía"));

    // Servicio 3
    // GenerosAfines servicio3 = new GenerosAfines();
    // System.out.println(servicio3.encontrarGenerosAfines(grafo, "poesía"));
  }

}
