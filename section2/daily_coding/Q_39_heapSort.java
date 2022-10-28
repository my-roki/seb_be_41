package section2.daily_coding;

/*
# **heapSort**

## **문제**

정수를 요소로 갖는 배열을 입력받아 오름차순으로 정렬하여 리턴해야 합니다.

## **입력**

### **인자 1 : arr**

- `int` 타입을 요소로 갖는 배열
- `arr[i]`는 -100,000 이상 100,000 이하의 정수
- `arr.length`는 100,000 이하

## **출력**

- `int` 타입을 요소로 갖는 배열을 리턴해야 합니다.

## **주의사항**

- **힙 정렬**을 구현해야 합니다.
- `Arrays.sort` 사용은 금지됩니다.
- 입력으로 주어진 배열은 중첩되지 않은 1차원 배열입니다.
- **최소 힙(min heap)**을 구현해야 합니다.
- Java에서는 쉽게 heap을 사용할 수 있습니다.
- `PriorityQueue<Integer> heap = new PriorityQueue<Integer>()`와 같은 방식으로 사용할 수 있습니다.

## **입출력 예시**

```
int[] output = heapSort(new int[]{5, 4, 3, 2, 1});
System.out.println(output); // --> [1, 2, 3, 4, 5]

output = heapSort(new int[]{3, 1, 21});
System.out.println(output); // --> [1, 3, 21]

output = heapSort(new int[]{4, 10, 3, 5, 1});
System.out.println(output); // --> [1, 3, 4, 5, 10]
```

## **힌트**

- 앞에서 말했듯이, 최소 힙은 최대 힙과 구현이 거의 일치합니다. 아래 링크를 다시 한번 참고하시기 바랍니다.
    - [https://www.cs.usfca.edu/~galles/visualization/Heap.html](https://www.cs.usfca.edu/~galles/visualization/Heap.html)
- 아래와 같은 최소 힙에서 루트 노드의 값(`2`)은 전체 노드의 값 중에서 가장 작습니다. 루트 노드를 제거한 후에도 최소 힙을 유지해야 하려면 어떤 작업이 필요한 지 고민하시기 바랍니다. `2`가 제거된 후의 최소 힙의 루트 노드는 `2`를 제외한 값 중 가장 작은 값(`3`)이 되어야 합니다. 아래와 같은 사실로부터 힙 정렬에 대한 아이디어를 얻길 바랍니다.
    - 루트 노드를 제거하고(가장 작은 값을 제거하고) 다시 최소 힙을 유지하면, 새로운 루트 노드의 값은 그 다음으로 가장 작은 값이다.

```
    2
   / \
  5   3
 / \ / \
6  8 7  9
```
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q_39_heapSort {
    public static void main(String[] args) {
        // write test case here
        Q_39_heapSort coplit = new Q_39_heapSort();

        int[] output = coplit.heapSort(new int[]{5, 4, 3, 2, 1});
        System.out.println(Arrays.toString(output)); // --> [1, 2, 3, 4, 5]

        output = coplit.heapSort(new int[]{3, 1, 21});
        System.out.println(Arrays.toString(output)); // --> [1, 3, 21]

        output = coplit.heapSort(new int[]{4, 10, 3, 5, 1});
        System.out.println(Arrays.toString(output)); // --> [1, 3, 4, 5, 10]

        output = coplit.heapSort(new int[]{5, 4, 3, 2, 1});
        System.out.println(Arrays.toString(output)); // --> [1, 2, 3, 4, 5]

        output = coplit.heapSort(new int[]{1, 2, 43, 100, 21});
        System.out.println(Arrays.toString(output)); // --> [1, 2, 21, 43, 100]

        output = coplit.heapSort(new int[]{20, -10, -11, 2, 29});
        System.out.println(Arrays.toString(output)); // --> [-11, -10, 2, 20, 29]

        // 1 ~ 100,000 까지 랜덤하게 섞인 배열
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 100001; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        int[] randList = list.stream().mapToInt(i -> i).toArray();

        System.out.printf("Not Sorted : %s%n", Arrays.toString(Arrays.copyOf(randList, 20)));
        output = coplit.heapSort(randList);
        System.out.printf("Heap Sort : %s%n", Arrays.toString(Arrays.copyOf(output, 20)));
    }

    public int[] heapSort(int[] arr) {
        // 원본 보존을 위한 깊은 복사
        int[] output = Arrays.copyOf(arr, arr.length);

        sort(output, output.length);

        // 최소힙으로 정렬한 배열은 내림차순 정렬로 됩니다. 따라서 배열을 뒤집어주어야 합니다.
        for (int i = 0; i < output.length / 2; i++) {
            swap(output, i, output.length - i - 1);
        }
        return output;
    }

    // Left child node = index * 2 + 1
    // Right child node = index * 2 + 2
    // Parent node = (index - 1) / 2
    public void sort(int[] array, int size) {
        // 0개, 1개 배열은 순서가 의미가 없습니다.
        if (size < 2) return;

        // 가장 마지막 노드의 부모 노드 인덱스
        int parentIdx = ((size - 1) - 1) / 2;

        // 일반 배열 -> 최소 힙 배열 만들기
        // 가장 마지막 부모요소부터 시작해서 상위 부모로 올라가면서 모든 서브트리에 대해 힙을 만족하게 만듭니다.
        for (int i = parentIdx; i >= 0; i--) {
            minHeapifyWhile(array, i, size - 1);
        }

        // 최소 힙을 구했으면 루트 인덱스에 최솟값이 있으니, 루트 인덱스와 마지막 인덱스 값을 교환해준 뒤
        // (새로운 배열을 만들어 할당하면 불필요한 메모리 소모가 예상됩니다)
        // 마지막 인덱스를 제외한 나머지 배열에서 새로 최소 힙을 만들어 바꾸는 과정을 반복합니다.
        for (int i = size - 1; i > 0; i--) {
            swap(array, 0, i);
            minHeapifyWhile(array, 0, i - 1);
        }
    }

    // 재귀 함수를 이용해서 최소 힙을 만드는 함수
    public void minHeapifyRecursion(int[] array, int parentIdx, int lastIdx) {
        int leftChildIdx = (parentIdx * 2) + 1;
        int rightChildIdx = (parentIdx * 2) + 2;
        int smallestIdx = parentIdx;  // 현재 트리에서 부모 인덱스가 가장 작은 값을 가지고 있다고 가정.

        // 자식 노드 인덱스가 마지막 인덱스를 넘어가지 않으면서, 현재 부모 인덱스보다 왼쪽/오른쪽 자식 노드의 값이 더 작을 경우
        // 부모 인덱스를 가리키는 smallestIdx 를 해당 자식 노드 인덱스로 바꿔줍니다.
        if (leftChildIdx <= lastIdx && array[smallestIdx] > array[leftChildIdx]) {
            smallestIdx = leftChildIdx;
        }

        if (rightChildIdx <= lastIdx && array[rightChildIdx] < array[smallestIdx]) {
            smallestIdx = rightChildIdx;
        }

        // smallestIdx 값이 부모 인덱스값에서 변경된거면 인덱스간 교환이 발생한 것이므로 인덱스 교환이 이루어진 자식 노드와 부모 노드의 값을 바꿔줍니다.
        // 그리고 교환된 자식 노드 인덱스 자리에서 그 인덱스를 새로운 부모 노드로 하는 서브트리의 최소 힙을 만드는 함수를 재귀 호출합니다.
        if (smallestIdx != parentIdx) {
            swap(array, parentIdx, smallestIdx);
            minHeapifyRecursion(array, smallestIdx, lastIdx);
        }
    }

    // while 문을 활용해서 최소 힙을 만드는 함수
    public void minHeapifyWhile(int[] array, int parentIdx, int lastIdx) {
        int leftChildIdx;
        int rightChildIdx;
        int smallestIdx;

        while ((parentIdx * 2) + 1 <= lastIdx) {
            leftChildIdx = (parentIdx * 2) + 1;
            rightChildIdx = (parentIdx * 2) + 2;
            smallestIdx = parentIdx;


            if (leftChildIdx <= lastIdx && array[leftChildIdx] < array[smallestIdx]) {
                smallestIdx = leftChildIdx;
            }

            if (rightChildIdx <= lastIdx && array[rightChildIdx] < array[smallestIdx]) {
                smallestIdx = rightChildIdx;
            }

            if (smallestIdx != parentIdx) {
                swap(array, parentIdx, smallestIdx);
                parentIdx = smallestIdx;
            } else {
                return;
            }
        }
    }

    // 두 인덱스의 원소를 교환하는 함수
    public void swap(int[] array, int idx1, int idx2) {
        int temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }

    // 재귀 함수를 이용해서 최대 힙을 만드는 함수
    public void maxHeapifyRecursion(int[] array, int parentIdx, int lastIdx) {
        int leftChildIdx = (parentIdx * 2) + 1;
        int rightChildIdx = (parentIdx * 2) + 2;
        int largestIdx = parentIdx;

        if (leftChildIdx <= lastIdx && array[largestIdx] < array[leftChildIdx]) {
            largestIdx = leftChildIdx;
        }

        if (rightChildIdx <= lastIdx && array[rightChildIdx] > array[largestIdx]) {
            largestIdx = rightChildIdx;
        }

        if (largestIdx != parentIdx) {
            swap(array, parentIdx, largestIdx);
            maxHeapifyRecursion(array, largestIdx, lastIdx);
        }
    }

    // 반복문을 활용해서 최대 힙을 만드는 함수
    public void maxHeapifyWhile(int[] array, int parentIdx, int lastIdx) {
        int leftChildIdx;
        int rightChildIdx;
        int largestIdx;

        while ((parentIdx * 2) + 1 <= lastIdx) {
            leftChildIdx = (parentIdx * 2) + 1;
            rightChildIdx = (parentIdx * 2) + 2;
            largestIdx = parentIdx;


            if (array[leftChildIdx] > array[largestIdx]) {
                largestIdx = leftChildIdx;
            }

            if (rightChildIdx <= lastIdx && array[rightChildIdx] > array[largestIdx]) {
                largestIdx = rightChildIdx;
            }

            if (largestIdx != parentIdx) {
                swap(array, parentIdx, largestIdx);
                parentIdx = largestIdx;
            } else {
                return;
            }
        }
    }
}