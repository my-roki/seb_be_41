package section1.java_collection.coplit_collection;

/* 
arrayToArrayList

문제
String 타입을 요소로 가지는 배열을 입력받아, String 타입을 요소로 가지는 ArrayList로 변환하여 리턴해야 합니다.

입력
인자 1 : arr
String 타입을 요소로 가지는 배열

출력
String 타입을 요소로 가지는 ArrayList를 리턴해야 합니다.

입출력 예시
String[] arr = {"백엔드", "개발자", "김코딩"};
List<String> output = arrayToArrayList(arr);
System.out.println(output); // --> ["백엔드", "개발자", "김코딩"]

주의사항
빈 배열의 경우 null을 리턴해야 합니다.

힌트
메서드의 제목(arrayToList)을 활용해 검색해 봅니다(java array to List)
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q_10_arrayToArrayList {
    public static void main(String[] args) {
        Q_10_arrayToArrayList coplit = new Q_10_arrayToArrayList();
        String[] arr = {"백엔드", "개발자", "김코딩"};
        List<String> output = coplit.arrayToArrayList(arr);
        System.out.println(output); // --> ["백엔드", "개발자", "김코딩"]
    }

    public List<String> arrayToArrayList(String[] arr) {
        if (arr.length == 0) return null;
        List<String> output = new ArrayList<>(Arrays.asList(arr));
        return output;
    }
}