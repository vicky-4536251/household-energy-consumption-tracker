

public class Main {


    public static void main(String[] args) {
        Household house = new Household();
        Appliance refrigator = new Appliance("refrigator", 50, 4);

        System.out.println(house.highestUsages());
        house.addAppliance(refrigator);
        System.out.println(house.getEnergyCategoryBasedOnUSage(refrigator.powerRating));
        System.out.println(house.averageEnergyusages());

    }
}


