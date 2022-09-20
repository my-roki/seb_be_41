package section2.recursion.coplit_recursion;

/*
reverseArr
문제
배열을 입력받아 순서가 뒤집힌 배열을 리턴해야 합니다.

입력
인자 1 : arr
int타입의 요소를 갖는 배열

출력
순서가 뒤집힌 배열을 리턴해야 합니다.
[arr[n-1], arr[n-2], ... , arr[0]]
arr.length는 n

주의 사항
함수 reverseArr는 재귀함수의 형태로 작성합니다.
반복문(for, while) 사용은 금지됩니다.
입력받은 배열은 함수의 호출 뒤에도 처음 상태를 유지해야 합니다(immutability).
빈 배열은 빈 배열 그대로를 리턴해야 합니다.

입출력 예시
int[] output = reverseArr(new int[]{1, 2, 3});
System.out.println(Arrays.toString(output)); // --> [3, 2, 1]
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q_12_reverseArr {
    public static void main(String[] args) {
        // write test case here
        Q_12_reverseArr coplit = new Q_12_reverseArr();
        int[] output = coplit.reverseArr(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(output)); // --> [3, 2, 1]
    }

    public List<Integer> tempList = new ArrayList<>();  // 리스트 변수 생성

    public int[] reverseArr(int[] arr) {
        if (arr.length == 0) return arr;
        int last = arr[arr.length - 1];

        tempList.add(last);  // 메서드 외부에서 선언된 전역변수는 재귀함수로 메서드가 새로 호출돼도 값을 유지합니다.
        int[] newList = Arrays.copyOfRange(arr, 0, arr.length - 1);
        reverseArr(newList);

        int[] output = tempList.stream().mapToInt(n -> n).toArray();
        return output;


        /*
        //재귀 함수를 사용하여, 새로운 배열로 기존 입력된 arr 배열의 마지막 인덱스의 값부터 넣어줍니다.

        //base case : 문제를 더 이상 쪼갤 수 없는 경우
        if(arr.length == 0) { //입력된 배열이 빈 배열인 경우
            return new int[]{}; //빈 배열을 반환합니다.
        }

        //recursive Case : 그렇지 않은 경우
        //배열의 가장 마지막 요소만을 가지고 있는 head 배열을 선언, 할당합니다.
        int[] head = Arrays.copyOfRange(arr, arr.length - 1, arr.length);

        //남은 요소를 가지고 있는 tail 배열을 선언, 할당하고, 해당 배열의 요소가 모두 제거될 때까지 재귀함수를 호출합니다.
        int[] tail = reverseArr(Arrays.copyOfRange(arr, 0, arr.length - 1));

        //재귀함수가 모두 호출된 이후에, 할당된 head배열과 tail 배열을 합친 새로운 배열을 선언, 할당합니다.
        //새로운 배열을 선언합니다. 배열의 크기는 head.length와 tail.length를 합친 크기로 선언합니다.
        int[] dest = new int[head.length + tail.length];

        //System.arraycopy메서드를 사용하여, head, tail 두 배열의 요소를 모두 dest 배열에 복사합니다.
        System.arraycopy(head, 0, dest, 0, head.length);
        System.arraycopy(tail, 0, dest, head.length, tail.length);

        return dest;
        */
    }
}