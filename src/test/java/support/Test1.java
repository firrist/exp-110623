package support;

public class Test1 {
    public static void main(String[] args) {

        Car car1 = new Car();
        car1.drive(80);
        car1.fuelUp();
        car1.drive(50);
        car1.checkfuelLevel();
        car1.drive(50);
        car1.checkfuelLevel();

    }
}

class Car {
    public int fuelLevel;
    public int distance;
    public int maxfuellevel;
    public static final int MAX_FUEL_LEVEL = 100;

    Car() {
        this.fuelLevel = 100;
        this.distance = 0;
        this.maxfuellevel = 100;
    }

    public void drive(int distance) {
        this.distance = distance;
        this.fuelLevel = this.fuelLevel - distance;
    }

    public void fuelUp() {
        if (this.fuelLevel < maxfuellevel) {
            int fuel = maxfuellevel - this.fuelLevel;
            int fuelreq = maxfuellevel - 20;
            this.fuelLevel = this.fuelLevel + fuelreq;
        }
    }

    public void checkfuelLevel() {
        if (fuelLevel == 0)
            System.out.println("Please refuel");
        else
            System.out.println("The fuel level is: " + this.fuelLevel);
    }
}
