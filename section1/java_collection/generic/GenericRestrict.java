package section1.java_collection.generic;

class GRBasket<T> { // 1 : 여기에서 선언한 타입 매개변수 T와
    public <K> void add(K element) { // 2 : 여기에서 선언한 타입 매개변수 K는 서로 다른 것입니다.
        System.out.print(element);
        System.out.println("제네릭 메서드입니다.");
    }
}

public class GenericRestrict {
    public static void main(String[] args) {
        GRBasket<String> basket = new GRBasket<>(); // 위 예제의 1의 T가 String으로 지정됩니다.
        basket.<Integer>add(10); // 위 예제의 2의 T가 Integer로 지정됩니다.
        basket.add(10); // 타입 지정을 생략할 수도 있습니다.
    }
}
