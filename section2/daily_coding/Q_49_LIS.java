package section2.daily_coding;

/*
# **LIS**

## **문제**

정수를 요소로 갖는 문자열을 입력받아 다음의 조건을 만족하는 LIS*의 길이를 리턴해야 합니다.

- `LIS`: 배열의 연속되지 않는 부분 배열 중 모든 요소가 **엄격하게 오름차순**으로 정렬된 가장 긴 부분 배열(Longest Increasing Subsequence)
- 배열 `[1, 2, 3]`의 subseqeunce는 `[1]`, `[2]`, `[3]`, `[1, 2]`, `[1, 3]`, `[2, 3]`, `[1, 2, 3]` 입니다.
- `엄격한 오름차순`: 배열이 동일한 값을 가진 요소없이 오름차순으로 정렬되어 있는 경우를 말합니다.

## **입력**

### **인자 1 : arr**

- `int` 타입을 요소로 갖는 배열
- `arr.length`는 60,000 이하
- `arr[i]`는 100,000 이하의 양의 정수

## **출력**

- `int` 타입을 리턴해야 합니다.

## **주의사항**

- LIS의 **길이**를 리턴해야 합니다.
- LIS가 존재하지 않는 경우는 없습니다.

## **입출력 예시**

```
int output = LIS(new int[]{3, 2});
System.out.println(output); // --> 1 (3 or 2)

output = LIS(new int[]{3, 10, 2, 1, 20});
System.out.println(output); // --> 3 (3, 10, 20)
```

## **Advanced**

- LIS를 계산하는 효율적인 알고리즘(`O(N^2)`)이 존재합니다. 쉽지 않기 때문에 바로 레퍼런스 코드를 보고 이해하는 데 집중하시기 바랍니다.
- subsequence는 문자열 또는 배열같이 순서가 있는 데이터에서 순서의 대소 관계가 유지되는 모든 부분 문자열 또는 부분 배열을 의미합니다. sequence가 순서 또는 서열을 의미하기 때문에 subsequence는 부분 서열이라고 부르기도 합니다. 반면 substring 또는 subarray는 연속된 형태의 부분 문자열 또는 부분 배열을 의미합니다. 문자열 `"abcd"`의 subsequence와 substring은 각각 아래와 같습니다.
    - substring: `"a"`, `"b"`, `"c"`, `"d"`, `"ab"`, `"bc"`, `"cd"`, `"abc"`, `"bcd"`, `"abcd"`
    - subsequence: `"a"`, `"b"`, `"c"`, `"d"`, `"ab"`, `"ac"`, `"ad"`, `"bc"`, `"bd"`, `"cd"`, `"abc"`, `"abd"`, `"acd"`, `"bcd"`, `"abcd"`
    - LIS의 길이 대신 LIS 자체를 리턴하는 함수를 구현해 보시기 바랍니다.
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q_49_LIS {
    public static void main(String[] args) {
        // write test case here
        Q_49_LIS coplit = new Q_49_LIS();

        int output = coplit.LIS(new int[]{3, 2});
        System.out.println(output); // --> 1 (3 or 2)

        output = coplit.LIS(new int[]{3, 10, 2, 1, 20});
        System.out.println(output); // --> 3 (3, 10, 20)

    }

    public int LIS(int[] arr) {
        /*
        완전탐색 또는 동적 계획법 또는 이진탐색으로 풀이 가능
        https://shoark7.github.io/programming/algorithm/3-LIS-algorithms

        LIS의 특징
        > 1. 정수 i, j에 대해 i < j이면, S[i] < S[j]다.
        > 2. 정수 i, j에 대해 S[i] < S[j]이면, 배열 arr에서의 S[i], S[j] 두 수의 위치 전후관계는(S[i]가 S[j]보다 앞에 있음) 같다.

        따라서 완전탐색을 통해 현재 배열의 요소를 기준, 그 뒤에 있는 더 큰 요소값들을 추려 LIS 명제를 만족하는 배열의 최대 길이를 구하면 됩니다.
        ex) arr = [3, 10, 2, 1, 20] 이라는 배열이 있으면
        -> 3(arr[0])을 첫 수로 만들 수 있는 LIS => [3, 10, 20]
        -> 10(arr[1])을 첫 수로 만들 수 있는 LIS => [10, 20]
        ...
        이런 식으로 완전 탐색을 통해 최대 길이를 구합니다.
         */

        // 완전탐색 풀이
        if (arr.length == 0) return 0;

        int output = 1;
        for (int i = 0; i < arr.length; i++) {
            List<Integer> nxt = new ArrayList<>();
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    nxt.add(arr[j]);
                }
            }
            output = Math.max(output, 1 + LIS(nxt.stream().mapToInt(n -> n).toArray()));
        }
        return output;
    }
}