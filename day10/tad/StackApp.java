public class StackApp {

    public static void main(String[] args) {
        System.out.println("Stacks!");

        Stack s = new Stack(2);
        System.out.println(s);
        s.push(102);
        System.out.println(s);
        s.push(103);
        System.out.println(s);
        s.push(104);
        System.out.println(s);
        while (! s.isEmpty()) {
            int value = s.pop();
            System.out.println(value);
            System.out.println(s);
        }
        System.out.println(s);
    }
}