package assignment_one.constructionSite;

public abstract class ConstructionMaterial {
    private String contractorName;
    private String contractorId;
    private double materialQuality;
    private double materialBalance;

    public ConstructionMaterial(String contractorName, String contractorId, double materialQuality,
            double materialBalance) {
        this.contractorName = contractorName;
        this.contractorId = contractorId;
        this.materialQuality = materialQuality;
        this.materialBalance = materialBalance;
    }

    public String getContractorName() {
        return contractorName;
    }

    public void setContractorName(String contractorName) {
        this.contractorName = contractorName;
    }

    public String getContractorId() {
        return contractorId;
    }

    public void setContractorId(String contractorId) {
        this.contractorId = contractorId;
    }

    public double getMaterialQuality() {
        return materialQuality;
    }

    public void setMaterialQuality(double materialQuality) {
        this.materialQuality = materialQuality;
    }

    public double getMaterialBalance() {
        return materialBalance;
    }

    public void setMaterialBalance(double materialBalance) {
        this.materialBalance = materialBalance;
    }

    public abstract void receiveMaterial();

    public abstract void useMaterial();

    public abstract void estimateCost();

}
