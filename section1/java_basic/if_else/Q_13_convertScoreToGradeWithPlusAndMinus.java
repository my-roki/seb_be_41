package section1.java_basic.if_else;

/*
convertScoreToGradeWithPlusAndMinus

문제
점수를 입력받아 점수에 해당하는 등급을 리턴해야 합니다.

입력
인자 1 : score
int 타입의 정수

출력
String 타입을 리턴해야 합니다.
각 등급의 최저 점수는 아래와 같습니다. ("F"의 경우 최대 점수를 표기)
90 이상 --> "A"
80 이상 --> "B"
70 이상 --> "C"
60 이상 --> "D"
60 미만 --> "F"

주의 사항
만약 주어진 점수가 100을 초과하거나 0 미만인 경우, 문자열 "INVALID SCORE"를 리턴해야 합니다.
각 등급의 최고 점수보다 7점 이하인 경우, 등급과 함께 "-"를 리턴해야 합니다. (단, 93점의 경우에는 A를 리턴해야 합니다.)
각 등급의 최저 점수보다 8점 이상인 경우, 등급과 함께 "+"를 리턴해야 합니다.
F+ 와 F- 는 존재하지 않습니다.

입출력 예시
String output = convertScoreToGradeWithPlusAndMinus(91);
System.out.println(output); // --> "A-"
*/

public class Q_13_convertScoreToGradeWithPlusAndMinus {
    public static void main(String[] args) {
        Q_13_convertScoreToGradeWithPlusAndMinus coplit = new Q_13_convertScoreToGradeWithPlusAndMinus();
        System.out.println(coplit.convertScoreToGradeWithPlusAndMinus(91));

    }

    public String convertScoreToGradeWithPlusAndMinus(int score) {
        // TODO:
        if (score > 100 || score < 0) {
            return "INVALID SCORE";
        }

        String grade;
        if (score >= 90) {
            grade = "A";
        } else if (score >= 80) {
            grade = "B";
        } else if (score >= 70) {
            grade = "C";
        } else if (score >= 60) {
            grade = "D";
        } else {
            return grade = "F";
        }

        if (score % 10 >= 8 || score == 100) {
            return grade + "+";
        }
        if (score % 10 < 3) {
            return grade + "-";
        }
        return grade;

    }
}