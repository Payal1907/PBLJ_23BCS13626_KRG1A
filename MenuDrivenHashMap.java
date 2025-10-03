import java.util.*;

// Custom Exceptions
class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(String msg) { super(msg); }
}
class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String msg) { super(msg); }
}

public class MenuDrivenHashMap {
    private static Map<Integer, String> employees = new HashMap<>();
    private static Map<String, Double> products = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    // Employee methods
    static void addEmployee() {
        System.out.print("Enter Employee ID: "); int id = sc.nextInt();
        System.out.print("Enter Name: "); String name = sc.next();
        employees.put(id, name);
    }
    static void getEmployee() {
        System.out.print("Enter Employee ID: "); int id = sc.nextInt();
        try {
            if (!employees.containsKey(id)) throw new EmployeeNotFoundException("Employee ID not found!");
            System.out.println("Name: " + employees.get(id));
        } catch (Exception e) { System.out.println("Error: " + e.getMessage()); }
    }
    static void showEmployees() {
        System.out.println("Employees: " + employees);
    }

    // Product methods
    static void addProduct() {
        System.out.print("Enter Product ID: "); String pid = sc.next();
        System.out.print("Enter Price: "); double price = sc.nextDouble();
        products.put(pid, price);
    }
    static void applyDiscount() {
        System.out.print("Enter Product ID: "); String pid = sc.next();
        System.out.print("Enter Discount %: "); double d = sc.nextDouble();
        try {
            if (!products.containsKey(pid)) throw new ProductNotFoundException("Product ID not found!");
            if (d < 0 || d > 100) throw new IllegalArgumentException("Discount % must be 0–100!");
            double np = products.get(pid) * (1 - d / 100.0);
            products.put(pid, np);
            System.out.println("New price: $" + String.format("%.2f", np));
        } catch (Exception e) { System.out.println("Error: " + e.getMessage()); }
    }
    static void showProducts() {
        System.out.println("Products: " + products);
    }

    // Main Menu
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Employee\n2. Get Employee\n3. Show Employees");
            System.out.println("4. Add Product\n5. Apply Discount\n6. Show Products\n7. Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1: addEmployee(); break;
                case 2: getEmployee(); break;
                case 3: showEmployees(); break;
                case 4: addProduct(); break;
                case 5: applyDiscount(); break;
                case 6: showProducts(); break;
                case 7: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice!");
            }
        }
    }
}
