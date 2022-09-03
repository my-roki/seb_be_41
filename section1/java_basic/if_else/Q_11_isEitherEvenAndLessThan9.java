package section1.java_basic.if_else;

/*
isEitherEvenAndLessThan9

문제
두 개 수를 입력받아 아래의 2가지 조건을 모두 만족하는지 검사합니다.

EitherEven: 적어도 하나의 수는 짝수이다.
LessThan9: 두 수 모두 9보다 작다.

입력
인자 1 : num1
int 타입의 정수 (num1 >= 0)
인자 2 : num2
int 타입의 정수 (num2 >= 0)

출력
boolean 타입을 리턴해야 합니다.

입출력 예시
boolean output = isEitherEvenAndLessThan9(2, 4);
System.out.println(output); // --> true

output = isEitherEvenAndLessThan9(72, 2);
System.out.println(output); // --> false
*/

public class Q_11_isEitherEvenAndLessThan9 {
    public static void main(String[] args) {
        Q_11_isEitherEvenAndLessThan9 coplit = new Q_11_isEitherEvenAndLessThan9();
        System.out.println(coplit.isEitherEvenAndLessThan9(2, 4));
        System.out.println(coplit.isEitherEvenAndLessThan9(72, 2));

    }

    public boolean isEitherEvenAndLessThan9(int num1, int num2) {
        // TODO:
        if (num1 < 9 && num2 < 9) {
            if (num1 % 2 == 0 || num2 % 2 == 0) {
                return true;
            }
            return false;
        }
        return false;
    }
}