//put imports you need here

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String stage = scanner.nextLine();
        int exp = Integer.parseInt(scanner.nextLine());
        String cuiPref = scanner.nextLine();

        System.out.printf(
                "The form for %s is completed. We will contact you if we need a chef that cooks %s dishes.",
                name, cuiPref
        );

        scanner.close();
    }
}