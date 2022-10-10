package section1.java_advanced.oop_polymorphism;

public class PolymorphismCustomer {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setMoney(50000);

        customer.buyCoffee(new Americano());
        System.out.printf("현재 잔액은 %d원 입니다.%n", customer.getMoney());

        customer.buyCoffee(new Latte());
        System.out.printf("현재 잔액은 %d원 입니다.%n", customer.getMoney());

    }
}

class Coffee {
    int price;

    public Coffee(int price) {
        this.price = price;
    }
}

class Americano extends Coffee {
    public Americano() {
        super(4000);
    }

    public String toString() {
        return "Americano~";
    }  //Object 클래스 toString()메서드 오버라이딩
};

class Latte extends Coffee {
    public Latte() {
        super(5000);
    }

    public String toString() {
        return "Latte~";
    }
};


class Customer {
    private int money;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    void buyCoffee(Americano americano) {
        this.money = money - americano.price;
        System.out.println(americano + "를 구입했습니다.");
    }

    void buyCoffee(Latte latte) {
        this.money = money - latte.price;
        System.out.println(latte + "를 구입했습니다.");
    }

    void buyCoffee(Coffee coffee) {
        this.money = money - coffee.price;
        System.out.println(coffee + "를 구입했습니다.");
    }
}