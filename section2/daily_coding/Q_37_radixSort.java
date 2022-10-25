package section2.daily_coding;

/*
# **radixSort**

## **문제**

정수를 요소로 갖는 배열을 입력받아 오름차순으로 정렬하여 리턴해야 합니다.

## **입력**

### **인자 1 : arr**

- `int` 타입을 요소로 갖는 배열
- `arr[i]`는 0 이상의 정수
- `arr.length` 100,000 이하

## **출력**

- `int` 타입을 요소로 갖는 배열을 리턴해야 합니다.
- 배열의 요소는 오름차순으로 정렬되어야 합니다.
- `arr[i] <= arr[j]` (`i < j`)

## **주의사항**

- **기수 정렬**을 구현해야 합니다.
- `Arrays.sort` 사용은 금지됩니다.
- 입력으로 주어진 배열은 중첩되지 않은 1차원 배열입니다.

## **입출력 예시**

```
int[] output = radixSort(new int[]{3, 1, 21});
System.out.println(output); // --> [1, 3, 21]
```

## **힌트**

- 기수 정렬(radix sort)은 내부적으로 계수 정렬(counting sort)을 사용합니다.
- 계수 정렬을 먼저 학습하고, 어떤 경우에 기수 정렬을 사용하는지 학습하도록 합니다.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q_37_radixSort {
    public static void main(String[] args) {
        // write test case here
        Q_37_radixSort coplit = new Q_37_radixSort();

        int[] output1 = coplit.radixSort(new int[]{123, 423, 953, 643, 747, 867, 908, 135, 634, 637});
        System.out.println(Arrays.toString(output1)); // [123, 135, 423, 634, 637, 643, 747, 867, 908, 953]

        int[] output2 = coplit.radixSort(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1});
        System.out.println(Arrays.toString(output2)); // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

    }

    public int[] radixSort(int[] arr) {
        // 원본 보존을 위한 깊은 복사
        int[] output = Arrays.copyOf(arr, arr.length);

        // 최대 자리수 구하기
        int max = 0;
        for (int value : output) {
            int length = (int) Math.ceil(Math.log10(value));
            if (length > max) max = length;
        }
        // System.out.println(max);

        // 각 자리수마다 올 수 있는 값은 0 ~ 9이기 때문에 각 숫자가 들어갈 Queue 배열을 생성
        // Queue 를 쓰는 이유? 입출력이 선입선출이기 때문에 동일한 숫자에서 선입선출 정렬(1a, 1b -> 1a, 1b 정렬 가능)이 가능합니다.
        ArrayList<Queue<Integer>> queues = new ArrayList<>();
        for (int i = 0; i < 10; i++) queues.add(new LinkedList<>());

        // 자릿수만큼 반복문을 돌아 숫자에 맞는 인덱스 큐에 삽입한다.
        for (int i = 0; i <= max; i++) {
            for (int j : output) {
                queues.get((int) (j / Math.pow(10, i) % 10)).add(j);
            }

            // 인덱스 큐에 들어간 요소들을 다시 배열 안에 작은 자릿수부터 채웁니다.
            int idx = 0;
            for (Queue<Integer> queue : queues) {
                if (queue.size() == 0) continue;
                int q_size = queue.size();
                for (int k = 0; k < q_size; k++) {
                    output[idx] = queue.poll();
                    idx++;
                }
            }
        }
        return output;
    }

}