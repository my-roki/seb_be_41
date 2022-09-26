package section2.daily_coding;

/*
superIncreasing
문제
수를 요소로 갖는 배열을 입력받아 각 요소들이 그 이전의 요소들의 합보다 큰지 여부를 리턴해야 합니다.

입력
인자 1 : arr
int타입을 요소로 갖는 배열
arr[i]는 정수

출력
boolean 타입을 리턴해야 합니다.
arr[i]는 arr[0]부터 arr[i-1]까지의 합보다 커야 합니다.

입출력 예시
boolean output = superIncreasing(new int[]{1, 3, 6, 13, 54});
System.out.println(output); // --> true

output = superIncreasing(new int[]{1, 3, 5, 9});
System.out.println(output); // --> false
 */

public class Q_14_superIncreasing {
    public static void main(String[] args) {
        // write test case here
        Q_14_superIncreasing coplit = new Q_14_superIncreasing();
        boolean output = coplit.superIncreasing(new int[]{1, 3, 6, 13, 54});
        System.out.println(output); // --> true

        output = coplit.superIncreasing(new int[]{1, 3, 5, 9});
        System.out.println(output); // --> false
    }

    public boolean superIncreasing(int[] arr) {
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= sum) return false;
            else sum += arr[i];
        }
        return true;
    }

}
