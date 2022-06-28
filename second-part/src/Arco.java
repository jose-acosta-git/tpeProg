/*
 * La clase arco representa un arco del grafo. Contiene un vertice origen, un vertice destino y una etiqueta.
 * Nota: Para poder exponer los arcos fuera del grafo y que nadie los modifique se hizo esta clase inmutable
 * (Inmutable: una vez creado el arco no es posible cambiarle los valores).
 */
public class Arco<T> {

  private String verticeOrigen;
  private String verticeDestino;
  private T etiqueta;

  public Arco(String verticeOrigen, String verticeDestino, T etiqueta) {
    this.verticeOrigen = verticeOrigen;
    this.verticeDestino = verticeDestino;
    this.etiqueta = etiqueta;
  }

  public String getVerticeOrigen() {
    return verticeOrigen;
  }

  public String getVerticeDestino() {
    return verticeDestino;
  }

  public T getEtiqueta() {
    return etiqueta;
  }

  public void setEtiqueta(T etiqueta) {
    this.etiqueta = etiqueta;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((verticeDestino == null) ? 0 : verticeDestino.hashCode());
    result = prime * result + ((verticeOrigen == null) ? 0 : verticeOrigen.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Arco other = (Arco) obj;
    if (verticeDestino == null) {
      if (other.verticeDestino != null)
        return false;
    } else if (!verticeDestino.equals(other.verticeDestino))
      return false;
    if (verticeOrigen == null) {
      if (other.verticeOrigen != null)
        return false;
    } else if (!verticeOrigen.equals(other.verticeOrigen))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "\n\tArco [etiqueta=" + etiqueta + ", verticeDestino=" +
        verticeDestino + ", verticeOrigen="
        + verticeOrigen
        + "]";
  }

}
