package section1.java_collection.coplit_collection;

/* 
removeFromFront

문제
Integer 타입을 요소로 가지는 ArrayList를 입력받아 ArrayList의 첫번째 요소를 삭제하고, 삭제된 해당 요소를 리턴해야 합니다.

입력
인자 1 : arrayList
Integer 타입을 요소로 가지는 ArrayList

출력
ArrayList의 첫 번째 요소를 삭제하고 삭제한 요소를 리턴해야 합니다.

주의 사항
입력받은 ArrayList의 첫번째 요소는 삭제되어야 합니다.
비어있는 ArrayList를 입력받은 경우엔 null 을 리턴합니다.

입출력 예시
ArrayList<Integer> arrayList; // [0, 1, 2, 3, 4, 5]
Integer output = removeFromFront(arrayList);
System.out.println(output); // --> 0
System.out.println(arrayList); // --> [1, 2, 3, 4, 5]

힌트
메서드의 제목을 활용해 검색해 봅니다(java how remove element of arrayList)
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Q_07_removeFromFront {
    public static void main(String[] args) {
        Q_07_removeFromFront coplit = new Q_07_removeFromFront();
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5)); // [0, 1, 2, 3, 4, 5]
        Integer output = coplit.removeFromFront(arrayList);
        System.out.println(output); // --> 0
        System.out.println(arrayList); // --> [1, 2, 3, 4, 5]
    }

    public Integer removeFromFront(ArrayList<Integer> arrayList) {
        if (arrayList.size() == 0) return null;
        int output = arrayList.get(0);
        arrayList.remove(0);
        return output;
    }
}