package section1.java_collection.coplit_collection;

/* 
removeFromNth

문제
String 타입을 요소로 가지는 ArrayList와 인덱스를 입력받아, ArrayList에 인덱스의 요소를 삭제한 후 해당 요소를 리턴해야 합니다.

입력
인자 1 : arrayList
String 타입을 요소로 가지는 ArrayList
인자 2 : index
요소를 삭제할 위치의 index (0 이상의 정수)

출력
ArrayList의 입력받은 인덱스의 요소를 삭제하고, 삭제된 해당 요소를 리턴해야 합니다.

주의 사항
기존 ArrayList에 주어진 인덱스의 요소가 삭제된 상태여야합니다.
입력받은 인덱스가 ArrayList의 크기를 벗어난 경우엔 null을 리턴합니다.

입출력 예시
ArrayList<String> arrayList; // [0, 1, 2, 3, 4, 5]
String output = removeFromNth(arrayList, 3);
System.out.println(output); // --> "3"
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Q_08_removeFromNth {
    public static void main(String[] args) {
        Q_08_removeFromNth coplit = new Q_08_removeFromNth();
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5")); // ["0", "1", "2", "3", "4", "5"]
        String output = coplit.removeFromNth(arrayList, 3);
        System.out.println(output); // --> "3"
    }

    public String removeFromNth(ArrayList<String> arrayList, int index) {
        int size = arrayList.size();
        if (index < 0 || size <= index) return null;
        String output = arrayList.remove(index);
        return  output;
    }
}