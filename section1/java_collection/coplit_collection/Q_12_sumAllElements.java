package section1.java_collection.coplit_collection;

/* 
sumAllElements

문제
Integer 타입의 ArrayList를 입력받아 모든 요소를 더한 값을 리턴해야 합니다.

입력
인자 1 : arrayList
Integer 타입의 ArrayList

출력
int 타입을 리턴해야 합니다.

주의 사항
비어있는 ArrayList를 입력받은 경우 0을 리턴해야 합니다.
Iterator를 이용해 요소를 순회해야 합니다.

입출력 예시
ArrayList<Integer> arrayList; // [1, 2, 3, 4, 5]
int output = sumAllElements(arrayList);
System.out.println(output); // --> 15

힌트
Iterator를 이용해 요소를 순회할 수 있습니다.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Q_12_sumAllElements {
    public static void main(String[] args) {
        Q_12_sumAllElements coplit = new Q_12_sumAllElements();
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)); // [1, 2, 3, 4, 5]
        int output = coplit.sumAllElements(arrayList);
        System.out.println(output); // --> 15
    }

    public int sumAllElements(ArrayList<Integer> arrayList) {
        int output = 0;
        if (arrayList.size() == 0) return output;

        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            int el = iterator.next();
            output += el;
        }
        return output;
    }
}