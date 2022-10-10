package section1.java_advanced.oop_encapsulation;

public class GetterAndSetter {
    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.setName("roki");
        worker.setAge(30);
        worker.setId(5);

        System.out.printf("My name is %s.%n", worker.getName());
        System.out.printf("I am %d years old.%n", worker.getAge());
        System.out.printf("My worker ID is %d.%n", worker.getId());
    }
}

class Worker {
    private String name; // 변수의 은닉화. 외부로부터 접근 불가
    private int age;
    private int id;

    public String getName() { // 멤버변수의 값
        return name;
    }

    public void setName(String name) { // 멤버변수의 값 변경
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 1) return;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}