package section1.java_collection.coplit_collection;

/* 
modifyNthElement

문제
ArrayList와 요소, 수정할 위치의 인덱스를 입력받아 주어진 요소를 ArrayList의 인덱스의 값을 수정하고 해당 ArrayList를 리턴해야 합니다.

입력
인자 1 : arrayList
String 타입의 요소를 갖는 ArrayList
인자 2 : index
요소를 추가할 위치의 인덱스 (0 이상의 정수)
인자 3 : str
임의의 문자열

출력
기존 ArrayList에 주어진 요소가 변경된 형태의 ArrayList를 리턴해야 합니다.
[arrarList[0], arrarList[1], ..., arrayList[index]..., arrayList[n]]
arrayList[index]의 값은 str

주의 사항
반복문(for, while) 사용은 금지됩니다.
새로운 ArrayList를 선언 / 할당해서 리턴하지 않습니다.
기존 ArrayList에 주어진 요소가 수정된 상태(주소값 동일)로 리턴해야 합니다.
입력받은 인덱스가 ArrayList의 크기를 벗어난 경우엔 null을 리턴합니다.

입출력 예시
ArrayList<String> arrayList; // ["여러분", "화이팅", "입니다"]
ArrayList<String> output = modifyNthElement(arrayList, 0, "여러분들");
System.out.println(output); // --> ["여러분들", "화이팅", "입니다"]

힌트
메서드의 제목(modifyNthElement)을 활용해 검색해 봅니다(java how modify element of arrayList)
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Q_06_modifyNthElement {
    public static void main(String[] args) {
        Q_06_modifyNthElement coplit = new Q_06_modifyNthElement();
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("여러분", "화이팅", "입니다")); // ["여러분", "화이팅", "입니다"]
        ArrayList<String> output = coplit.modifyNthElement(arrayList, 0, "여러분들");
        System.out.println(output); // --> ["여러분들", "화이팅", "입니다"]
    }

    public ArrayList<String> modifyNthElement(ArrayList<String> arrayList, int index, String str) {
        int size = arrayList.size();
        if (index < 0 || size <= index) return null;
        arrayList.set(index, str);
        return arrayList;
    }
}