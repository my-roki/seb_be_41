package section2.daily_coding;

/*
# **quickSort**

## **문제**

정수를 요소로 갖는 배열을 입력받아 오름차순으로 정렬하여 리턴해야 합니다.

## **입력**

### **인자 1 : arr**

- `int` 타입을 요소로 갖는 배열
- `arr[i]`는 정수
- `arr.length`는 100,000 이하

## **출력**

- `int` 타입을 요소로 갖는 배열을 리턴해야 합니다.
- 배열의 요소는 오름차순으로 정렬되어야 합니다.
- `arr[i] <= arr[j]` (`i < j`)

## **주의사항**

- **퀵 정렬**을 구현해야 합니다.
- `arr.sort` 사용은 금지됩니다.
- 입력으로 주어진 배열은 중첩되지 않은 1차원 배열입니다.

## **입출력 예시**

```
int[] output = quickSort(new int[]{3, 1, 21});
System.out.println(output); // --> [1, 3, 21]
```
 */

import java.util.Arrays;

public class Q_35_quickSort {
    public static void main(String[] args) {
        // write test case here
        Q_35_quickSort coplit = new Q_35_quickSort();

        int[] output = coplit.quickSort(new int[]{3, 9, 1, 4, 2, 3, 5, 8, 6, 7, 10});
        System.out.println(Arrays.toString(output)); // --> [1, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10]
    }

    public int[] quickSort(int[] arr) {
        // 원본 보존을 위한 깊은 복사
        int[] output = Arrays.copyOf(arr, arr.length);

        int left = 0;
        int right = arr.length - 1;
        sort(output, left, right);
        return output;
    }

    private void sort(int[] arr, int left, int right) {
        // 탈출 조건 : 정렬하는 배열에 대해 왼쪽 끝과 오른쪽 끝이 교차 => 더이상 정렬할 배열의 길이가 0.
        if (left >= right) return;

        // 피벗 선택 방식 : 첫번째, 중간, 마지막, 랜덤 등.
        // (선택 방식에 따라 속도가 달라짐)
        // ex, 피벗 값이 최소나 최대값으로 지정되어 파티션이 나누어지지 않았을 때 모든 경우에 대해 분할 정복이 이루어집니다.
        // quick sort 피벗 문제를 해결하기 위해, 피벗을 선택할 때 중간 요소로 선택하는 경우 평균적으로 가장 빠르다고 합니다...?
        int mid = (left + right) / 2;
        int pivot = arr[mid];

        // 피벗을 기준으로 양 끝값을 시작으로 비교해서 피벗보다 작은 값은 왼쪽으로, 큰 값은 오른쪽으로 swap 합니다.
        int i = left;
        int j = right;
        while (i <= j) {
            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;
            // 이동이 아닌 좌우 요소값을 바꾸는 이유는 자바 배열 특성상 중간에 요소를 삽입하는 것은 더 많은 메모리와 시간을 잡아먹기 때문에 비효율적입니다.
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        // 분할된 왼쪽 부분과 오른쪽 부분에 대해 재귀적으로 정렬을 적용합니다.
        sort(arr, left, i - 1);
        sort(arr, i, right);
    }

    private void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}


