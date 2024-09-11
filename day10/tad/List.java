
import java.util.Arrays;

interface Listable {

    boolean isEmpty();
    boolean isFull();

    int getValueAt(int index);

    void setValueAt(int index, int value);

    void addValue(int value);
    void addValueAt(int index, int value);

    void removeAt(int index);
    void removeValue(int value);

}

class List {
    private int[] data;
    private int size;

    public List(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("A capacidade deve ser maior ou igual a 1.");
        data = new int[capacity];
        size = 0;
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    public boolean isFull() {
        return size >= data.length;
    }

    private void checkIndex(int index) {
        if (index < 0)
            throw new IllegalArgumentException("O índice nao pode ser negativo");
        if (index >= size)
            throw new IllegalArgumentException("O índice deve ser menor que size");
    }

    int getValueAt(int index) {
        checkIndex(index);
        int value = data[index];
        return value;
    }

    void setValueAt(int index, int value) {
        checkIndex(index);
        data[index] = value;
    }

    void addValue(int value) {
        if (isFull())
            throw new IllegalArgumentException("Capacidade esgotada!");
        data[size] = value;
        size++;
    }

    @Override
    public String toString() {        
        return String.format("size=%d data=%s", size, Arrays.toString(data));
    }    
}