package section1.java_basic.if_else;

/*
daysInMonth

문제
특정 달(month)을 입력받아 각 달에 몇 일이 있는지 리턴해야 합니다.

입력
인자 1 : month
int 타입의 정수 (1 <= month && month <= 12)

출력
int 타입을 리턴해야 합니다.

주의 사항
월 예시) 1월은 1, 2월은 2... 12월은 12입니다.
7월과 8월에는 모두 31일이 존재합니다.
2월 29일은 존재하지 않는다고 가정합니다.

입출력 예시
int output = daysInMonth(1);
System.out.println(output); // --> 31

output = daysInMonth(5);
System.out.println(output); // --> 31

output = daysInMonth(2);
System.out.println(output); // --> 28
*/

public class Q_09_daysInMonth {
    public static void main(String[] args) {
        Q_09_daysInMonth coplit = new Q_09_daysInMonth();
        System.out.println(coplit.daysInMonth(1));
        System.out.println(coplit.daysInMonth(5));
        System.out.println(coplit.daysInMonth(2));

    }

    public int daysInMonth(int month) {
        // TODO:
        if ((month <= 7 && month % 2 == 1) || (month > 7 && month % 2 == 0)) {
            return 31;
        }
        if (month == 2) {
            return 28;
        }
        return 30;
    }
}