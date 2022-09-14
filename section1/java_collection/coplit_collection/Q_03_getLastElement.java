package section1.java_collection.coplit_collection;

import java.util.ArrayList;
import java.util.Arrays;

/* 
getLastElement

문제
문자열타입의 ArrayList를 입력받아 마지막 요소를 리턴해야 합니다.

입력
인자 1 : arrayList
String 타입의 ArrayList

출력
String 타입을 리턴해야 합니다.

주의 사항
빈 ArrayList의 경우 null을 리턴해야 합니다.

입출력 예시
ArrayList<String> arrayList; // ["코", "드", "스", "테", "이", "츠"]
String output = getLastElement(arrayList);
System.out.println(output); // --> "츠"

힌트
size() 메서드를 통해 총 요소가 몇 개인지 확인할 수 있습니다.
ArrayList의 인덱스는 0부터 시작합니다.
생성된 ArrayList에 get() 메서드를 통해 특정 요소를 조회할 수 있습니다.
*/

public class Q_03_getLastElement {
    public static void main(String[] args) {
        Q_03_getLastElement coplit = new Q_03_getLastElement();
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("코", "드", "스", "테", "이", "츠"));
        String output = coplit.getLastElement(arrayList);
        System.out.println(output); // --> "츠"

    }

    public String getLastElement(ArrayList<String> arrayList) {
        int size = arrayList.size();
        if (size == 0) return null;
        return arrayList.get(size - 1);
    }
}