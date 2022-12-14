import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class App {
  public static void main(String[] args) {

    Mobil prelude = new Mobil(1998, "Honda Prelude");
    Mobil yaris = new Mobil(2022, "Toyota GR Yaris");
    Mobil wrangler = new Mobil(1972, "Jeep Wrangler");
    Mobil jimny = new Mobil(1983, "Suzuki Jimny");
    Mobil rx87 = new Mobil(1967, "Mazda RX 87");
    Mobil fiat = new Mobil(2007, "Fiat 500");
    Mobil mb220 = new Mobil(1958, "Mercedes Benz 220");

    // bangun tree (BST) sesuai urutan masuknya mobil
    // yang diuraikan dalam studi kasus
    // manfaatkan method: public void add(Node<T> node);
    BST<Mobil> tree = new BST<>();
    tree.add(new Node<Mobil>(prelude.tahun, prelude));
    tree.add(new Node<Mobil>(yaris.tahun, yaris));
    tree.add(new Node<Mobil>(wrangler.tahun, wrangler));
    tree.add(new Node<Mobil>(jimny.tahun, jimny));
    tree.add(new Node<Mobil>(rx87.tahun, rx87));
    tree.add(new Node<Mobil>(fiat.tahun, fiat));
    tree.add(new Node<Mobil>(mb220.tahun, mb220));

    System.out.println("-------------- Tampilkan Tree ---------------");
    System.out.println(tree);

    // demokan semua method:

    // public Node<T> get(int key, Node<T> root);
    System.out.print("Cari mobil Mazda RX87 : ");
    Node<Mobil> get = tree.get(rx87.tahun, tree.root);
    System.out.println(get.data);

    // public int degree(Node<T> node);
    System.out.print("\nMenghitung jml degree mobil mercedes : ");
    System.out.println(tree.degree(mb220.tahun, tree.root));

    // public int count();
    System.out.print("\nMenghitung jumlah node : ");
    System.out.println(tree.count(tree.root));

    // public Node<T> getMin(Node<T> node);
    System.out.print("\nCari key terkecil : ");
    Node<Mobil> getMin = tree.getMin(tree.root);
    System.out.println(getMin.data);

    // public Node<T> getMax(Node<T> node);
    System.out.print("\nCari key terbesar : ");
    Node<Mobil> getMax = tree.getMax(tree.root);
    System.out.println(getMax.data);

    // public Node<T> parent(Node<T> node);
    Node<Mobil> getPar = tree.parent(wrangler.tahun, tree.root);
    System.out.print("\nCari parent mobil Jeep Wrangler : ");
    System.out.println(getPar.data);

    // public Node<T> delete(int key);
    System.out.println("\nMenghapus mobil Jeep Wrangler : ");
    tree.delete(wrangler.tahun, tree.root);

    System.out.println(tree);

    tree.toString(); // untuk melihat isi tree sesudah node di-delete

    // ubah BST menjadi array
    System.out.println("Convert BST to Array");
    Mobil[] mobils = new Mobil[tree.count(tree.root)];
    tree.toArray(mobils, tree.root);

    //    tree.sort(mobils); // sort array
    tree.sort(mobils);

    //    tree.print(mobils); // tampilkan array yang telah diurutkan
    System.out.println("\nTampilkan array mobil yang telah diurutkan : ");
    tree.print(mobils);


  }
}
