import java.util.ArrayList;

public class Household {

    private ArrayList<Appliance> appliances; //attributer from another class


    public Household(){ //constructer
        appliances  = new ArrayList<>();
    }
    public double calculateTheEnergy(){

        double totalenergy = 0;

        for (Appliance appliance : appliances){// for each loop
            totalenergy += appliance.calculateEnergyConsumption();//from another class

        }
        return totalenergy;
    }

    public void addAppliance(Appliance appliance) {
        appliances.add(appliance);
    }

    public double averageEnergyusages(){

        if (appliances.size() ==0 ){
            return 0;
        }
        return  calculateTheEnergy() / appliances.size();
    }


    public Appliance highestUsages(){ //
        if(appliances.size()== 0){
            return null;
        }
        Appliance highest = appliances.get(0);


        for (Appliance appliance : appliances) {

            if ( appliance.calculateEnergyConsumption() >
                    highest.calculateEnergyConsumption())

                highest = appliance;
        }
        return highest;

    }
    public String getEnergyCategoryBasedOnUSage(double energy){

        if (energy >= 5) {
            return "This is a highest consumption of energy ";
        }
        else if( energy >= 1 ){
            return "this is an average usages of energy";
        }
        else {
            return "This is a low energy usages";
        }
    }

    @Override
    public String toString() {
        return "Household{" +
                "appliances=" + appliances +
                '}';
    }
}


