package section1.java_basic.if_else;

/*
convertScoreToGrade

문제
점수를 입력받아 점수에 해당하는 등급을 리턴해야 합니다.

입력
인자 1 : score
int 타입의 정수

출력
char 타입을 리턴해야 합니다.
(100 - 90) --> 'A'
(89 - 80) --> 'B'
(79 - 70) --> 'C'
(69 - 60) --> 'D'
(59 - 0) --> 'F'

주의 사항
만약 주어진 점수가 100을 초과하거나 0 미만이라면 문자 'X'를 리턴해야 합니다.

입출력 예시
char output = convertScoreToGrade(91);
System.out.println(output); // --> 'A'

힌트
자바(를 포함한 거의 대부분의 프로그래밍 언어)의 비교 연산자는 이항 연산자(binary operator)입니다.
이항 연산자는 2개의 대상에 대해서만 연산을 수행합니다.
70 < score < 80 와 같은 표현은 보이는 대로 작동하지 않습니다.
*/

public class Q_12_convertScoreToGrade {
    public static void main(String[] args) {
        Q_12_convertScoreToGrade coplit = new Q_12_convertScoreToGrade();
        System.out.println(coplit.convertScoreToGrade(91));

    }

    public char convertScoreToGrade(int score) {
        // TODO:
        char grade;
        if (score > 100 || score < 0) {
            return 'X';
        }
        if (score >= 90) {
            grade = 'A';
        } else if (score >= 80) {
            grade = 'B';
        } else if (score >= 70) {
            grade = 'C';
        } else if (score >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        return grade;
    }
}