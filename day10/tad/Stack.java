import java.util.Arrays;

public class Stack {
    private int[] data;
    private int top;

    public Stack(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("A capacidade deve ser maior ou igual a 1.");
        // alinhar com índice de 1..capacity
        data = new int[capacity + 1]; 
        top = 0;
    }

    int pop() {
        if (isEmpty())
            throw new IllegalStateException("Stack Underflow!");
        int value = data[top];
        top--;
        return value;
    }

    void push(int value) {
        if (isFull())
            throw new IllegalStateException("Stack Overflow!");
        top++;
        data[top] = value;
    }

    boolean isEmpty() {
        return top == 0;
    }

    boolean isFull() {
        return top == data.length - 1;
    }    

    @Override
    public String toString() {        
        return String.format("top=%d data=%s", top, Arrays.toString(data));
    }
}