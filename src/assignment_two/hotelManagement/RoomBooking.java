package assignment_two.hotelManagement;

public class RoomBooking extends HotelService {
    public RoomBooking(String guestId, String guestName, String roomType, int stayDays, String roomStatus) {
        super(guestId, guestName, roomType, stayDays, roomStatus);
    }

    @Override
    public void bookRoom() {
        if (getStayDays() < 1 || getStayDays() > 30) {
            System.out.printf("! Booking failed: stayDays (%d) must be 1–30.%n", getStayDays());
            return;
        }
        if (!"AVAILABLE".equals(getRoomStatus())) {
            System.out.println("! Booking failed: room is not available.");
            return;
        }
        setRoomStatus("OCCUPIED"); // Setting room status using setter method
        System.out.printf(" Booking confirmed for %s (%s). Room type: %s, Days: %d%n",
                getGuestName(), getGuestId(), getRoomType(), getStayDays());
    }

    @Override
    public void checkOutGuest() {
    }

    @Override
    public void generateBill() {
    }
}
