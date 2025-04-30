package assignment_two.hotelManagement;

public class GuestCheckout extends HotelService {
    public GuestCheckout(String guestId, String guestName, String roomType, int stayDays, String roomStatus) {

        super(guestId, guestName, roomType, stayDays, roomStatus);

    }

    @Override
    public void checkOutGuest() {
        if (!"OCCUPIED".equals(getRoomStatus())) {
            System.out.println("! Checkout failed: room is already available.");
            return;
        }
        setRoomStatus("AVAILABLE"); // Setting room status using setter method
        System.out.printf(" %s (%s) checked out successfully. Room now AVAILABLE.%n",
                getGuestName(), getGuestId());
    }

    @Override
    public void generateBill() {
    }

    @Override
    public void bookRoom() {
    }

    public void checkoutGuest() {
    }
}
