import java.util.*;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(" ");
        final int N = scanner.nextInt();
        scanner.close();

        ArrayList<Integer> list = new ArrayList<>(line.length);
        for (String strNbr : line) {
            list.add(Integer.parseInt(strNbr));
        }

        int i = 0;
        while (!list.contains(N + i) && !list.contains(N - i)) {
            i++;
        }

        if (i == 0) {
            for (int nbr : list) if (nbr == N) System.out.printf("%d ", nbr);
        } else {
            for (int nbr : list) if (nbr == N - i) System.out.printf("%d ", nbr);
            for (int nbr : list) if (nbr == N + i) System.out.printf("%d ", nbr);
        }
    }
}