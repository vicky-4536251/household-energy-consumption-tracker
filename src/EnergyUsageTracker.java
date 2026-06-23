package groupassignment;


public class EnergyUsageRecord {


   private Appliance appliance;
   private String recordDate;
   private double energyUsed;
   private double estimatedCost;


   private static final double COST_PER_KWH = 0.57;


   // Constructor
   public EnergyUsageRecord(Appliance appliance, String recordDate) {
       if (appliance == null) throw new IllegalArgumentException("Appliance cannot be null.");
       if (recordDate == null || recordDate.trim().isEmpty()) throw new IllegalArgumentException("Record date cannot be empty.");


       this.appliance = appliance;
       this.recordDate = recordDate.trim( );


       calculateRecord();
   }


   // Calculate Energy and Cost
   public void calculateRecord() {


       // Polymorphism happens here
       energyUsed = appliance.calculateDailyEnergy();


       estimatedCost = energyUsed * COST_PER_KWH;
   }


   public double calculateWeeklyCost() {
       return appliance.calculateWeeklyEnergy() * COST_PER_KWH;
   }


   public double calculateMonthlyCost() {
       return appliance.calculateMonthlyEnergy() * COST_PER_KWH;


   // Getters
   public Appliance getAppliance() {
       return appliance;
   }


   public String getRecordDate() {
       return recordDate;
   }


   public double getEnergyUsed() {
       return energyUsed;
   }


   public double getEstimatedCost() {
       return estimatedCost;
   }


   // Setters
   public void setAppliance(Appliance appliance) {
       if (appliance == null) {
           System.out.println("Appliance cannot be null!");
           return;
       }
       this.appliance = appliance;
       calculateRecord();
   }
   public void setRecordDate(String recordDate) {
       if (recordDate == null || recordDate.trim().isEmpty()) {
           System.out.println("Date cannot be empty!");
           return;
       }
       this.recordDate = recordDate.trim();
   }


   // Display Usage Record
   public void displayRecord() {


       System.out.println("\n===== ENERGY USAGE RECORD =====");


       System.out.println("Date: " + recordDate);
       System.out.println("Appliance Name: " + appliance.getApplianceName());
       System.out.println("Appliance Type: " + appliance.getClass().getSimpleName());


       System.out.printf("Energy Used:     %.2f kWh%n", energyUsed);
       System.out.printf("Daily Cost:      RM %.2f%n", estimatedCost);
       System.out.printf("Weekly Cost:     RM %.2f%n", calculateWeeklyCost());
       System.out.printf("Monthly Cost:    RM %.2f%n", calculateMonthlyCost());




       if(appliance.isHighEnergyConsumer()) {
           System.out.println("⚠ High Energy Consumer");
       }
       else {
           System.out.println("✓ Normal Energy Usage");
       }


       System.out.println("===============================");
   }


   @Override
   public String toString() {
           return String.format(
                   "%s | %s | %s | %.2f kWh | RM %.2f",
                   recordDate,
                   appliance.getApplianceType(),
                   appliance.getApplianceName(),
                   energyUsed,
                   estimatedCost
       );
   }
}


