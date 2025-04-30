package assignment_one.constructionSite;

public class CostEstimation extends ConstructionMaterial {
    public CostEstimation(String contractorName, String contractorId, double materialQuality, double materialBalance) {
        super(contractorName, contractorId, materialQuality, materialBalance);
    }

    @Override
    public void estimateCost() {
        double qty = getMaterialQuality();
        double costPerTon = (qty > 15) ? 180000 : 200000;
        double totalCost = qty * costPerTon;

        System.out.printf(" Contractor: %s (%s)\n", getContractorName(), getContractorId());
        System.out.printf("Quantity Used: %.2f tons\n", qty);
        System.out.printf("Total Cost: %, .2f RWF\n", totalCost);
    }

    @Override
    public void receiveMaterial() {
    }

    @Override
    public void useMaterial() {
    }
}
