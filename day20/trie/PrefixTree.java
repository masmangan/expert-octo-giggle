import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Node {
    char value;
    Map<Character, Node> next;
    boolean isWord;
    Node(char value) {
        this.value = value;
        this.next = new HashMap<>();
        this.isWord = false;
    }
}

public class PrefixTree {

    private Node root;

    public PrefixTree() {
        this.root = new Node('*');
    }

    public void add(String s) {
        if (s == null)
            throw new IllegalArgumentException("Não posso cadastrar null!");
        if (s.isEmpty())
            throw new IllegalArgumentException("Não posso cadastrar palavras em branco!");
        add0(s, root);       
    }

    private void add0(String s, Node n) {
        char c = s.charAt(0);
        Node node = n.next.get(c);
        if (node == null) {
            node = new Node(c);
            n.next.put(c, node);
        }
        if (s.length() == 1) 
            node.isWord = true;
        else
            add0(s.substring(1), node);
    }

    @Override
    public String toString() {
        List<String> words = new ArrayList<>();
        toString0(root, words, "");
        return words.toString();
    }

    private void toString0(Node n, List<String> words, String prefix) {

    }

    public static void main(String[] args) {
        System.out.println("PrefixTree!");
        PrefixTree tree1 = new PrefixTree();
        System.out.println(tree1);
        tree1.add("bola");
        System.out.println(tree1);
    }

}