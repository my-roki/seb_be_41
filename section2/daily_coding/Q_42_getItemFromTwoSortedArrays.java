package section2.daily_coding;

/*
# **getItemFromTwoSortedArrays**

## **문제**

길이가 m, n이고 오름차순으로 정렬되어 있는 자연수 배열들을 입력받아 전체 요소 중 k번째 요소를 리턴해야 합니다.

## **입력**

### **인자 1 : arr1**

- `int`타입을 요소로 갖는 배열
- `arr1.length`는 m

### **인자 2 : arr2**

- `int`타입을 요소로 갖는 배열
- `arr2.length`는 n

### **인자 3 : k**

- `int` 타입의 0 이상의 정수

## **출력**

- `int` 타입을 리턴해야 합니다.

## **주의사항**

- 두 배열의 길이의 합은 1,000,000 이하입니다.
- 어떤 배열 `arr`의 k번째 요소는 `arr[k-1]`을 의미합니다.

## **입출력 예시**

```
int[] arr1 = new int[]{1, 4, 8, 10};
int[] arr2 = new int[]{2, 3, 5, 9};
int result = getItemFromTwoSortedArrays(arr1, arr2, 6);
System.out.println(result); // --> 8

arr1 = new int[]{1, 1, 2, 10};
arr2 = new int[]{3, 3};
result = getItemFromTwoSortedArrays(arr1, arr2, 4);
System.out.println(result); // --> 3
```

## **Advanced**

- 단순히 처음부터 끝까지 찾아보는 방법(`O(K)`) 대신 다른 방법(`O(logK)`)을 탐구해 보세요.

## **힌트**

- 이진 탐색(binary search)을 응용하여 해결합니다.
 */

public class Q_42_getItemFromTwoSortedArrays {
    public static void main(String[] args) {
        // write test case here
        Q_42_getItemFromTwoSortedArrays coplit = new Q_42_getItemFromTwoSortedArrays();
        int[] arr1 = new int[]{1, 4, 8, 10};
        int[] arr2 = new int[]{2, 3, 5, 9};
        int result = coplit.getItemFromTwoSortedArrays(arr1, arr2, 6);
        System.out.println(result); // --> 8

        arr1 = new int[]{1, 1, 2, 10};
        arr2 = new int[]{3, 3};
        result = coplit.getItemFromTwoSortedArrays(arr1, arr2, 4);
        System.out.println(result); // --> 3

        arr1 = new int[]{};
        arr2 = new int[]{1, 2, 3, 4};
        result = coplit.getItemFromTwoSortedArrays(arr1, arr2, 4);
        System.out.println(result); // --> 3
    }

    // TODO : 이진탐색으로 구현해봅시다.
    public int getItemFromTwoSortedArrays(int[] arr1, int[] arr2, int k) {
        int output = 0;
        int idx1 = 0;
        int idx2 = 0;
        while (k != 0) {
            // 한 쪽 배열의 길이가 종료되면 나머지 배열에서 남은 k 만큼의 추가한 인덱스의 요소를 가져옵니다.
            if (idx1 == arr1.length) return arr2[idx2 + k - 1];
            if (idx2 == arr2.length) return arr1[idx1 + k - 1];

            // 각 배열의 가장 앞의 요소들부터 비교를 해서 더 큰 값이 output 이 되고
            // 작은 값은 다음 요소로 넘어가 비교 대상이 됩니다.
            if (arr1[idx1] < arr2[idx2]) {
                output = arr1[idx1];
                idx1++;
            } else {
                output = arr2[idx2];
                idx2++;
            }
            k--;
        }
        return output;
    }
}