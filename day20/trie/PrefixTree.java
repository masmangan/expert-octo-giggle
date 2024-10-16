import java.util.Map;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.List;

/**
 * 
 */
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

/**
 * 
 */
public class PrefixTree {

    private final Node root;

    /**
     * O(1)
     */
    public PrefixTree() {
        this.root = new Node('*');
    }

    /**
     * O(|s|) proporcional ao comprimento da palavra.
     * 
     * @param s
     */
    public void add(final String s) {
        if (s == null)
            throw new IllegalArgumentException("Não posso cadastrar null!");
        if (s.isEmpty())
            throw new IllegalArgumentException("Não posso cadastrar palavras em branco!");
        add0(s, root);
    }

    /**
     * O(|s|) proporcional ao comprimento da palavra.
     * 
     * @param s
     * @param n
     */
    private void add0(final String s, final Node n) {
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

    public boolean contains(String s) {
        if (s == null)
            return false;
        if (s.isEmpty())
            return false;
        Node n = root;
        while (n != null) {
            char c = s.charAt(0);
            Node next = n.next.get(c);
            if (next == null)
                return false;
            if (s.length() == 1)
                if (next.isWord)
                    return true; // encontrou até a última letra e é uma palavra isolada
                else
                    return false; // encontrou, mas não palavra isolada
            s = s.substring(1);
            n = next;
        }
        return false;
    }

    /**
     * O(|s|) proporcional ao comprimento da palavra.
     * 
     * @param s
     * @return
     */
    public boolean containsRecursive(String s) {
        if (s == null)
            return false;
        if (s.isEmpty())
            return false;
        return containsRecursive0(s, root);
    }

    /**
     * O(|s|) proporcional ao comprimento da palavra.
     * 
     * @param s
     * @param n
     * @return
     */
    public boolean containsRecursive0(String s, Node n) {
        char c = s.charAt(0);
        Node next = n.next.get(c);
        if (next == null)
            return false;
        if (s.length() == 1)
            return next.isWord;
        return containsRecursive0(s.substring(1), next);

    }

    /**
     * 
     */
    @Override
    public String toString() {
        List<String> words = new ArrayList<>();
        toString0(root, words, "");
        return words.toString();
    }

    /**
     * O(n) n sendo o número de nodos.
     * 
     * @param n
     * @param words
     * @param prefix
     */
    private void toString0(Node n, List<String> words, String prefix) {
        for (char c : n.next.keySet()) {
            Node next = n.next.get(c);
            String newPrefix = prefix + c;
            if (next.isWord)
                words.add(newPrefix);
            toString0(next, words, newPrefix);
        }
    }

    /**
     * Tree t1 = new Tree();
     * t1.add("bola");
     * t1.add("bolo");
     * t1.printByLevel();
     * >>> "bolao"
     */
    public void printByLevel() {
        // TODO: usar uma fila para mostrar a árvore
        List<Node> queue = new LinkedList<>();
        for (char c : root.next.keySet()) {
            Node next = root.next.get(c);        
            queue.addFirst(next);
        }

        while (!queue.isEmpty()) {
            Node n = queue.removeLast();
            System.out.print(n.value);
            for (char c : n.next.keySet()) {
                Node next = n.next.get(c);        
                queue.addFirst(next);
            }            
        }
        System.out.println();
       
    }

    /**
     * Tree t1 = new Tree();
     * t1.add("bola");
     * t1.add("bolo");
     * t1.printByLevelWaves();
     * >>> "b o l ao"
     */    
    public void printByLevelWaves() {
        // TODO: usar uma fila para mostrar a árvore
        
    }

    /**
     * Tree t1 = new Tree();
     * t1.add("bola");
     * t1.add("bolo");
     * t1.countLeaves();
     * >>> 2
     */ 
    public int countLeaves() {
        // TODO: usar uma fila para mostrar a árvore
        return 0;        
    }


    /**
     * Tree t1 = new Tree();
     * t1.add("bola");
     * t1.add("bolo");
     * t1.printAllDegrees();
     * >>> "b=1, o=1, l=2, a=0, b=0"
     */     
    public void printAllDegrees() {
        // TODO: usar uma fila para mostrar a árvore
    }    

    public static void main(String[] args) {
        System.out.println("PrefixTree!");
        PrefixTree tree1 = new PrefixTree();
        System.out.println(tree1);
        tree1.add("bola");
        System.out.println(tree1);
        tree1.add("bolo");
        System.out.println(tree1);
        System.out.println(tree1.contains("bo"));
        System.out.println(tree1.contains("bola"));
        System.out.println(tree1.contains("bolo"));
        System.out.println(tree1.contains("bolacha"));
        System.out.println(tree1.contains("teste"));

        tree1.printByLevel();
    }

}