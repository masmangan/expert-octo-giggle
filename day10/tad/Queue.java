import java.util.Arrays;

class Queue {
    int[] data;
    int head;
    int tail;

    Queue(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("A capacidade deve ser maior ou igual a 1.");
        data = new int[capacity];
        head = 0; 
        tail = 0; 
    }

    void enqueue(int value) {
        if (isFull())
            throw new IllegalStateException("Queue is full!");

        data[tail] = value;
        tail++;
        if (tail >= data.length)
            tail = 0;
    }

    int dequeue() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty!");
        int value = data[head];
        head++;
        if (head >= data.length)
            head = 0;        
        return value;
    }

    boolean isFull() {
        if (head < tail)     
            return head == 0 && tail >= data.length -1;
        else
            return tail == head - 1;
    }

    boolean isEmpty() {
        return head == tail;
    }

    @Override
    public String toString() {        
        return String.format("head=%d tail=%d data=%s", head, tail, Arrays.toString(data));
    }    
}