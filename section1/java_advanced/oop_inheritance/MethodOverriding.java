package section1.java_advanced.oop_inheritance;

public class MethodOverriding {
    public static void main(String[] args) {
        // 각각의 타입으로 선언 + 각각의 타입으로 객체 생성
        Vehicle vehicle = new Vehicle();
        Bike bike = new Bike();
        Car car = new Car();
        Bus bus = new Bus();

        vehicle.run();
        bike.run();
        car.run();
        bus.run();

        System.out.println("=".repeat(20));

        // 상위 클래스 타입으로 선언 + 각각 타입으로 객체 생성
        Vehicle bike2 = new Bike();
        Vehicle car2 = new Car();
        Vehicle bus2 = new Bus();

        bike2.run();
        car2.run();
        bus2.run();

        System.out.println("=".repeat(20));

        // 배열로 한번에 관리하기
        Vehicle[] vehicles = new Vehicle[]{new Bike(), new Car(), new Bus()};
        for (Vehicle v : vehicles) {
            v.run();
        }
    }
}

class Vehicle {
    void run() {
        System.out.println("Vehicle is running!");
    }
}

class Bike extends Vehicle {
    void run() {
        System.out.println("Bike is running!");
    }
}

class Car extends Vehicle {
    void run() {
        System.out.println("Car is running!");
    }
}

class Bus extends Vehicle {
    void run() {
        System.out.println("Bus is running!");
    }
}
