package section2.daily_coding;

/*
removeExtremes
문제
문자열을 요소로 갖는 배열을 입력받아 가장 짧은 문자열과 가장 긴 문자열을 제거한 배열을 리턴해야 합니다.

입력
인자 1 : arr
String 타입을 요소로 갖는 배열
arr[i].length()는 20 이하

출력
배열을 리턴해야 합니다.

주의 사항
가장 짧은 문자열의 길이와 가장 긴 문자열의 길이가 같은 경우는 없습니다.
가장 짧은 문자열 또는 가장 긴 문자열이 다수일 경우, 나중에 위치한 문자열을 제거합니다.
공백을 입력받을 경우, null을 반환합니다.

입출력 예시
String[] output = removeExtremes(new String[]{"a", "b", "c", "def"});
System.out.println(output); // --> ["a"', "b"]

output = removeExtremes(new String[]{"where", "is", "the", "longest", "word"});
System.out.println(output); // --> ["where", "the", "word"]
 */

import java.util.Arrays;

public class Q_11_removeExtremes {
    public static void main(String[] args) {
        // write test case here
        Q_11_removeExtremes coplit = new Q_11_removeExtremes();
        String[] output = coplit.removeExtremes(new String[]{"a", "b", "c", "def"});
        System.out.println(Arrays.toString(output)); // --> ["a"', "b"]

        output = coplit.removeExtremes(new String[]{"where", "is", "the", "longest", "word"});
        System.out.println(Arrays.toString(output)); // --> ["where", "the", "word"]
    }

    public String[] removeExtremes(String[] arr) {
        if (arr.length == 0) return null;

        int shortest = 20;
        int longest = 0;
        int shortestIdx = 0;
        int longestIdx = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            String candidate = arr[i];
            int candidateLength = candidate.length();
            if (candidateLength < shortest) {
                shortest = candidateLength;
                shortestIdx = i;
            }
            if (candidateLength > longest) {
                longest = candidateLength;
                longestIdx = i;
            }
        }
        String[] output = new String[arr.length -2];
        int curIdx = 0;
        for (int j = 0; j < arr.length; j++) {
            if (j != longestIdx && j != shortestIdx){
                output[curIdx] = arr[j];
                curIdx ++;
            }
        }
        return output;
    }
}
