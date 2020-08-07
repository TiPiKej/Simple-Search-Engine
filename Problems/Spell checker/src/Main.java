import java.lang.reflect.Array;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Set<String> words1 = new TreeSet<>();
        Set<String> words2 = new TreeSet<>();
        Set<String> wordsNotSeen = new TreeSet<>();

        final Scanner scanner = new Scanner(System.in);

        final int D = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < D; i++) words1.add(scanner.nextLine());

        final int L = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < L; i++) {
            for (String word : scanner.nextLine().split(" ")) {
                words2.add(word);
            }
        }

        scanner.close();

        for (String word : words2) {
            boolean contains = false;
            for (String w : words1) {
                if (Objects.equals(w.toLowerCase(), word.toLowerCase())) contains = true;
            }
            if (!contains) wordsNotSeen.add(word);
        }

        wordsNotSeen.forEach(word -> System.out.println(word));
    }
}