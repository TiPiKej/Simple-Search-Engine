import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int N = scanner.nextInt();
        final int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        scanner.close();

        int curAsc = 1;
        int maxAsc = curAsc;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) curAsc++;
            else curAsc = 1;

            if (curAsc > maxAsc) maxAsc = curAsc;
        }

        System.out.println(maxAsc);
    }
}