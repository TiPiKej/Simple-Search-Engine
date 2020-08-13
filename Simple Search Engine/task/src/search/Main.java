package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    final static Scanner scanner;
    final static Map<String, Integer[]> queries;
    static List<String> users;

    static {
        scanner = new Scanner(System.in);
        queries = new LinkedHashMap<>();
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

        users = location == null ? catchUsers() : catchUsersFromFile(location);

        makeMap();

        int option;
        do {
            switch (option = menu()) {
                case 1:
                    System.out.println("Select a matching strategy: ALL, ANY, NONE");
                    String strategy = scanner.nextLine();

                    System.out.printf("\nEnter a name or email to search all suitable people.\n");
                    String[] queWords = scanner.nextLine().toLowerCase().split("\\s");

                    Map<Integer, Integer> lines = new LinkedHashMap<>();

                    int[] base = new int[users.size()];
                    for (String queWord : queWords) {
                        if (queries.get(queWord) == null) continue;
                        for (int line : queries.get(queWord)) base[line]++;
                    }

                    int count = 0;
                    List<String> outUsers = new ArrayList<>();
                    switch (strategy) {
                        case "ALL":
                            for (int i = 0; i < base.length; i++) {
                                if (base[i] == queWords.length) {
                                    outUsers.add(users.get(i));

                                    count++;
                                }
                            }
                            break;
                        case "ANY":
                            for (int i = 0; i < base.length; i++) {
                                if (base[i] > 0) {
                                    outUsers.add(users.get(i));

                                    count++;
                                }
                            }
                            break;
                        case "NONE":
                            for (int i = 0; i < base.length; i++) {
                                if (base[i] == 0) {
                                    outUsers.add(users.get(i));

                                    count++;
                                }
                            }
                            break;
                    }

                    System.out.printf("%d persons found:\n", count);

                    for (String user : outUsers) {
                        System.out.println(user);
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

    private static void makeMap() {
        for (int i = 0; i < users.size(); i++) {
            String[] temp = users.get(i).toLowerCase().split(" ");
            for (String data : temp) {
                int len = queries.get(data) == null ? 0 : queries.get(data).length;
                Integer[] nbrs = new Integer[len + 1];
                for (int j = 0; j < len; j++) {
                    nbrs[j] = queries.get(data)[j];
                } nbrs[len] = i;

                queries.put(data, nbrs);
            }
        }
    }

    private static ArrayList<String> catchUsers() {
        System.out.printf("\nEnter the number of people:\n");
        final int N = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter all people:");
        List<String> users = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            users.add(scanner.nextLine());
        }
        return (ArrayList<String>) users;
    }

    private static ArrayList<String> catchUsersFromFile(String location) {
        File file = new File(location);
        try (Scanner scannerFile = new Scanner(file)) {

            List<String> temp = new ArrayList<>();
            while (scannerFile.hasNextLine()) {
                temp.add(scannerFile.nextLine());
            }

            return (ArrayList<String>) temp;

        } catch (final FileNotFoundException e) {
            System.out.printf("No file: %s", location);
        }

        return new ArrayList<String>();
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

    private static void printArr(List<String> users) {
        System.out.println("=== List of people ===");
        for (String user : users) {
            System.out.println(user);
        }
    }
}
