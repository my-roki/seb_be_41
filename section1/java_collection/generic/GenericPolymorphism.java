package section1.java_collection.generic;

class Flower {
}

class Rose extends Flower {
}

class RosePasta {
}

class GPBasket<T> {
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}

public class GenericPolymorphism {
    public static void main(String[] args) {
        GPBasket<Flower> flowerBasket = new GPBasket<>();
        flowerBasket.setItem(new Rose());
        // flowerBasket.setItem(new RosePasta());
    }
}
