package section2.daily_coding;

/*
# **rotatedArraySearch**

## **문제**

`부분적으로 오름차순 정렬`*된 정수의 배열(`rotated`)과 정수(`target`)를 입력받아 `target`의 인덱스를 리턴해야 합니다.

- `부분적으로 정렬된 배열`: 배열을 왼쪽 혹은 오른쪽으로 0칸 이상 순환 이동할 경우 완전히 정렬되는 배열
- 예시: `[4, 5, 6, 0, 1, 2, 3]`은 왼쪽으로 3칸 또는 오른쪽으로 4칸 순환 이동할 경우 완전히 정렬됩니다.

## **입력**

### **인자 1 : rotated**

- `int` 타입을 요소로 갖는 배열
- `rotated[i]`는 정수

### **인자 2 : target**

- `int` 타입의 정수

## **출력**

- `int` 타입을 리턴해야 합니다.

## **주의사항**

- `rotated`에 중복된 요소는 없습니다.
- `target`이 없는 경우, `-1`을 리턴해야 합니다.

## **입출력 예시**

```
int output = rotatedArraySearch(new int[]{4, 5, 6, 0, 1, 2, 3}, 2);
System.out.println(output) // --> 5

int output = rotatedArraySearch(new int[]{4, 5, 6, 0, 1, 2, 3}, 100);
System.out.println(output) // --> -1
```

## **Advanced**

- 단순히 처음부터 끝까지 찾아보는 방법(`O(N)`) 대신 다른 방법(`O(logN)`)을 탐구해 보세요.

## **힌트**

- 이진 탐색(binary search)을 약간 변형하여 해결합니다.
 */

public class Q_30_rotatedArraySearch {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        // write test case here
        Q_30_rotatedArraySearch coplit = new Q_30_rotatedArraySearch();

        int output = coplit.rotatedArraySearch(new int[]{4, 5, 6, 0, 1, 2, 3}, 2);
        System.out.println(output); // --> 5

        output = coplit.rotatedArraySearch(new int[]{6, 0, 1, 2, 3, 4, 5}, 6);
        System.out.println(output); // --> -1

        // process time
        System.out.println("=".repeat(20));
        System.out.printf("Process end : %dms%n", System.currentTimeMillis() - start);
        System.out.println("=".repeat(20));

    }

    public int rotatedArraySearch(int[] rotated, int target) {
        int left = 0;
        int right = rotated.length - 1;

        // 양쪽 끝으로부터 모든 구간을 탐색해도 나오지 않으면 while문 종료
        while (left <= right) {
            int middle = (right + left) / 2;
            if (rotated[middle] == target) return middle;


            // idx를 절반으로 나누면 idx 기준으로 좌,우 중 정렬된 배열이 나온다.

            // 왼쪽 전체가 정렬이 된 조건
            if (rotated[left] < rotated[middle]) {
                // target이 정렬된 왼쪽에 있는 경우 오른쪽 끝 범위를 middle까지 줄여 재탐색이 가능합니다.
                if (target < rotated[middle] && rotated[left] <= target) right = middle - 1;

                // 아닌 경우는 2가지
                // 1. 정렬되지 않은 구간 중 작은 수들 정렬 안에 있다.
                // 2. 정렬되지 않은 구간 중 큰 수들 정렬 안에 있다.
                // => 결과적으로 정렬된 구간에 없는 것이니 정렬된 왼쪽 구간을 제외하고 오른쪽 구간에서 다시 재탐색이 가능합니다.
                else left = middle + 1;

            // 오른쪽 전체가 정렬이 된 조건
            } else {
                // target이 정렬된 오른쪽에 있는 경우 왼쪽 끝 범위를 middle까지 줄여 재탐색이 가능합니다.
                if (target <= rotated[right] && rotated[middle] < target) left = middle + 1;

                // 아닌 경우는 2가지
                // 1. 정렬되지 않은 구간 중 작은 수들 정렬 안에 있다.
                // 2. 정렬되지 않은 구간 중 큰 수들 정렬 안에 있다.
                // => 결과적으로 정렬된 구간에 없는 것이니 정렬된 오른쪽 구간을 제외하고 왼쪽 구간에서 다시 재탐색이 가능합니다.
                else right = middle - 1;
            }
        }
        return -1;
    }
}