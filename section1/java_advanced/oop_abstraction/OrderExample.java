package section1.java_advanced.oop_abstraction;

// 인터페이스 활용 예제
//카페 손님
interface Customer {
    public abstract String getOrder();
}

class CustomerA implements Customer {
    @Override
    public String getOrder() {
        return "a glass of iced americano";
    }
}

class CustomerB implements Customer {
    @Override
    public String getOrder() {
        return "a glass of strawberry latte";
    }
}

class CafeOwner {
    public void giveItem(Customer customer) {
        System.out.println("Item : " + customer.getOrder());
    }
}

public class OrderExample {
    public static void main(String[] args) {
        CafeOwner cafeOwner = new CafeOwner();
        CustomerA customerA = new CustomerA();
        CustomerB customerB = new CustomerB();

        cafeOwner.giveItem(customerA);
        cafeOwner.giveItem(customerB);

    }
}