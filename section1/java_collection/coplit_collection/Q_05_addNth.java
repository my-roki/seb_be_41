package section1.java_collection.coplit_collection;

/* 
addNth

문제
Integer 타입을 요소로 가지는 ArrayList와 추가할 위치의 인덱스, 정수를 입력받아 주어진 요소를 ArrayList의 인덱스에 추가하고 해당 ArrayList를 리턴해야 합니다.

입력
인자 1 : arrayList
Integer 타입을 요소로 가지는 ArrayList
인자 2 : index
요소를 추가할 위치의 인덱스 (0 이상의 정수)
인자 3 : element
임의의 정수

출력
기존 ArrayList에 주어진 요소가 추가된 형태의 ArrayList를 리턴해야 합니다.
[arrarList[0], arrarList[1], ..., arrayList[index]..., arrayList[n]]
arrayList[index]의 값은 element

주의 사항
반복문(for, while) 사용은 금지됩니다.
새로운 ArrayList를 선언 / 할당해서 리턴하지 않습니다.
기존 ArrayList에 주어진 요소가 추가된 상태(주소값 동일)로 리턴해야 합니다.
입력받은 인덱스가 ArrayList의 크기를 벗어난 경우엔 null을 리턴합니다.

입출력 예시
ArrayList<Integer> arrayList; // [0, 1, 2, 3]
ArrayList<Integer> output = addNth(arrayList, 1, 7);
System.out.println(output); // --> [0, 7, 1, 2, 3]
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Q_05_addNth {
    public static void main(String[] args) {
        Q_05_addNth coplit = new Q_05_addNth();
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(0, 1, 2, 3)); // [0, 1, 2, 3]
        ArrayList<Integer> output = coplit.addNth(arrayList, 1, 7);
        System.out.println(output); // --> [0, 7, 1, 2, 3]
    }

    public ArrayList<Integer> addNth(ArrayList<Integer> arrayList, int index, int element) {
        int size = arrayList.size();
        if (index < 0 || index > size) return null;
        arrayList.add(index, element);
        return arrayList;
    }
}