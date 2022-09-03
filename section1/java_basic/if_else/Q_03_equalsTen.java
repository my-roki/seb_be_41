package section1.java_basic.if_else;

/*
equalsTen

문제
수를 입력받아 10과 같은지 여부를 리턴해야 합니다.

입력
인자 1 : num
int 타입의 수

출력
boolean 타입을 리턴해야 합니다.

입출력 예시
boolean output = equalsTen(9);
System.out.println(output); // --> false
*/

public class Q_03_equalsTen {
    public static void main(String[] args) {
        Q_03_equalsTen coplit = new Q_03_equalsTen();
        System.out.println(coplit.equals(9));

    }

    public boolean equalsTen(int num) {
        // TODO:
        if (num == 10) {
            return true;
        }
        return false;
    }
}