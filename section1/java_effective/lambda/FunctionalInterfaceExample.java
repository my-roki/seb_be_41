package section1.java_effective.lambda;

@FunctionalInterface
interface MyFunctionalInterface1 {
    public void doSomething();
}

@FunctionalInterface
interface MyFunctionalInterface2 {
    public void doSomething(int x);
}

@FunctionalInterface
interface MyFunctionalInterface3 {
    public int doSomething(int x, int y);
}


public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        // 매개변수와 리턴값이 없는 람다식
        MyFunctionalInterface1 example1;
        example1 = () -> {
            String str = "First method!";
            System.out.println(str);
        };
        example1.doSomething();

        example1 = () -> System.out.println("Second method!");
        example1.doSomething();

        // 매개변수가 있는 람다식
        MyFunctionalInterface2 example2;
        example2 = (x) -> {
            int result = x * 5;
            System.out.println(result);
        };
        example2.doSomething(15);

        example2 = (x) -> System.out.println(x * 5);
        example2.doSomething(25);

        // 리턴값이 있는 람다식
        MyFunctionalInterface3 example3;
        example3 = (x, y) -> {
            int result = x + y;
            return result;
        };
        int result1 = example3.doSomething(2, 9);
        System.out.println(result1);


        example3 = (x, y) -> {
            return x + y;
        };
        int result2 = example3.doSomething(4, 6);
        System.out.println(result2);

        example3 = (x, y) -> x + y;
        // 실행문이 한 줄인 경우, 중괄호 {}와 return문 생략가능
        int result3 = example3.doSomething(7, 5);
        System.out.println(result3);


        example3 = (x, y) -> sum(x, y);
        // 실행문이 한 줄인 경우, 중괄호 {}와 return문 생략가능
        int result4 = example3.doSomething(8, 8);
        System.out.println(result4);
    }

    public static int sum(int x, int y) {
        return x + y;
    }
}


