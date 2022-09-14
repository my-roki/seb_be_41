package section1.java_collection.coplit_collection;

/* 
clearArrayList

문제
입력받은 ArrayList의 모든 요소를 삭제한 뒤 해당 ArrayList를 리턴해야 합니다.

입력
인자 1 : arrayList
Integer 타입을 요소로 가지는 ArrayList

출력
입력받은 ArrayList의 요소를 모두 삭제한 뒤, 동일한 주소값을 갖는 ArrayList를 리턴해야 합니다.

주의 사항
기존 ArrayList에 모든 요소를 삭제한 후 리턴해야 합니다.
입력받은 ArrayList와 리턴하는 ArrayList는 같은 주소값을 가져야 합니다.
반복문(for, while) 사용은 금지됩니다.

입출력 예시
ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
ArrayList<Integer> output = clearArrayList(arrayList);
System.out.println(output); // --> []

힌트
메서드의 제목(clearArrayList)을 활용해 검색해 봅니다(java how to clear arrayList)
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Q_11_clearArrayList {
    public static void main(String[] args) {
        Q_11_clearArrayList coplit = new Q_11_clearArrayList();
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> output = coplit.clearArrayList(arrayList);
        System.out.println(output); // --> []
    }

    public ArrayList<Integer> clearArrayList(ArrayList<Integer> arrayList) {
        arrayList.clear();
        return arrayList;
    }
}