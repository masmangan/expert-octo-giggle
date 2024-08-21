import java.util.Arrays;

class PrintList 
{

    private void print(int[] vs) {
        // mostra o conteudo da lista
        print0(vs, 0);
    }

    public static void main(String[] args) {
        System.out.println("PrintList");
        int[] vs = {23, 43, 10, 89};
        System.out.println(Arrays.toString(vs));
    }
}