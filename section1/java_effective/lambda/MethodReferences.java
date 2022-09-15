package section1.java_effective.lambda;

import java.util.function.IntBinaryOperator;

class Calculator {
    public static int staticMethod(int x, int y) {
        return x + y;
    }

    public int instanceMethod(int x, int y) {
        return x * y;
    }
}

public class MethodReferences {
    public static void main(String[] args) {
        IntBinaryOperator operator;
        /*
        정적 메서드
		클래스이름::메서드이름
		*/
        operator = Calculator::staticMethod;
        System.out.println("정적 메서드 결과 : " + operator.applyAsInt(3, 8));

        /*
        인스턴스 메서드
		인스턴스명::메서드명
		*/
        Calculator calculator = new Calculator();
        operator = calculator::instanceMethod;
        System.out.println("인스턴스 메서드 결과 : " + operator.applyAsInt(3, 8));
    }
}