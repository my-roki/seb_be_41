package section1.java_collection.coplit_collection;

import java.util.ArrayList;
import java.util.Arrays;

/* 
addLast

문제
String 타입을 요소로 가지는 ArrayList와 문자열 요소를 입력받아, 주어진 요소를 ArrayList의 맨 뒤에 추가하고 해당 ArrayList를 리턴해야 합니다.

입력
인자 1 : arrayList
String 타입을 요소로 가지는 ArrayList
인자 2 : str
String 타입의 임의의 문자열

출력
기존 ArrayList에 주어진 요소가 추가된 형태의 ArrayList를 리턴해야 합니다.
[arrarList[0], arrarList[1], ..., arrayList[n-1], str]
arrayList.size()는 n

주의 사항
반복문(for, while) 사용은 금지됩니다.
새로운 ArrayList를 선언 / 할당해서 리턴하지 않습니다.
기존 ArrayList에 주어진 요소가 추가된 상태(주소값 동일)로 리턴해야 합니다.

입출력 예시
ArrayList<String> arrayList; // ["a", "b"]
ArrayList<String> output = addLast(arrayList, "c");
System.out.println(output); // --> ["a", "b", "c"]

힌트
메서드의 제목(addLast)을 활용해 검색해 봅니다(java how to add last in arrayList)
*/

public class Q_04_addLast {
    public static void main(String[] args) {
        Q_04_addLast coplit = new Q_04_addLast();
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("a", "b")); // ["a", "b"]
        ArrayList<String> output = coplit.addLast(arrayList, "c");
        System.out.println(output); // --> ["a", "b", "c"]
    }

    public ArrayList<String> addLast(ArrayList<String> arrayList, String str) {
        arrayList.add(str);
        return arrayList;
    }
}