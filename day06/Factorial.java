class Factorial {
    public static int op;

    private static long factorial(long n) {
        assert n >= 0L;
        op++;
        System.out.printf("f(%d)%n", n);
        if (n == 0L)
            return 1L;
        return n * factorial(n - 1L);
    }

    public static void main(String[] args) {
        System.out.println("Factorial!");
        op = 0;
        System.out.println(factorial(3));
        System.out.println(op);
    }

}