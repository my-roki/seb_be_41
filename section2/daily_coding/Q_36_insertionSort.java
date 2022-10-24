package section2.daily_coding;

/*
# **insertionSort**

## **문제**

정수를 요소로 갖는 배열을 입력받아 오름차순으로 정렬하여 리턴해야 합니다.

## **입력**

### **인자 1 : arr**

- `int` 타입을 요소로 갖는 배열
- `arr[i]`는 정수
- `arr.length`는 1,000 이하

## **출력**

- `int` 타입을 요소로 갖는 배열을 리턴해야 합니다.
- 배열의 요소는 오름차순으로 정렬되어야 합니다.
- `arr[i] <= arr[j]` (`i < j`)

## **주의사항**

- **삽입 정렬**을 구현해야 합니다.
- `Arrays.sort()` 사용은 금지됩니다.
- 입력으로 주어진 배열은 중첩되지 않은 1차원 배열입니다.

## **입출력 예시**

```
int[] output = insertionSort(new int[]{3, 1, 21});
System.out.println(output); // --> [1, 3, 21]
```
 */

import java.util.Arrays;

public class Q_36_insertionSort {
    public static void main(String[] args) {
        // write test case here
        Q_36_insertionSort coplit = new Q_36_insertionSort();

        int[] output = coplit.insertionSort(new int[]{3, 1, 9, 4, 7, 2, 6, 10, 5, 8});
        System.out.println(Arrays.toString(output)); // --> [1, 3, 21]

    }

    // Insertion Sort 는 2번째 원소부터 시작하여 그 앞(왼쪽)의 원소들과 비교하여 삽입할 위치를 지정한 후,
    // 원소를 뒤로 옮기고 지정된 자리에 자료를 삽입 하여 정렬하는 알고리즘입니다.
    public int[] insertionSort(int[] arr) {
        int[] output = Arrays.copyOf(arr, arr.length);

        // 2번째 요소부터 시작
        for (int i = 1; i < output.length; i++) {
            int value = output[i];
            while (i - 1 >= 0 && output[i - 1] > value) {
                output[i] = output[i - 1];
                i--;
            }
            output[i] = value;
        }

        return output;
    }
}