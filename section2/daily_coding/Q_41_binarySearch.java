package section2.daily_coding;

/*
# **binarySearch**

## **문제**

오름차순 정렬된 정수의 배열(`arr`)과 정수(`target`)를 입력받아 `target`의 인덱스를 리턴해야 합니다.

## **입력**

### **인자 1 : arr**

- `int` 타입을 요소로 갖는 배열
- `arr[i]`는 정수

### **인자 2 : target**

- `int` 타입의 정수

## **출력**

- `int` 타입을 리턴해야 합니다.

## **주의사항**

- **이진탐색 알고리즘**(`O(logN)`)을 사용해야 합니다.
- 단순한 배열 순회(`O(N)`)로는 통과할 수 없는 테스트 케이스가 존재합니다.
- `target`이 없는 경우, `-1`을 리턴해야 합니다.

## **입출력 예시**

```
int output = binarySearch(new int[]{0, 1, 2, 3, 4, 5, 6}, 2);
System.out.println(output); // --> 2

output = binarySearch(new int[]{4, 5, 6, 9}, 100);
System.out.println(output); // --> -1
```
 */

public class Q_41_binarySearch {
    public static void main(String[] args) {
        // write test case here
        Q_41_binarySearch coplit = new Q_41_binarySearch();

        int output = coplit.binarySearch(new int[]{0, 1, 2, 3, 4, 5, 6}, 2);
        System.out.println(output); // --> 2

        output = coplit.binarySearch(new int[]{4, 5, 6, 9}, 100);
        System.out.println(output); // --> -1

        output = coplit.binarySearch(new int[]{3, 6, 7, 8, 9, 21, 31, 32}, 31);
        System.out.println(output); // --> 6

    }


    public int binarySearch(int[] arr, int target) {
        int high = arr.length - 1;
        int low = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (target == arr[mid]) return mid;

            if (target < arr[mid]) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
}


