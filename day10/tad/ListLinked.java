
class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
        this.next = null;
    }
}

public class ListLinked implements Listable {
    private Node head;

    public ListLinked() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addValue(int value) {
        Node n = new Node(value);   // cria novo nodo
        if (this.head == null)      // lista vazia
            this.head = n;          // conecta como primeiro, último e único!
        else {                      // um ou mais elementos!
            Node last = head;
            while (last.next != null) { // segue até o último elemento!
                last = last.next;
            }
            last.next = n;          // conecta como novo último
        }
    }

    @Override
    public boolean isFull() {
        return false;   // enquanto existe memória livre...
    }

    @Override
    public int getValueAt(int index) {
        Node n = head;
        int i = 0;
        while (n != null) { 
            if (index == i) {
                return n.value;
            }
            n = n.next;
            i++;
        }
        throw new IllegalStateException("Indice invalido");
    }

    @Override
    public void setValueAt(int index, int value) {
        Node n = head;
        int i = 0;
        while (n != null) { 
            if (index == i) {
                n.value = value;
            }
            n = n.next;
            i++;
        }
        throw new IllegalStateException("Indice invalido");   
    }

    @Override
    public void addValueAt(int index, int value) {
        Node n = new Node(value);   // cria novo nodo

    }

    @Override
    public void removeAt(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeAt'");
    }

    @Override
    public void removeValue(int value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeValue'");
    }

    @Override
    public String toString() {
        return String.format("head=%s", head);
    }
}