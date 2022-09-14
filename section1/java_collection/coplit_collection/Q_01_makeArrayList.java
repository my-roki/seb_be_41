package section1.java_collection.coplit_collection;

import java.util.ArrayList;
/* 
makeArrayList

문제
ArrayList를 선언하고 1부터 5까지 담은 뒤 리턴해야 합니다.

출력
Integer 타입의 ArrayList를 출력해야 합니다.

주의 사항
ArrayList를 선언한 후 값을 담아 리턴해야 합니다.

입출력 예시
ArrayList<Integer> output = makeArrayList();
System.out.println(output); // --> [1, 2, 3, 4, 5]

힌트
메서드의 제목(makeArrayList)을 활용해 검색해 봅니다(java how make arrayList)
*/

public class Q_01_makeArrayList {
    public static void main(String[] args) {
        Q_01_makeArrayList coplit = new Q_01_makeArrayList();
        ArrayList<Integer> output = coplit.makeArrayList();
        System.out.println(output);

    }

    public ArrayList<Integer> makeArrayList() {
        ArrayList<Integer> output = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            output.add(i);
        }
        return output;
    }

}