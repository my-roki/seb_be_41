package section1.java_collection.coplit_collection;

/* 
removeFromBackOfNew

문제
ArrayList와 요소를 입력받아, 마지막 요소가 제거된 새로운 ArrayList을 리턴해야 합니다.

입력
인자 1 : arrayList
Integer 타입을 요소로 가지는 ArrayList

출력
Integer 타입을 요소로 가지는 새로운 ArrayList(주소값 다름)를 리턴해야 합니다.

주의 사항
입력받은 ArrayList를 수정하지 않아야 합니다(immutability).
빈 ArrayList를 입력받은 경우 null을 리턴해야 합니다.

입출력 예시
ArrayList<Integer> arrayList; // [0, 1, 2, 3, 4, 5]
ArrayList<Integer> output = removeFromBackOfNew(arrayList);
System.out.println(arrayList); // --> [0, 1, 2, 3, 4, 5]
System.out.println(output); // --> [0, 1, 2, 3, 4]
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Q_09_removeFromBackOfNew {
    public static void main(String[] args) {
        Q_09_removeFromBackOfNew coplit = new Q_09_removeFromBackOfNew();
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5)); // [0, 1, 2, 3, 4, 5]
        ArrayList<Integer> output = coplit.removeFromBackOfNew(arrayList);
        System.out.println(arrayList); // --> [0, 1, 2, 3, 4, 5]
        System.out.println(output); // --> [0, 1, 2, 3, 4]
    }

    public ArrayList<Integer> removeFromBackOfNew(ArrayList<Integer> arrayList) {
        int size = arrayList.size();
        if (size == 0) return null;
        ArrayList<Integer> output = new ArrayList<>();
        output.addAll(arrayList);
        output.remove(size-1);
        return output;
    }
}