package section1.java_collection.coplit_collection;

import java.util.ArrayList;
import java.util.Arrays;

/* 
getNthElement

문제
Integer 타입의 ArrayList와 수를 입력받아 수가 인덱스로 가리키는 ArrayList의 요소를 리턴해야 합니다.

입력
인자 1 : arrayList
Integer 타입의 arrayList
인자 2 : index
int 타입의 인덱스 (0 이상의 정수)

출력
Integer 타입을 리턴해야 합니다.

주의 사항
빈 ArrayList를 입력받은 경우, null을 리턴해야 합니다.
ArrayList의 크기를 벗어나는 인덱스를 입력받은 경우, null을 리턴해야 합니다.

입출력 예시
ArrayList<Integer> arrayList; // [0, 1, 2, 3, 4, 5]
Integer output = getNthElement(arryaList, 2);
System.out.println(output); // --> 2

힌트
생성된 ArrayList에 get() 메서드를 통해 특정 요소를 조회할 수 있습니다.
*/

public class Q_02_computeAverageOfNumbers {
    public static void main(String[] args) {
        Q_02_computeAverageOfNumbers coplit = new Q_02_computeAverageOfNumbers();
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)); // [0, 1, 2, 3, 4, 5]
        Integer output = coplit.getNthElement(arrayList, 2);
        System.out.println(output); // --> 2

    }

    public Integer getNthElement(ArrayList<Integer> arrayList, int index) {
        int size = arrayList.size();
        if (index <= 0 || index >= size) return null;
        Integer output = arrayList.get(index);
        return output;
    }
}