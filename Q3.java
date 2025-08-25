interface Drivable {
    void drive();
}

class Vehicle {
    protected String brand;
    protected int speed;
    
    public Vehicle(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }
    
    public void move() {
        System.out.println(brand + " is moving at " + speed + " km/h");
    }
}

class Car extends Vehicle implements Drivable {
    private int seats;
    
    public Car(String brand, int speed, int seats) {
        super(brand, speed);
        this.seats = seats;
    }
    
    @Override
    public void drive() {
        System.out.println("Driving the " + brand + " car on the road");
    }
    
    public void display() {
        System.out.println("Car Details: " + brand + ", Speed: " + speed + " km/h, Seats: " + seats);
    }
}

public class Interface {
    public static void main(String[] args) {
        System.out.println("=== Inheritance and Interface Demo ===\n");
        
        Car myCar = new Car("Davidputra 9000X+", 120, 5);
        
        myCar.move();
        myCar.drive();
        myCar.display();
        
        System.out.println("\n=== Polymorphism Examples ===");
        
        Vehicle vehicle = new Car("Lightning McQeen", 100, 4);
        vehicle.move();
        
        Drivable drivable = new Car("BMW", 180, 2);
        drivable.drive();
    }
}
