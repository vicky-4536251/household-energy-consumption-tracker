package groupassignment;

public class Appliance {
    private String applianceName;
    private double powerRating;   // watts
    private double usageHours;    // per day

    // ---------------- CONSTRUCTOR ----------------
    public Appliance(String applianceName, double powerRating, double usageHours) {
        this.applianceName = "Default Appliance";
        this.powerRating = 100;
        this.usageHours = 1;

        setApplianceName(applianceName);
        setPowerRating(powerRating);
        setUsageHours(usageHours);
    }

    // ---------------- GETTERS ----------------
    public String getApplianceName() {
        return applianceName;
    }

    public double getPowerRating() {
        return powerRating;
    }

    public double getUsageHours() {
        return usageHours;
    }

    // ---------------- SETTERS (VALIDATION) ----------------
    public boolean setApplianceName(String applianceName) {
        if (applianceName != null && !applianceName.trim().isEmpty()) {
            this.applianceName = applianceName.trim();
            return true;
        }
        System.out.println("Appliance name can not be empty! Please enter a valid name!");
        return false;
    }

    public boolean setPowerRating(double powerRating) {
        if (powerRating > 0) {
            this.powerRating = powerRating;
            return true;
        }
        System.out.println("Power rating should be greater than 0!");
        return false;
    }

    public boolean setUsageHours(double usageHours) {
        if (usageHours >= 0 && usageHours <= 24) {
            this.usageHours = usageHours;
            return true;
        }
        System.out.println("Invalid usage hours. Must be between 0 and 24.");
        return false;

    }

    // ---------------- ENERGY CALCULATION ----------------
    public double calculateDailyEnergy() {
        return (powerRating * usageHours) / 1000.0;
    }

    public double calculateWeeklyEnergy() {
        return calculateDailyEnergy() * 7;
    }

    public double calculateMonthlyEnergy() {
        return calculateDailyEnergy() * 30;
    }

    // ----------------HIGH ENERGY CONSUMER DETECTION----------------
    public boolean isHighEnergyConsumer() {
        return calculateDailyEnergy() > 10.0;
    }

    public boolean isHighEnergyConsumer(double threshold) {
        if (threshold < 0) {
            System.out.println("High energy consumer should be greater than 0.");
            return false;
        }
        return calculateDailyEnergy() > threshold;
    }

    // ---------------- DISPLAY ----------------
    public void displayApplianceInfo() {
        System.out.println("\n===== APPLIANCE DETAILS =====");
        System.out.println("Name:           " + applianceName);
        System.out.println("Type:           " + getClass().getSimpleName());
        System.out.println("Power Rating:   " + powerRating + " W");
        System.out.println("Daily Usage:    " + usageHours + " hours/day");
        System.out.println("Daily Energy:   " + String.format("%.2f", calculateDailyEnergy()) + " kWh");
        System.out.println("Weekly Energy:  " + String.format("%.2f", calculateWeeklyEnergy()) + " kWh");
        System.out.println("Monthly Energy: " + String.format("%.2f", calculateMonthlyEnergy()) + " kWh");
        System.out.println("High Energy:    " + (isHighEnergyConsumer() ? "⚠️ Yes" : "✅ No"));
        System.out.println("===============================");
    }

    @Override
    public String toString() {
        return String.format("%s (%.0fW, %.1fh/day) - %.2f kWh/day",
                applianceName, powerRating, usageHours, calculateDailyEnergy());
    }
}