package section1.java_advanced.oop_inheritance;

public class Super {
    public static void main(String[] args) {
        Lower lower = new Lower();
        lower.call();

    }
}

class Upper {
    int count = 20;  // super.count

    Upper() {
        System.out.println("Upper Class Constructor");
    }
}

class Lower extends Upper {
    int count = 15;

    Lower() {
        super();  // 첫 줄에 super() 생성자를 입력 안 해도 자동으로 입력됩니다.
        System.out.println("Lower Class Constructor");
        // super();  // Call to 'super()' must be first statement in constructor body
    }

    void call() {
        System.out.printf("count = %d%n", count);
        System.out.printf("this.count = %d%n", this.count);
        System.out.printf("super.count = %d%n", super.count);
    }
}

// Upper Class Constructor
// Lower Class Constructor