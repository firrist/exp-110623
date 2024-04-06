//Create car class
//Car have 2 methods - drive and fuelUp
//Car have 2 properties - fuelLevel and distance
//If we are out of fuel drive should say “Not enough fuel”
//
//Drive method accept distance
//
//Fuel consumption is 1 to 1
//Max fuel level 100
//
//
//To test the car
//1. Car fueled with 100
//Drive 80 miles
//        FuelUp
//Drive 50 miles
//Check fuel level

package support;

public class CarAssignment {
    public static void main(String[] args) {
        CarAssignment.Car car = new CarAssignment.Car(100, 100);
        car.drive();

        System.out.println("fuel level: "  + car.checkFuel());
    }

    //Arslan's solution:
    static class Car {
        private int fuelLevel;
        private int distance;

        public Car(int fuelLevel, int distance) {
            if (fuelLevel > 100) {
                this.fuelLevel = 100;
            } else {
                this.fuelLevel = fuelLevel;
            }
            this.distance = distance;
        }

        public void drive() {
            if (fuelLevel > 0 && distance > 0) {
                System.out.println("Car is Driving");
                fuelLevel--;
                distance--;
            } else if (fuelLevel == 0) {
                System.out.println("Not enough fuel");
            } else {
                System.out.println("Distance was reached: " + distance);
            }
        }

        public void fuelUp(int fuel) {
            if (this.fuelLevel + fuel <= 100) {
                this.fuelLevel += fuel;
                System.out.println("Car refueled. New Fuel Level is: " + this.fuelLevel);
            } else {
                System.out.println("Can't refuel maximum capacity is 100");
            }
        }

        public int checkFuel() {
            return this.fuelLevel;
        }
    }
}