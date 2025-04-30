package assignment_three.trafficManagement;

public class FinePayment extends TrafficRecord {
    public FinePayment(String driveId, String driveName, String vehiclePlate, String violationType, double fineAmount,
            String paymentStatus) {

        super(driveId, driveName, vehiclePlate, violationType, fineAmount, paymentStatus);
        setFineAmount(fineAmount);
        setPaymentStatus(paymentStatus);
    }

    @Override
    public void processPayment() {
        if (!"UNPAID".equals(getPaymentStatus())) {
            System.out.println("! Payment rejected: fine already PAID.");
            return;
        }
        // (Online/mobile‑money logic would go here)
        setPaymentStatus("PAID");
        System.out.println("-------RECEIPT -------");
        System.out.printf("Driver:  %s (%s)%n", getDriverName(), getDriverId());
        System.out.printf("Plate:   %s%nViolation: %s%n", getVehiclePlate(), getViolationType());
        System.out.printf("Amount:  %.0f RWF%nStatus:  %s%n", getFineAmount(), getPaymentStatus());
    }

    @Override
    public void recordViolation() {
    }

    @Override
    public void assessFine() {

    }
}
