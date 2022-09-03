package section1.java_basic.if_else;

/*
isOldEnoughToDrink

문제
나이를 입력받아 술을 마실 수 있는지(18세 이상) 여부를 리턴해야 합니다.

입력
인자 1 : age
int 타입의 나이 (0 이상의 정수)

출력
boolean 타입을 리턴해야 합니다.

입출력 예시
boolean output = isOldEnoughToDrink(18);
System.out.println(output); // --> true

output = isOldEnoughToDrink(17);
System.out.println(output); // --> false
*/

public class Q_01_isOldEnoughToDrink {
    public static void main(String[] args) {
        Q_01_isOldEnoughToDrink coplit = new Q_01_isOldEnoughToDrink();
        System.out.println(coplit.isOldEnoughToDrink(18));
        System.out.println(coplit.isOldEnoughToDrink(17));

    }

    public boolean isOldEnoughToDrink(int age) {
        // TODO:
        if (age >= 18) {
            return true;
        }
        return false;
    }
}