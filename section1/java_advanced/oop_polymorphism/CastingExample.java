package section1.java_advanced.oop_polymorphism;

public class CastingExample {
    public static void main(String[] args) {
        Car car = new Car();
        Vehicle vehicle = car; // 상위 클래스 Vehicle 타입으로 변환(생략 가능)
        Car car2 = (Car) vehicle; // 하위 클래스 Car타입으로 변환(생략 불가능)
        // MotorBike motorBike = (MotorBike) car; // 상속관계가 아니므로 타입 변환 불가 -> 에러발생
    }
}

class Vehicle {
}

class Car extends Vehicle {
}

class MotorBike extends Vehicle {
}