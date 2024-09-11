import java.util.Arrays;

class PrintList {
    private static void print0(int[] vs, int i) {
        if (i < vs.length) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(vs[i]);
            print0(vs, i + 1);
        }
    }

    public static void print(int[] vs) {
        if (vs == null) {
            System.out.print("null");
        } else {
            System.out.print("[");
            print0(vs, 0);
            System.out.print("]");
        }
    }

    public static void main(String[] args) {
        System.out.println("PrintList");
        int[] vs = {20,10,40,50};
        System.out.println(Arrays.toString(vs));
        print(vs);
        System.out.println();
    }
}