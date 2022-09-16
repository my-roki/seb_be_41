package section1.java_effective.coplit_stream;

/*
isHot

문제
이번주의 최고 온도만을 모아놓은 List를 분석하여 이번주가 더웠는지 알아봅시다.
최고 기온이 30도를 넘은 날이 3일 이상이면 true를, 그렇지 않다면 false를 리턴해야 합니다.

입력
인자 1 : temperature
int 타입을 요소로 가지며 길이가 7인 배열

출력
boolean 타입을 리턴해야 합니다.

주의 사항
반복문(for, while) 사용은 금지됩니다.
30도 이상은 30도를 포함합니다.
입력받은 배열의 길이가 7이 아닌 경우 false를 리턴해야 합니다.

입출력 예시
int[] temperature = {25, 29, 30, 31, 26, 30, 33};
boolean output = isHot(temperature);
System.out.println(output); // true

힌트
Stream을 통해 각 요소가 특정 숫자 이상인 경우의 셀 수 있습니다.
Stream의 최종 연산 후 결과를 다른 연산에 사용할 수 있습니다.
 */

import java.util.Arrays;

public class Q_12_isHot {
    public static void main(String[] args) {
        Q_12_isHot coplit = new Q_12_isHot();
        int[] temperature = {25, 29, 30, 31, 26, 30, 33};
        boolean output = coplit.isHot(temperature);
        System.out.println(output); // true

    }

    public boolean isHot(int[] temperature) {
        if (temperature.length != 7) return false;
        long over30 = Arrays.stream(temperature)
                .filter(n -> n >= 30)
                .count();

        return over30 >= 3;
    }
}