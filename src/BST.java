import java.sql.Array;
import java.util.ArrayList;

public class BST<T> implements IBST<T> {
  Node<T> root;

  public BST() {

  }

  public BST(Node<T> root) {
    this.root = root;
  }

  // tambahkan node,
  // dan letakkan node dalam BST
  // sesuai nilai atribut int objek T
  @Override
  public void add(Node<T> newNode) {
    this.root = add(this.root, newNode);
  }
  @Override
  public Node<T> add(Node<T> root, Node<T> newNode) {
    if (root == null) {
      root = new Node<T>(newNode.key, newNode.data);
      return root;
    }
    if (newNode.key > root.key) {
      root.rt = add(root.rt, newNode);
    } else if(newNode.key < root.key) {
      root.lt = add(root.lt, newNode);
    }
    return root;
  }

  @Override
  public String toString() {
    return preOrder(this.root);
  }

  public String preOrder(Node<T> n) {
    if (n == null) return "";
    String out = String.format("%s\n", n.data.toString());
    out += preOrder(n.lt);
    out += preOrder(n.rt);
    return out;
  }

  // get node dalam BST
  // yang memiliki atribut int objek T sama dengan key
  // dan dicari dari root node
  // yang ditentukan dari parameter root
  @Override
  public Node<T> get(int key, Node<T> root) {
    Node<T> n = null;
    if (root.key == key) return root;
    if (root.lt != null) n = this.get(key, root.lt);
    if (n != null) return n;
    if (root.rt != null) n = this.get(key, root.rt);
    if (n != null) return n;
    return n;
  }

  // hitung degree dari suatu node  
  @Override
  public int degree(int key, Node<T> node) {
    Node<T> temp = get(key, node);
    int degree = 0;
    if (temp.lt != null) degree++;
    if (temp.rt != null) degree++;
    return degree;
  }

  // hitung jumlah node yang ada di dalam BST
  @Override
  public int count(Node root) {
    if(root==null)
      return 0;
    // recursive left child and right child
    return 1 + count(root.lt) + count(root.rt);
  }


  // get node dengan atribut int objek T minimum 
  // yang diawali dari subtree 
  // dengan root node yang ditentukan lewat parameter
  @Override
  public Node<T> getMin(Node<T> node) {
    Node<T> n = null;
    if (node == null) return null;
    n = node;
    while(n.lt != null) {
      n = n.lt;
    }
    return n;
  }

  // get node dengan atribut int objek T maksimum 
  // yang diawali dari subtree 
  // dengan root node yang ditentukan lewat parameter
  @Override
  public Node<T> getMax(Node<T> node) {
    Node<T> n = null;
    if (node == null) return null;
    n = node;
    while(n.rt != null) {
      n = n.rt;
    }
    return n;
  }

  // get parent node dari suatu node
  @Override
  public Node<T> parent(int key, Node<T> node) {
    Node<T> temp = null;
    if (node.key == key) return null;
    if (node.lt != null && node.lt.key == key)
      return node;
    if (node.lt != null)
      temp = this.parent(key, node.lt);
    if (temp != null) return temp;

    if (node.rt != null && node.rt.key == key)
      return node;
    if (node.rt != null)
      temp = this.parent(key, node.rt);
    return temp;
  }

  // hapus node dalam BST yang memiliki 
  // atribut int sama dengan key
  @Override
  public void delete(int key, Node<T> node) {
    if(node == null) return;
    int degree = degree(key, node);

    switch (degree) {
      case 0:
        Node<T> parent = this.parent(key, node);
        if (parent != null) {
          if(parent.lt != null) {
            if (parent.lt.key == key)
              parent.lt = null;
          }
          if(parent.rt != null) {
            if (parent.rt.key == key)
              parent.rt = null;
          }
        }
        break;
      case 1:
        Node<T> parent2 = this.parent(key, node);
        Node<T> temp = this.get(key, node);
        Node<T> child = (temp.lt != null) ?
                temp.lt : temp.rt;

        // putuskan node dari parent
        // sekaligus hubungkan parent ke child

        if (parent2.lt != null && parent2.lt.key == key)
          parent2.lt = child;
        else parent2.rt = child;

        // putuskan node dari child
        if (temp.lt != null) temp.lt = null;
        if (temp.rt != null) temp.rt = null;
        break;
      case 2:
        Node<T> temp2 = get(key, node);
        node = temp2;
        Node<T> max = this.getMax(temp2.lt);
        this.delete(max.key, node);
        node.key = max.key;
        node.data = max.data;
        break;
    }
  }


  // traverse BST, simpan ke dalam array
  // return array

  @Override
  public T[] toArray(T [] inputArray, Node<T> node) {
    ArrayList<T> listNew = new ArrayList<>();
    listNew = inorder(node, listNew);
    int i = 0;
    for(T list : listNew) {
      inputArray[i] = list;
      i++;
    }
    return inputArray;
  }

  public ArrayList<T> inorder(Node<T> root,ArrayList<T> arr) {
    if (root == null) {
      return arr;
    }
    inorder(root.lt,arr);
    arr.add(root.data);
    inorder(root.rt,arr);
    return arr;
  }

  // array yang dihasilkan dari toArray()
  // urutkan berdasarkan atribut int objek T
  // teknik sorting bebas
  @Override
  public Mobil[] sort(Mobil [] mobil) {
    for(int i =0; i < mobil.length; i++ ){
      for (int j = i + 1; j < mobil.length; j++) {
        if(mobil[j].tahun < mobil[i].tahun ) {
          Mobil temp  = mobil[j];
          mobil[j] = mobil[i];
          mobil[i] = temp;
        }
      }
    }
    return mobil;
  }

  // print array yang dihasilkan dari toArray()
  @Override
  public void print(T [] tArray) {
    for (int i = 0; i < tArray.length; i++) {
      System.out.println(tArray[i].toString());
    }
    
  }
}
