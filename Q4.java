abstract class Shape {
    public abstract double calculateArea();
    
    public void display() {
        System.out.println("I am a shape.");
    }
}

class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;
    
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    @Override
    public double calculateArea() {
        return length * width;
    }
}

public class Abstraction {
    public static void main(String[] args) {
        System.out.println("=== Shape Area Calculator ===\n");
        
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4.0, 6.0);
        
        System.out.println("Circle:");
        circle.display();
        System.out.println("Area: " + String.format("%.2f", circle.calculateArea()));
        
        System.out.println("\nRectangle:");
        rectangle.display();
        System.out.println("Area: " + rectangle.calculateArea());
        
        System.out.println("\n=== Array of Shapes ===");
        Shape[] shapes = {new Circle(3.0), new Rectangle(5.0, 8.0), new Circle(7.0)};
        
        for (Shape shape : shapes) {
            shape.display();
            System.out.println("Area: " + String.format("%.2f", shape.calculateArea()));
            System.out.println();
        }
    }
}
