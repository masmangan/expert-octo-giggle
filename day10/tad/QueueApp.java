public class QueueApp {

    public static void main(String[] args) {
        System.out.println("Queues!");
        Queue q = new Queue(5);
        System.out.println(q);
        q.enqueue(102);
        System.out.println(q);
        q.enqueue(103);
        System.out.println(q);
        q.enqueue(104);
        System.out.println(q);
        q.enqueue(105);
        System.out.println(q);
        q.enqueue(106);
        System.out.println(q);

        while (! q.isEmpty() ) {
            int value = q.dequeue();
            System.out.println(value);
            System.out.println(q);
        }
        System.out.println(q);
    }
}