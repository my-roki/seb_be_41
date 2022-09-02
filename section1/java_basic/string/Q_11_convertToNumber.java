
package section1.java_basic.string;

/* 
convertToNumber
우리는 직전 문제에서 ''따옴표로 감싸져있는 문자가 숫자로 변환하여 연산됨을 학습했습니다. 
자바에서 타입에 따라 자동으로 형변환(Type Casting)이 이루어지기 때문입니다. 문자 하나하나가 어떤 숫자로 변환될지 확인해볼까요?

문제
문자(Character) 하나를 입력받아 알맞은 값(int)을 리턴합니다.

입력
인자 1 : character
char 타입의 문자

출력
int 타입을 리턴해야 합니다.

입출력 예시
int output = convertToNumber('9');
system.out.println(output); // --> 9

힌트
char 타입의 데이터를 int형으로 바꾸는 방법을 찾아보세요! (How To Convert Char To Int Java)
 */

public class Q_11_convertToNumber {
    public static void main(String[] args) {
        Q_11_convertToNumber coplit = new Q_11_convertToNumber();
        System.out.println(coplit.convertToNumber('9'));
        System.out.println(coplit.convertToNumber('0'));
        System.out.println(coplit.convertToNumber('4'));
    }

    public int convertToNumber(char character) {
        int result;
        // TODO: 여기에 코드를 작성합니다.
        result = Character.getNumericValue(character);
        // 하단의 코드는 수정하지 말아야 합니다.
        return result;
    }
}