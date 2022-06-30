import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
  public static void main(String[] args) {
    CSVReader reader = new CSVReader();
    String dataset = "./datasets/dataset1.csv";
    Timer timer = new Timer();
    GrafoDirigido<Integer> grafo = new GrafoDirigido<Integer>();

    timer.start();
    reader.read(grafo, dataset);
    System.out.println("Tiempo de carga dataset1: " + timer.stop());

    // Servicio 1
    System.out.print("Servicio 1: ");
    ObtenerNMasBuscados servicio1 = new ObtenerNMasBuscados();
    timer.start();
    LinkedList<String> listas1 = servicio1.obtenerNMasBuscadosDespuesDe(grafo, "poesía", 6);
    System.out.println("Tiempo de ejecucion servicio1: " + timer.stop());
    System.out.println(listas1);

    // Servicio 2
    System.out.print("Servicio 2: ");
    SecuenciaAltoValor servicio2 = new SecuenciaAltoValor(grafo);
    timer.start();
    ArrayList<String> arrays2 = servicio2.encontrarSecuencia("poesía");
    System.out.println("Tiempo de ejecucion servicio2: " + timer.stop());
    System.out.println(arrays2);

    // Servicio 3
    System.out.print("Servicio 3: ");
    GenerosAfines servicio3 = new GenerosAfines(grafo);
    timer.start();
    GrafoDirigido<Integer> grafos3 = servicio3.encontrarGenerosAfines("poesía");
    System.out.println("Tiempo de ejecucion servicio3: " + timer.stop());
    System.out.println(grafos3);

  }

}
