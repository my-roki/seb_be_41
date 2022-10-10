package section1.java_advanced.oop_inheritance;

public class CompositeExample {
    int id;
    String name;
    Address address;

    public CompositeExample(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    void showInfo() {
        System.out.println(id + ": " + name);
        System.out.println(address.city + ": " + address.country);
    }


    public static void main(String[] args) {
        Address address1 = new Address("Seoul", "Korea");
        Address address2 = new Address("Tyoko", "Japan");

        CompositeExample ce1 = new CompositeExample(1, "roki", address1);
        CompositeExample ce2 = new CompositeExample(2, "toki", address2);

        ce1.showInfo();
        ce2.showInfo();
    }
}

class Address {
    String city, country;

    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }
}