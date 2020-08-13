import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final BigInteger M = scanner.nextBigInteger();
        int n = 0;

        while (factorial(n).compareTo(M) == -1) {
            n++;
        };

        scanner.close();

        System.out.println(n);
    }

    private static BigInteger factorial(int n) {
        BigInteger nbr = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            nbr = nbr.multiply(BigInteger.valueOf(i));
        }

        return nbr;
    }
}