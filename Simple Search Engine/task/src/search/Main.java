package search;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    final static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        String[] users = catchUsers();

        int option;
        do {
            switch (option = menu()) {
                case 1:
                    boolean foundSomeone = false;
                    System.out.printf("\nEnter data to search people:\n");
                    String que = scanner.nextLine();

                    for (String user : users) {
                        if (user.toLowerCase().indexOf(que.toLowerCase()) != -1) {
                            System.out.println(user);
                            foundSomeone = true;
                        }
                    }
                    if (!foundSomeone) {
                        System.out.println("No matching people found.");
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
