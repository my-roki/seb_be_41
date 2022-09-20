package section2.recursion.coplit_recursion;

/*
and
문제
배열을 입력받아 모든 요소의 논리곱(and)을 리턴해야 합니다.

입력
인자 1 : arr
boolean 타입을 구성 요소로 갖는 배열

출력
boolean 타입을 리턴해야 합니다.
arr[0] && arr[1] && ... && arr[n-1]
arr.length는 n

주의 사항
함수 and는 재귀함수의 형태로 작성합니다.
반복문(for, while) 사용은 금지됩니다.
입력받은 배열은 함수의 호출 뒤에도 처음 상태를 유지해야 합니다(immutability).
빈 배열의 논리곱은 true 입니다.

입출력 예시
boolean output = and(new boolean[]{true, true, true});
System.out.println(output); // --> true

output = and(new boolean[]{true, true, false});
System.out.println(output); // --> false
 */


import java.util.Arrays;

public class Q_10_and {
    public static void main(String[] args) {
        // write test case here
        Q_10_and coplit = new Q_10_and();
        boolean output = coplit.and(new boolean[]{true, true, true});
        System.out.println(output); // --> true

        output = coplit.and(new boolean[]{true, true, false});
        System.out.println(output); // --> false

    }

    public boolean and(boolean[] arr) {
        if (arr.length == 0) return true;

        boolean first = arr[0];
        boolean[] newArr = Arrays.copyOfRange(arr, 1, arr.length);
        return first && and(newArr);
    }

}
