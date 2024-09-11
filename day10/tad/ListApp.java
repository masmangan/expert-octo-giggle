public class ListApp {

    public static void main(String[] args) {
        System.out.println("Lists!");
        List lst = new List(5);
        System.out.println(lst);

        if (!lst.isEmpty())
            System.out.println("ERRO: a lista deveria estar vazia");

        if (lst.isFull())
            System.out.println("ERRO: a lista nao deveria estar cheia");

        lst.addValue(42);
        int v1 = lst.getValueAt(0);
        if (v1 != 42)
            System.out.println("ERRO: get encontrou valor inesperado");
    }
}