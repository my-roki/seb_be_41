package section2.daily_coding;

/*
computeSquareRoot
문제
수를 입력받아 제곱근 값을 소수점 두 자리까지 리턴해야 합니다.

입력
인자 1 : num
int 타입의 정수 (num >= 2)

출력
String 타입을 리턴해야 합니다.
최대 소수점 둘째 짜리까지 구한 수를 문자열로 변환하여 출력합니다. (소수점 셋째 자리에서 반올림)

주의 사항
Math.sqrt 사용은 금지됩니다.

입출력 예시
String output = computeSquareRoot(9);
System.out.println(output); // --> "3.00"

output = computeSquareRoot(6);
System.out.println(output); // --> "2.45"

힌트
소수점 처리는 java 표준 내장 객체인 String를 검색해 봅니다. (java decimal places limit 또는 자바 소수점 자리수)
각 자리수(1, 0.1, 0.01, 0.001)마다 (목표값을 넘지 않는) 근사값을 구하는 방식이 있습니다.
제곱근을 구하는 방법 중 바빌로니아 법이 있습니다. 바빌로니아 법의 점화식(recurrence formula)을 이해할 수 있다면, 해당 식을 이용해 문제를 풀어도 좋습니다.
 */

public class Q_17_computeSquareRoot {
    public static void main(String[] args) {
        // write test case here
        Q_17_computeSquareRoot coplit = new Q_17_computeSquareRoot();

        String output = coplit.computeSquareRoot(9);
        System.out.println(output); // --> "3.00"

        output = coplit.computeSquareRoot(6);
        System.out.println(output); // --> "2.45"

    }

    public String computeSquareRoot(int num) {
        double leftNum = 1;
        // 자연수 부분 중 제곱의 근사치를 구합니다.
        while (Math.pow(leftNum, 2) <= num) leftNum += 1;
        leftNum = leftNum - 1;

        // 근사치를 사이에서 소수점 0.001씩 증가하여 제곱에 근사한 값을 찾습니다.
        while (Math.pow(leftNum, 2) <= num) leftNum += 0.001;
        leftNum = Math.round(leftNum * 100) / 100.0;
        String output = String.format("%.2f", leftNum);
        return output;
    }
}
