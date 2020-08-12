package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    final static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        String location = null;
        for (int i = 0; i < args.length; i += 2) {
            switch (args[i]) {
                case "--data":
                    location = args[i + 1];
                    break;
            }
        }

        String[] users = location == null ? catchUsers() : catchUsersFromFile(location);

        Map<String, Integer[]> map = new LinkedHashMap<>();
        for (int i = 0; i < users.length; i++) {
            String[] temp = users[i].toLowerCase().split(" ");
            for (String data : temp) {
                int len = map.get(data) == null ? 0 : map.get(data).length;
                Integer[] nbrs = new Integer[len + 1];
                for (int j = 0; j < len; j++) {
                    nbrs[j] = map.get(data)[j];
                } nbrs[len] = i;

                map.put(data, nbrs);
            }
        }

        int option;
        do {
            switch (option = menu()) {
                case 1:
                    boolean foundSomeone = false;
                    System.out.printf("\nEnter data to search people:\n");
                    String que = scanner.nextLine().toLowerCase();

                    if (map.get(que) == null) {
                        System.out.println("No matching people found.");
                    } else {
                        System.out.printf("%d persons found:\n", map.get(que).length);
                        for (int line : map.get(que)) {
                            System.out.println(users[line]);
                        }
                    }
                    break;
                case 2:
                    System.out.println();
                    printArr(users);
                    break;
            }
        } while (option != 0);

        System.out.println("\nBye!");
    }

    private static String[] catchUsers() {
        System.out.printf("\nEnter the number of people:\n");
        final int N = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter all people:");
        String[] users = new String[N];
        for (int i = 0; i < N; i++) {
            users[i] = scanner.nextLine();
        }
        return users;
    }

    private static String[] catchUsersFromFile(String location) {
        File file = new File(location);
        try (Scanner scannerFile = new Scanner(file)) {

            StringBuilder temp = new StringBuilder();
            while (scannerFile.hasNextLine()) {
                temp.append("\n");
                temp.append(scannerFile.nextLine());
            }

            return temp.toString().split("\n");

        } catch (final FileNotFoundException e) {
            System.out.printf("No file: %s", location);
        }

        return new String[0];
    }

    private static int menu() {
        System.out.printf("\n=== Menu ===\n");
        System.out.println("1. Find a person");
        System.out.println("2. Print all people");
        System.out.println("0. Exit");

        String temp = scanner.nextLine();

        return Integer.parseInt(temp);
    }

    private static void printArr(String[] users) {
        System.out.println("=== List of people ===");
        for (String user : users) {
            System.out.println(user);
        }
    }
}
