package assignment_one;

import java.util.Scanner;

import assignment_one.constructionSite.CostEstimation;
import assignment_one.constructionSite.MaterialDelivery;
import assignment_one.constructionSite.MaterialUsage;

public class ConstructionMain {

    public static String getValidContractorId(Scanner scanner, String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("! Contractor ID cannot be empty.");
            } else if (!input.matches("[a-zA-Z0-9]+")) {
                System.out.println("! Contractor ID must contain only letters and numbers.");
            } else {
                return input;
            }
        }
    }

    public static String getValidContractorName(Scanner scanner, String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("! Contractor name cannot be empty.");
            } else if (!input.matches("[a-zA-Z ]+")) {
                System.out.println("! Contractor name must contain only letters and spaces.");
            } else {
                return input;
            }
        }
    }

    public static double getValidPositiveDouble(Scanner scanner, String prompt) {
        double value;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                scanner.nextLine(); // Consume newline character
                if (value > 0)
                    return value;
                else
                    System.out.println("! Value must be greater than 0.");
            } else {
                System.out.println("! Invalid number. Please enter a valid decimal number.");
                scanner.next(); // Discard the invalid input
            }
        }
    }

    public static double getValidNonNegativeDouble(Scanner scanner, String prompt) {
        double value;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                scanner.nextLine(); // Consume newline character
                if (value >= 0)
                    return value;
                else
                    System.out.println("! Value cannot be negative.");
            } else {
                System.out.println("! Invalid number. Please enter a valid decimal number.");
                scanner.next(); // Discard the invalid input
            }
        }
    }

    public static int getValidMenuChoice(Scanner scanner, String prompt, int min, int max) {
        int choice;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice >= min && choice <= max)
                    return choice;
                else
                    System.out.printf("! Please enter a number between %d and %d.%n", min, max);
            } else {
                System.out.println("! Invalid input. Please enter a number.");
                scanner.next();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n Welcome to Construction Site Material Manager\n");

        String contractorId = getValidContractorId(scanner, "Enter Contractor ID: ");
        String contractorName = getValidContractorName(scanner, "Enter Contractor Name: ");
        double materialQuantity = getValidPositiveDouble(scanner, "Enter Material Quantity (tons): ");
        double materialBalance = getValidNonNegativeDouble(scanner, "Enter Current Material Balance (tons): ");

        System.out.println("\nSelect Operation:\n1. Receive Material\n2. Use Material\n3. Estimate Cost");
        int choice = getValidMenuChoice(scanner, "Your choice (1-3): ", 1, 3);

        switch (choice) {
            case 1:
                MaterialDelivery delivery = new MaterialDelivery(contractorId, contractorName, materialQuantity,
                        materialBalance);
                delivery.receiveMaterial();
                break;
            case 2:
                MaterialUsage usage = new MaterialUsage(contractorId, contractorName, materialQuantity,
                        materialBalance);
                usage.useMaterial();
                break;
            case 3:
                CostEstimation estimation = new CostEstimation(contractorId, contractorName, materialQuantity,
                        materialBalance);
                estimation.estimateCost();
                break;
        }
        scanner.close();
    }

}
