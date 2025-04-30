package assignment_three.trafficManagement;

public abstract class TrafficRecord {
    private String driverId;
    private String driverName;
    private String vehiclePlate;
    private String violationType;
    private double fineAmount;
    private String paymentStatus;

    protected TrafficRecord(String driverId, String driverName, String vehiclePlate, String violationType,
            double fineAmount, String paymentStatus) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.vehiclePlate = vehiclePlate;
        this.violationType = violationType;
        this.paymentStatus = paymentStatus;
        this.fineAmount = fineAmount;
    }

    public String getDriverId() {
        return driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public String getViolationType() {
        return violationType;
    }

    public double getFineAmount() {
        return fineAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    public void setViolationType(String violationType) {
        this.violationType = violationType;
    }

    public void setFineAmount(double amt) {
        this.fineAmount = amt;
    }

    public void setPaymentStatus(String s) {
        this.paymentStatus = s;
    }

    public abstract void recordViolation();

    public abstract void assessFine();

    public abstract void processPayment();
}
