package section1.java_effective.coplit_stream;

/*
findLongestLength

문제
String 타입을 요소로 가지는 배열을 입력받아, 가장 길이가 긴 문자열 요소의 길이를 리턴해야 합니다.

입력
인자 1 : strArr
String 타입을 요소로 가지는 배열

출력
int 타입을 리턴해야 합니다.

주의 사항
반복문(for, while) 사용은 금지됩니다.
빈 배열을 입력받은 경우 0을 리턴해야 합니다.

입출력 예시
String[] strArr = {"codestates", "java", "backend", "programming"};
int output = findLongestLength(strArr);
System.out.println(output); // 11 (가장 긴 문자열 : programming)

힌트
stream을 통해 배열의 요소를 순회할 수 있습니다.
stream을 통해 요소의 길이를 기준으로 순회할 수 있습니다.
 */

import java.util.Arrays;

public class Q_09_findLongestLength {
    public static void main(String[] args) {
        Q_09_findLongestLength coplit = new Q_09_findLongestLength();
        String[] strArr = {"codestates", "java", "backend", "programming"};
        int output = coplit.findLongestLength(strArr);
        System.out.println(output); // 11 (가장 긴 문자열 : programming)
    }

    public int findLongestLength(String[] strArr) {
        if (strArr.length == 0) return 0;
        int output = Arrays.stream(strArr)
                .mapToInt(String::length)
                .max()
                .getAsInt();
        return  output;
    }
}