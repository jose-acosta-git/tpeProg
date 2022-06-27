import java.io.File;

public class Main {
  public static void main(String[] args) {

    CSVReader reader = new CSVReader();
    // CSVWritter writer = new CSVWritter();

    String dataset = "./datasets/dataset1.csv";
    File file = new File("output/salida.csv");

    Grafo<Integer> grafo = new GrafoDirigido<>();
    reader.read(grafo, dataset);

    System.out.println(grafo.toString());
  }
}
