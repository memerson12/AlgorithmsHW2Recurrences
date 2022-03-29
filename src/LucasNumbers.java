public class LucasNumbers {
    public static void main(String[] args) {
        System.out.println(calculateLucasNumbers(7));
    }

    private static int calculateLucasNumbers(int n) {
        if(n == 0) return 2;
        if(n == 1) return 1;
        return calculateLucasNumbers(n-1) + calculateLucasNumbers(n-2);
    }
}
