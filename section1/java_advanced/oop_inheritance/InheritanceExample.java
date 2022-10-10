package section1.java_advanced.oop_inheritance;

public class InheritanceExample {
    public static void main(String[] args) {
        // Person 객체 생성
        Person roki = new Person();
        roki.name = "roki";
        roki.age = 30;
        roki.eat();
        roki.walk();
        roki.learn();
        System.out.println(roki.name);

        // Programmer 객체 생성
        Programmer toki = new Programmer();
        toki.name = "toki";
        toki.age = 22;
        toki.eat();
        toki.walk();
        toki.learn();
        toki.coding();
        System.out.println(toki.name);
    }
}

class Person {
    String name;
    int age;

    void learn() {
        System.out.println("Learning...");
    }

    void walk() {
        System.out.println("Walking...");
    }

    void eat() {
        System.out.println("Eating...");
    }
}

class Programmer extends Person {  // Person 클래스로부터 상속. extends 키워드 사용
    String department;

    void coding() {
        System.out.println("Coding...");
    }
}

class Dancer extends Person {
    String team;

    void dancing() {
        System.out.println("Dancing...");
    }
}

class singer extends Person {
    String band;

    void Singing() {
        System.out.println("Singing...");
    }
}






// Eating...
// Walking...
// Learning...
// roki
// Eating...
// Walking...
// Learning...
// Coding...
// toki





