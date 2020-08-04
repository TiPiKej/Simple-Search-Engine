package search;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of people:");
        final int N = Integer.parseInt(scanner.nextLine());

        String[] users = new String[N];
        System.out.println("Enter all people:");
        for (int i = 0; i < N; i++) {
            users[i] = scanner.nextLine();
        }

        System.out.println();
        System.out.println("Enter number of queries:");
        final int M = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < M; i++) {
            boolean foundSomeone = false;
            System.out.println();
            System.out.println("Enter data to search people:");
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
        }

        scanner.close();
    }
}
