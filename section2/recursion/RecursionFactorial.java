package section2.recursion;

public class RecursionFactorial {
    public static void main(String[] args) {
        RecursionFactorial factorial = new RecursionFactorial();
        System.out.println("----- For Loop -----");
        int result1 = factorial.FactorialForLoop(10);
        System.out.println(result1);

        System.out.println("----- Recursion -----");
        int result2 = factorial.FactorialRecursion(10);
        System.out.println(result2);
    }

    // 반복문으로 구현한 팩토리얼 메서드
    public int FactorialForLoop(int number) {
        int result = 1;
        for(int count = number; count > 0; count--) {
            result = result * count;
        }
        return result;
    }

    // 재귀 호출로 구현한 팩토리얼 메서드
    public int FactorialRecursion(int number) {
        if(number <= 1) {
            return 1;
        }
        return number * FactorialRecursion(number - 1);
    }
}