package section2.daily_coding;

/*
# **bubbleSort**

## **문제**

정수를 요소로 갖는 배열을 입력받아 오름차순으로 정렬하여 리턴해야 합니다.
버블 정렬(bubble sort)은 여러 정렬 알고리즘(삽입 정렬, 퀵 정렬, 병합 정렬, 기수 정렬 등) 중 가장 기본적인 알고리즘입니다.

버블 정렬 알고리즘은 아래와 같습니다.

1. 첫 번째 요소가 두 번째 요소보다 크면, 두 요소의 위치를 바꿉니다. (swap)
2. 두 번째 요소와 세 번째 요소보다 크면, 두 요소의 위치를 바꿉니다. (swap)
3. 1, 2를 마지막까지 반복합니다. (마지막에서 두 번째 요소와 마지막 요소를 비교)
4. 1~3의 과정을 한 번 거치게 되면, 가장 큰 요소가 배열의 마지막으로 밀려납니다.
5. 1~3의 과정을 첫 요소부터 다시 반복합니다.
6. 5를 통해 두 번째로 큰 요소가 배열의 마지막 바로 두 번째로 밀려납니다.
7. 1~3의 과정을 총 n번(배열의 크기) 반복합니다.

이 모습이 마치 '거품이 밀려 올라가는 것과 같은 모습'과 같아서 bubble sort라고 부릅니다.

## **입력**

### **인자 1 : arr**

- `int` 타입을 요소로 갖는 배열
- `arr[i]`는 정수
- `arr[i]`의 길이는 1,000 이하

## **출력**

- `int` 타입을 요소로 갖는 배열을 리턴해야 합니다.
- 배열의 요소는 오름차순으로 정렬되어야 합니다.
- `arr[i] <= arr[j]` (`i < j`)

## **주의사항**

- 위에서 설명한 알고리즘을 구현해야 합니다.
- `arr.sort` 사용은 금지됩니다.
- 입력으로 주어진 배열은 중첩되지 않은 1차원 배열입니다.

## **입출력 예시**

```
int[] output = bubbleSort(new int[]{2, 1, 3});
console.log(output); // --> [1, 2, 3]
```

## **Advanced**

- 아래의 힌트를 바탕으로 (최선의 경우) 수행 시간을 단축할 수 있도록 코드를 수정해보세요.
- 위에서 설명된 알고리즘 1~3의 과정 중 어떤 요소도 위치가 바뀌지 않은 경우, 배열이 정렬된 상태라는 것을 알 수 있습니다.
 */

import java.util.Arrays;

public class Q_22_bubbleSort {
    public static void main(String[] args) {
        // write test case here
        Q_22_bubbleSort coplit = new Q_22_bubbleSort();

        int[] output = coplit.bubbleSort(new int[]{3, 2, 1});
        System.out.println(Arrays.toString(output)); // --> [1, 2, 3]
    }

    public int[] bubbleSort(int[] arr) {
        if (arr.length == 0) return new int[]{};
        int[] output = Arrays.copyOf(arr, arr.length);  // 깊은 복사.

        // 마지막 요소를 제외하고 모든 요소를 비교하기 위해 전체-1 순회.
        for (int i = 0; i < output.length - 1; i++) {
            int cnt = 0;  // 순서가 변경이 될때마다 count 합니다.
            for (int j = 0; j < output.length - 1; j++) {
                int left = output[j];
                int right = output[j + 1];
                if (left > right) {
                    output[j] = right;
                    output[j + 1] = left;
                    cnt++;
                }
            }
            // 순서의 변경이 한번도 없다는 뜻은 이미 정렬이 완성된 상태임을 뜻하므로 return.
            if (cnt == 0) return output;
        }
        return output;
    }
}




