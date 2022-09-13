package section1.java_collection.generic;

class MainBasket<T> {
    private T item;

    public MainBasket(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}

public class Main {
    public static void main(String[] args) {
        MainBasket<String> basket1 = new MainBasket<>("item");
        System.out.println(basket1.getItem());

        MainBasket<Integer> basket2 = new MainBasket<>(123);
        System.out.println(basket2.getItem());
    }
}
