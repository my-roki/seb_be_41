package section1.java_advanced.oop_abstraction;

public class InterfaceExample {
    public static void main(String[] args) {
        Wizard wizard = new Wizard();
        Warrior warrior = new Warrior();

        wizard.hit();
        wizard.shield();
        warrior.hit();
        warrior.shield();
    }
}

interface Offense {
    public abstract void hit();
}

interface Defense {
    public abstract void shield();
}

class Wizard implements Offense, Defense {
    @Override
    public void hit() {
        System.out.println("Magic attack!");
    }

    @Override
    public void shield() {
        System.out.println("Magic shield!");
    }
}

class Warrior implements Offense, Defense {
    @Override
    public void hit() {
        System.out.println("Spear attack!");
    }

    @Override
    public void shield() {
        System.out.println("Heavy armor");

    }
}