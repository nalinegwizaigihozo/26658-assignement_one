package assignment_three.trafficManagement;

import java.util.Map;

public class FineAssessment extends TrafficRecord {
    private static final Map<String, Double> RATES = Map.of(
            "SPEEDING", 50_000d,
            "RED_LIGHT", 80_000d,
            "NO_HELMET", 30_000d,
            "DUI", 150_000d);

    public FineAssessment(String driverId, String driverName, String vehiclePlate, String violationType,
            double fineAmount, String paymentStatus) {
        super(driverId, driverName, vehiclePlate, violationType, fineAmount, paymentStatus);
    }

    @Override
    public void assessFine() {
        String key = getViolationType().toUpperCase();
        if (!RATES.containsKey(key)) {
            System.out.println("! Cannot assess fine: unrecognised violation.");
            return;
        }
        setFineAmount(RATES.get(key));
        System.out.printf("Fine for %s: %.0f RWF (%s, %s)%n",
                key, getFineAmount(), getDriverName(), getVehiclePlate());
    }

    public static boolean isAllowedViolation(String v) {
        return RATES.containsKey(v.toUpperCase());
    }

    @Override
    public void processPayment() {
    }

    @Override
    public void recordViolation() {
    }
}
