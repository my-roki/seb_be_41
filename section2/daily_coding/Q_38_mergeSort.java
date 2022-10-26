package section2.daily_coding;

/*
# **mergeSort**

## **문제**

정수를 요소로 갖는 배열을 입력받아 오름차순으로 정렬하여 리턴해야 합니다.

## **입력**

### **인자 1 : arr**

- `int` 타입을 요소로 갖는 배열
- `arr[i]`는 정수
- `arr.length` 100,000 이하

## **출력**

- `int` 타입을 요소로 갖는 배열을 리턴해야 합니다.
- 배열의 요소는 오름차순으로 정렬되어야 합니다.
- `arr[i] <= arr[j]` (`i < j`)

## **주의사항**

- **병합 정렬**을 구현해야 합니다.
- `Arrays.sort` 사용은 금지됩니다.
- 입력으로 주어진 배열은 중첩되지 않은 1차원 배열입니다.

## **입출력 예시**

```
int[] output = mergeSort(new int[]{3, 1, 21});
System.out.println(output); // --> [1, 3, 21]
```

## **힌트**

- 병합 정렬은 표준 라이브러리에서 정렬을 구현할 때 퀵 정렬이나 힙 정렬의 대안으로 사용하는 최적화된 정렬 알고리즘입니다. 병합 정렬은 다음과 같은 알고리즘을 사용합니다.
    1. N의 길이를 가진 배열 리스트를 1의 길이를 가진 "부분 리스트"가 N개 모인 것으로 취급합니다.
    2. 인접한 부분 리스트들을 정렬하여 2의 길이를 가진 부분 리스트로 병합합니다.
    3. 2의 길이를 가진 인접한 부분 리스트들을 4의 길이를 가진 부분 리스트로 합칩니다.
    4. 하나의 정렬된 리스트가 될 때까지 위 과정을 반복합니다.
    5. N이 홀수라면, 첫 번째 병합 때 1의 길이를 가진 부분 리스트를 남깁니다.
- 병합 정렬은 두 가지 방식으로 구현 가능합니다. 재귀적 접근(위->아래) 그리고 반복적 접근(아래->위)

반복적 접근

```
1. 주어진 배열이 "정렬된" 부분 리스트로 나뉘어집니다.
[4,7,4,3,9,1,2] -> [[4],[7],[4],[3],[9],[1],[2]]

2. 인접한 부분 리스트 2개가 정렬된 부분 리스트로 병합됩니다.
[[4],[7],[4],[3],[9],[1],[2]] -> [[4,7],[3,4],[1,9],[2]]

2. 병합 과정 (반복) :
[[4,7],[3,4],[1,9],[2]] -> [[3,4,4,7], [1,2,9]]

2. 병합 과정 (반복) :
[[3,4,4,7], [1,2,9]] -> [[1,2,3,4,4,7,9]]

3. 마무리 : 정렬된 배열이 리턴됩니다.
[1,2,3,4,4,7,9]
```

재귀적 접근

```
1. 주어진 배열을 절반으로 나눕니다.
  [4, 7, 4, 3, 9, 1, 2] -> [4, 7, 4], [3, 9, 1, 2]

2. 두 배열이 재귀적으로 정렬됩니다.
  [4, 7, 4] -> [4, 4, 7]
  [3, 9, 1, 2] -> [1, 2, 3, 9]

3. 두 배열이 병합됩니다.
  [4, 7, 4], [3, 9, 1, 2] -> [1, 2, 3, 4, 4, 7, 9]
```

2단계에서 나뉘어진 각각의 배열 [4, 7, 4] [3, 9, 1, 2]에 대해서도 1-3번의 과정이 재귀적으로 똑같이 진행됩니다.

```
1. 주어진 배열을 절반으로 나눕니다.
  [4, 7, 4] -> [4], [7, 4]

2. 두 배열이 재귀적으로 정렬됩니다.
  [4] -> [4]
  [7, 4] -> [4, 7]

3. 두 배열이 병합됩니다.
  [4], [4, 7] -> [4, 4, 7]
```

이 과정의 2단계에서 나뉘어진 [4, 7]에 대해서도 재귀가 호출됩니다.
[4]는 원소가 하나이기 때문에 정렬하지 않아도 되겠죠?

```
1. 주어진 배열을 절반으로 나눕니다.
  [7, 4] -> [7], [4]

2. 두 배열이 재귀적으로 정렬됩니다.
  [7] -> [7]
  [4] -> [4]

3. 두 배열이 병합됩니다.
  [7], [4] -> [4, 7]
```

모든 재귀 호출이 완료되면 3단계에서 병합이 되기 때문에 최종적으로 정렬된 하나의 배열이 리턴됩니다.
 */

import java.util.Arrays;

public class Q_38_mergeSort {
    public static void main(String[] args) {
        // write test case here
        Q_38_mergeSort coplit = new Q_38_mergeSort();
        int[] output1 = coplit.mergeSort(new int[]{3, 1, 21});
        System.out.println(Arrays.toString(output1)); // --> [1, 3, 21]

        int[] output2 = coplit.mergeSort(new int[]{3, 1, 8, 6, 9, 2, 5, 10, 7, 4});
        System.out.println(Arrays.toString(output2)); // --> [1, 3, 21]

    }

    public int[] mergeSort(int[] arr) {
        // 원본 보존을 위한 깊은 복사
        int[] output = Arrays.copyOf(arr, arr.length);

        sort(output, 0, output.length - 1);
        return output;
    }


    public void sort(int[] array, int left, int right) {
        // 더이상 쪼갤 수 없을때까지 분할
        if (left >= right) return;
        int mid = (left + right) / 2;

        sort(array, left, mid);
        sort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    public void merge(int[] array, int left, int mid, int right) {
        // mid 값을 기준으로 좌/우 배열을 가져옵니다.
        int[] leftArray = Arrays.copyOfRange(array, left, mid + 1);
        int[] rightArray = Arrays.copyOfRange(array, mid + 1, right + 1);

        int i = 0;
        int j = 0;
        int currIdx = left;

        int leftArrayLength = leftArray.length;
        int rightArrayLength = rightArray.length;

        // 좌우 배열 원소들을 비교하여 작은값부터 기존 array 의 왼쪽부터 채워넣습니다.
        // 배열에 요소를 추가하는 것이 아닌 값을 바꾸는 이유?
        // 자바 배열은 길이가 고정되어있기 때문에 요소를 추가하려면 계속 (기존 길이 + 1)의 배열을 새로 생성해주어야함 -> 메모리 낭비
        while (i < leftArrayLength && j < rightArrayLength) {
            if (leftArray[i] <= rightArray[j]) array[currIdx] = leftArray[i++];
            else array[currIdx] = rightArray[j++];

            currIdx++;
        }

        // 좌우 비교 후 남은 좌/우 배열 안의 값들은 순차적으로 기존 array 배열에 집어넣습니다.
        // 이미 분할 과정에서 오름차순 정렬이 되어있기 때문에 그냥 값을 순차적으로 넣어도 무관
        while (i < leftArrayLength) array[currIdx++] = leftArray[i++];
        while (j < rightArrayLength) array[currIdx++] = rightArray[j++];
    }
}