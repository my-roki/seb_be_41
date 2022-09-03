package section1.java_basic.if_else;

/*
fizzBuzz

문제
수를 입력받아 3 그리고 5로 각각 나눈 뒤 나머지 값에 따라 알맞은 메시지를 리턴해야 합니다.

입력
인자 1 : num
int 타입의 정수 (num >= 1)

출력
String 타입을 리턴해야 합니다.
3으로 나누어 떨어지는 경우, "Fizz"를 리턴해야 합니다.
5으로 나누어 떨어지는 경우, "Buzz"를 리턴해야 합니다.
3과 5로 모두 나누어 떨어지는 경우, "FizzBuzz"를 리턴해야 합니다.
3이나 5로 나누어 떨어지지 않는 경우, "No FizzBuzz"를 리턴해야 합니다.

입출력 예시
String output = fizzBuzz(3);
System.out.println(output); // --> "Fizz"

output = fizzBuzz(5);
System.out.println(output); // --> "Buzz"

output = fizzBuzz(15);
System.out.println(output); // --> "FizzBuzz"

output = fizzBuzz(7);
System.out.println(output); // --> "No FizzBuzz"
*/

public class Q_07_fizzBuzz {
    public static void main(String[] args) {
        Q_07_fizzBuzz coplit = new Q_07_fizzBuzz();
        System.out.println(coplit.fizzBuzz(3));
        System.out.println(coplit.fizzBuzz(5));
        System.out.println(coplit.fizzBuzz(15));
        System.out.println(coplit.fizzBuzz(7));

    }

    public String fizzBuzz(int num) {
        // TODO:
        if (num % 3 == 0 && num % 5 == 0) {
            return "FizzBuzz";
        } else if (num % 3 == 0) {
            return "Fizz";
        } else if (num % 5 == 0) {
            return "Buzz";
        }
        return "No FizzBuzz";
    }
}