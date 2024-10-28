import java.util.ArrayList;
import java.util.List;

class Node {
    int value;
    int height;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        this.height = 0;
        this.left = null;
        this.right = null;
    }
}

public class AVL {

    private Node root;

    public AVL() {
        root = null;
    }

    public void add(final int v) {
        root = add0(v, root);
    }

    private int h(Node n) {
        if (n == null)
            return -1;
        return n.height;
    }

    private Node add0(int v, Node n) {
        if (n == null) {
            Node newNode = new Node(v);
            return newNode;
        }

        if (n.value < v) {
            n.right = add0(v, n.right);
            // Está equilibrada?
            if (h(n.right) - h(n.left) >= 2) {
                System.out.println("Desequilibrada!");
            }
            n.height = Math.max(h(n.left), h(n.right)) + 1;
        } else if (n.value > v) {
            n.left = add0(v, n.left);
            // Está equilibrada?            
            if (h(n.left) - h(n.right) >= 2) {
                System.out.println("Desequilibrada!");
            }            
            n.height = Math.max(h(n.left), h(n.right)) + 1;
        }

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
        List<String> vs = new ArrayList<>();
        toString0(root, vs);
        return vs.toString();
    }

    private void toString0(Node n, List<String> vs) {
        if (n == null)
            return;
        toString0(n.left, vs);
        vs.add(String.format("%d (h=%d)", n.value, n.height));
        toString0(n.right, vs);
    }

    public static void main(String[] args) {
        System.out.println("Binary Search Tree");

        AVL t1 = new AVL();
        System.out.println(t1);
        t1.add(20);
        System.out.println(t1);
        t1.add(30);
        System.out.println(t1);
        t1.add(10);
        System.out.println(t1);
    }

}
