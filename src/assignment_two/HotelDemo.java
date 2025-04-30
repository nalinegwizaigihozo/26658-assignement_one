package assignment_two;

import java.util.Scanner;

import assignment_two.hotelManagement.Billing;
import assignment_two.hotelManagement.GuestCheckout;
import assignment_two.hotelManagement.RoomBooking;

public class HotelDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // ----------------------------1. collect guest details
        // ----------------------------
        System.out.print("Enter Guest ID (letters & digits): ");
        String guestId = getValidGuestId(scanner);

        System.out.print("Enter Guest Name: ");
        String guestName = getValidGuestName(scanner);

        System.out.print("Enter Room Type (STANDARD / DELUXE / SUITE): ");
        String roomType = getValidRoomType(scanner);

        System.out.print("Enter Stay Days (1–30): ");
        int stayDays = getValidInteger(scanner);

        String roomStatus = "AVAILABLE";
        RoomBooking booking = new RoomBooking(guestId, guestName, roomType, stayDays, roomStatus);
        booking.bookRoom();

        if ("OCCUPIED".equals(booking.getRoomStatus())) {
            new Billing(guestId, guestName, roomType, stayDays, "OCCUPIED")
                    .generateBill();
            new GuestCheckout(guestId, guestName, roomType, stayDays, "OCCUPIED")
                    .checkoutGuest();
        }
        scanner.close();
    }

    private static String getValidGuestId(Scanner sc) {
        while (true) {
            String id = sc.nextLine().trim();
            if (id.matches("[A-Za-z0-9]{1,15}"))
                return id;
            System.out.print("! Invalid ID. Use 1‑15 letters/digits: ");
        }
    }

    private static String getValidGuestName(Scanner sc) {
        while (true) {
            String name = sc.nextLine().trim();
            if (!name.isEmpty() && name.matches(".*\\p{L}+.*"))
                return name;
            System.out.print("! Invalid name. Must include letters: ");
        }
    }

    private static String getValidRoomType(Scanner sc) {
        while (true) {
            String t = sc.nextLine().trim().toUpperCase();
            switch (t) {
                case "STANDARD":
                case "DELUXE":
                case "SUITE":
                    return t;
                default:
                    System.out.print("!Invalid type. Enter STANDARD, DELUXE, or SUITE: ");
            }
        }
    }

    private static int getValidInteger(Scanner sc) {
        while (true) {
            if (sc.hasNextInt()) {
                int val = sc.nextInt();
                sc.nextLine(); // clear newline
                if (val >= 1 && val <= 30)
                    return val;
            } else {
                sc.nextLine(); // discard non‑int token
            }
            System.out.printf("! Invalid number. Enter an integer %d‑%d: ", 1, 30);
        }
    }
}
