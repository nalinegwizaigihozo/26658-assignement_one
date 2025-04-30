package assignment_three;

import java.util.Scanner;

import assignment_three.trafficManagement.FineAssessment;
import assignment_three.trafficManagement.FinePayment;
import assignment_three.trafficManagement.ViolationEntry;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String driverId = getValidId(sc);
        String driverName = getValidName(sc);
        String vehiclePlate = getValidPlate(sc);
        String violatePlate = getValidViolation(sc);

        ViolationEntry v = new ViolationEntry(driverId, driverName, vehiclePlate, violatePlate, 0.0, "PAID");
        v.setDriverId(driverId);
        v.setDriverName(driverName);
        v.setVehiclePlate(vehiclePlate);
        v.setViolationType(violatePlate);
        v.recordViolation();

        FineAssessment fa = new FineAssessment(v.getDriverId(), v.getDriverName(), v.getVehiclePlate(),
                v.getViolationType(), v.getFineAmount(), v.getPaymentStatus());
        fa.assessFine();

        FinePayment fp = new FinePayment(fa.getDriverId(), fa.getDriverName(), fa.getVehiclePlate(),
                fa.getViolationType(), fa.getFineAmount(), "UNPAID");
        fp.processPayment();
    }

    private static String getValidId(Scanner sc) {
        while (true) {
            System.out.print("Enter Driver ID (16 digits): ");
            String input = sc.nextLine().trim();
            if (input.matches("\\d{16}"))
                return input;
            System.out.println("! Invalid ID. Must be exactly 16 digits.");
        }
    }

    private static String getValidName(Scanner sc) {
        while (true) {
            System.out.print("Enter Driver Name: ");
            String input = sc.nextLine().trim();
            if (!input.isEmpty() && input.matches(".*[A-Za-z].*"))
                return input;
            System.out.println("! Invalid name. Please enter alphabetic characters.");
        }
    }

    private static String getValidPlate(Scanner sc) {
        while (true) {
            System.out.print("Enter Vehicle Plate (e.g., RAB123D): ");
            String input = sc.nextLine().trim().toUpperCase();
            if (input.matches("R[A-Z]{2}\\d{3}[A-Z]"))
                return input;
            System.out.println("! Invalid plate format. Use RAB123D format.");
        }
    }

    private static String getValidViolation(Scanner sc) {
        while (true) {
            System.out.print("Enter Violation Type (SPEEDING / RED_LIGHT / NO_HELMET / DUI): ");
            String input = sc.nextLine().trim().toUpperCase();
            if (FineAssessment.isAllowedViolation(input))
                return input;
            System.out.println("! Unknown violation type. Choose from SPEEDING, RED_LIGHT, NO_HELMET, DUI.");
        }
    }
}
