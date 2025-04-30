package assignment_one.constructionSite;

public class MaterialDelivery extends ConstructionMaterial {
    public MaterialDelivery(String contractorName, String contractorId, double materialQuality,
            double materialBalance) {
        super(contractorName, contractorId, materialQuality, materialBalance);
    }

    @Override
    public void receiveMaterial() {
        if (getMaterialQuality() >= 1 && getMaterialQuality() <= 10) {
            setMaterialBalance(getMaterialBalance() + getMaterialQuality());
            System.out.println(" Delivery successful. Updated balance: " + getMaterialBalance() + " tons");
        } else {
            System.out.println("! Delivery failed: Quantity must be between 1 and 10 tons.");
        }
    }

    @Override
    public void useMaterial() {
    }

    @Override
    public void estimateCost() {
    }
}
