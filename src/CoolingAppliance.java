
//inthertace from the parent class Appliance
public class CoolingAppliance extends Appliance {

    // Cooling specific attributes
    private int fanSpeed;
    private double temperatureSetting;

    // Constructor
    public CoolingAppliance(String applianceName,
                            double powerRating,
                            double usageHours,
                            int fanSpeed,
                            double temperatureSetting) {

        // Calls Appliance constructor
        super(applianceName, powerRating, usageHours);

        this.fanSpeed = fanSpeed;
        this.temperatureSetting = temperatureSetting;
    }

    // Getter
    public int getFanSpeed() {
        return fanSpeed;
    }

    // Setter
    public void setFanSpeed(int fanSpeed) {
        this.fanSpeed = fanSpeed;
    }

    // Getter
    public double getTemperatureSetting() {
        return temperatureSetting;
    }

    // Setter
    public void setTemperatureSetting(double temperatureSetting) {
        this.temperatureSetting = temperatureSetting;
    }

    // POLYMORPHISM
    // Override parent method
    @Override
    public double calculateEnergyConsumption() {

        double energy = (powerRating * usageHours) / 1000.0;

        // Air conditioners consume more energy
        if (applianceName.equalsIgnoreCase("Air Conditioner")) {
            energy = energy * 1.15;
        }

        return energy;
    }

    // Display information
    public void displayCoolingInfo() {

        System.out.println("Cooling Appliance: " + applianceName);
        System.out.println("Power Rating: " + powerRating + " W");
        System.out.println("Usage Hours: " + usageHours);
        System.out.println("Fan Speed: " + fanSpeed);
        System.out.println("Temperature: " + temperatureSetting + " C");

        System.out.println("Energy Consumption: "
                + calculateEnergyConsumption()
                + " kWh");
    }
}