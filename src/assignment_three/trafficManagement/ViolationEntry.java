package assignment_three.trafficManagement;

public class ViolationEntry extends TrafficRecord {
    public ViolationEntry(String driverId, String driverName, String vehiclePlate, String violationType,
            double fineAmount, String paymentStatus) {

        super(driverId, driverName, vehiclePlate, violationType, fineAmount, paymentStatus);
    }

    @Override
    public void recordViolation() {
        if (!FineAssessment.isAllowedViolation(getViolationType())) {
            System.out.println("! Unknown violation type: " + getViolationType());
            return;
        }
        setPaymentStatus("UNPAID");
        System.out.printf(" Violation recorded: %s (%s) ‑ %s, plate %s%n",
                getDriverName(), getDriverId(), getViolationType(), getVehiclePlate());
    }

    @Override
    public void assessFine() {
    }

    @Override
    public void processPayment() {
    }
}
