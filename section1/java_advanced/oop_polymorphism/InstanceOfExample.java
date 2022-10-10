package section1.java_advanced.oop_polymorphism;

public class InstanceOfExample {
    public static void main(String[] args) {
        Animal animal = new Animal();
        System.out.println(animal instanceof Object); //true
        System.out.println(animal instanceof Animal); //true
        System.out.println(animal instanceof Bat); //false

        Animal cat = new Cat();
        System.out.println(cat instanceof Object); //true
        System.out.println(cat instanceof Animal); //true
        System.out.println(cat instanceof Cat); //true
        System.out.println(cat instanceof Bat); //false
    }
}

class Animal {
};

class Bat extends Animal {
};

class Cat extends Animal {
};