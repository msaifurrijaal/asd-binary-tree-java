import java.sql.Array;

public interface IBST<T> {
  public void add(Node<T> newNode);
  public Node<T> add(Node<T> node, Node<T> newNode);
  public int degree(int key, Node<T> node);
  public int count(Node root);
  public Node<T> get(int key, Node<T> root);
  public Node<T> getMin(Node<T> node);
  public Node<T> getMax(Node<T> node);
  public Node<T> parent(int key, Node<T> node);
  public void delete(int key, Node<T> node);
  public T[] toArray(T[] inputArray, Node<T> node);
  public Mobil [] sort(Mobil [] tArray);
  public void print(T [] tArray);
}
