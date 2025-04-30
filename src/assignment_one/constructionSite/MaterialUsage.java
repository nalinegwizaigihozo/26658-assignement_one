package assignment_one.constructionSite;

public class MaterialUsage extends ConstructionMaterial {
    public MaterialUsage(String contractorName, String contractorId, double materialQuality, double materialBalance) {
        super(contractorName, contractorId, materialQuality, materialBalance);
    }

    @Override
    public void useMaterial() {
        double qty = getMaterialQuality();
        double balance = getMaterialBalance();
        if (balance - qty >= 2) {
            setMaterialBalance(balance - qty);
            System.out.println(" Material used successfully. Remaining balance: " + getMaterialBalance() + " tons");
        } else {
            System.out.println("! Insufficient material. You must keep at least 2 tons in stock.");
        }
    }

    @Override
    public void receiveMaterial() {
    }

    @Override
    public void estimateCost() {
    }
}
