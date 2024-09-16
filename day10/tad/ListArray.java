
import java.util.Arrays;

class ListArray implements Listable {
    private int[] data;
    private int size;

    public ListArray(int capacity) {
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

    public int getValueAt(int index) {
        checkIndex(index);
        int value = data[index];
        return value;
    }

    public void setValueAt(int index, int value) {
        checkIndex(index);
        data[index] = value;
    }

    public void addValue(int value) {
        if (isFull())
            throw new IllegalArgumentException("Capacidade esgotada!");
        data[size] = value;
        size++;
    }

    public void addValueAt(int index, int value) {
        if (isFull())
            throw new IllegalArgumentException("Capacidade esgotada!");
        if (index < 0)
            throw new IllegalArgumentException("O índice nao pode ser negativo");
        if (index > size)
            throw new IllegalArgumentException("O índice deve ser menor que size");
        
        for (int i = size - 1; i >= index; i--)             
            data[i+1] = data[i];

        data[index] = value;        
        size++;        
    }

    public void removeAt(int index) {
        // TODO:
    }

    public void removeValue(int value) {
        // TODO:
    }

    @Override
    public String toString() {        
        return String.format("size=%d data=%s", size, Arrays.toString(data));
    }    
}