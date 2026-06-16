package groupassignment;

public class LightAppliance {
    public class LightAppliance extends Appliance {

        private String bulbType;  // LED, CFL, Incandescent

        public LightAppliance(String name, double power, double hours, String bulbType) {
            super(name, power, hours);
            this.bulbType = bulbType;
        }

        public String getBulbType() {
            return bulbType;
        }

        public void setBulbType(String bulbType) {
            this.bulbType = bulbType;
        }

        @Override
        public boolean isHighEnergyConsumer() {
            return calculateDailyEnergy() > 2.0;
        }

        @Override
        public void displayApplianceInfo() {
            super.displayApplianceInfo();
            System.out.println("Bulb Type:      " + bulbType);
        }
    }
}
