
public class Appliance {

    protected String applianceName;
    protected double powerRating; // watts
    protected double usageHours;  // per day

    public Appliance(String applianceName, double powerRating, double usageHours) {
        this.applianceName = applianceName;
        this.powerRating = powerRating;
        this.usageHours = usageHours;
    }

    public String getApplianceName() {
        return applianceName;
    }

    public double calculateEnergyConsumption() {
        return (powerRating * usageHours) / 1000.0;
    }

    public double calculateWeeklyEnergy() {
        return calculateEnergyConsumption() * 7;
    }


}
