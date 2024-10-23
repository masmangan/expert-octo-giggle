import java.util.ArrayList;
import java.util.List;

class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class BinarySearchTree {

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void add(final int v) {
        root = add0(v, root);
    }

    private Node add0(int v, Node n) {
        if (n == null) {
            Node newNode = new Node(v);
            return newNode;
        }

        if (n.value < v)
            n.right = add0(v, n.right);
        else if (n.value > v)
            n.left = add0(v, n.left);

        return n;
    }

    public boolean contains(int v) {
        return contains0(v, root);
    }

    private boolean contains0(int v, Node n) {
        if (n == null)
            return false;
        if (n.value < v)
            return contains0(v, n.right);
        else if (n.value > v)
            return contains0(v, n.left);
        else
            return true;

    }

    @Override
    public String toString() {
        List<Integer> vs = new ArrayList<>();
        toString0(root, vs);
        return vs.toString();
    }

    private void toString0(Node n, List<Integer> vs) {
        if (n == null)
            return;
        toString0(n.left, vs);
        vs.add(n.value);
        toString0(n.right, vs);
    }

    public static void main(String[] args) {
        System.out.println("Binary Search Tree");

        BinarySearchTree t1 = new BinarySearchTree();
        if (!t1.toString().equals("[]"))
            System.out.println("Erro na árvore vazia!");
        t1.add(20);
        if (!t1.toString().equals("[20]"))
            System.out.println("Erro na árvore com um item!");
        t1.add(30);
        if (!t1.toString().equals("[20, 30]"))
            System.out.println("Erro na árvore com dois itens!");
        t1.add(10);
        if (!t1.toString().equals("[10, 20, 30]"))
            System.out.println("Erro na árvore com três itens!");
        if (!t1.contains(10))
            System.out.println("Erro na busca na esquerda do raiz!");
        if (!t1.contains(20))
            System.out.println("Erro na busca no raiz!");
        if (!t1.contains(30))
            System.out.println("Erro na busca na direita do raiz!");
        if (t1.contains(40))
            System.out.println("Erro na busca de elemento que não existe!");
    }

}
