class Animal {
    public void sound() {
        System.out.println("Generic Animal Sound");
    }
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Dog says: Bhaw Bhaw!");
    }
}

class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("Cat says: Meow Meow!");
    }
}

public class Question1 {
    public static void main(String[] args) {

        Animal animal1 = new Dog();
        Animal animal2 = new Cat();
        
        System.out.println("Demonstrating Runtime Polymorphism:");
        animal1.sound(); // Will call Dog's overridden method
        animal2.sound(); // Will call Cat's overridden method
        
        System.out.println("\nUsing an array of Animal references:");
        Animal[] animals = {new Dog(), new Cat(), new Dog()};
        
        for (Animal animal : animals) {
            animal.sound(); 
        }
    }
}
