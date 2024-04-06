package support;

/*
    Create car class
    Car have 2 properties - fuelLevel and distance
    Car have 2 methods - drive and fuelUp

    Drive method accept distance
    If we are out of fuel drive should say “Not enough fuel”


    Fuel consumption is 1 to 1
    Max fuel level 100

    To test the car
    1. Car fueled with 100
    Drive 80 miles
            FuelUp
    Drive 50 miles
    Check fuel level
*/

public class CarTest {
    public static void main(String[] args) {
        MyCar honda = new MyCar();

        honda.drive(80);
        System.out.println("fuelLevel = " + honda.fuelLevel);
        honda.fuelUp();
        honda.drive(50);
        System.out.println("fuelLevel = " + honda.fuelLevel);
        System.out.println("Total distance driven = " + honda.distance);
    }
}

class MyCar {
    int fuelLevel = 100;
    int distance = 0;

    void drive(int distanceToDrive) {
        if (distanceToDrive > fuelLevel) {
            System.out.println("Not enough fuel to drive " + distanceToDrive + ". Fuel level: " + fuelLevel);
        } else {
            fuelLevel = fuelLevel - distanceToDrive;
            distance = distance + distanceToDrive;
            System.out.println("Car has driven: " + distanceToDrive);
        }
    }

    void fuelUp() {
        fuelLevel = 100;
        System.out.println("Fueled up! Fuel level = " + fuelLevel);
    }
}
