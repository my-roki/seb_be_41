package section2.daily_coding;

/*
# **uglyNumbers**

## **문제**

아래와 같이 정의된 ugly numbers 중 n번째 수를 리턴해야 합니다.

- ugly number는 2, 3, 5로만 나누어 떨어지는 수이다.
- 1은 1번째 ugly number 이다.
- 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, 16, ...

## **입력**

### **인자 1 : n**

- `int` 타입의 자연수 (`n` >= 1)

## **출력**

- `int` 타입을 리턴해야 합니다.

## **주의사항**

- ugly numbers를 배열에 저장했을 때, n번째 ugly number의 위치는 인덱스 n-1 입니다.

## **입출력 예시**

```
int result = uglyNumbers(1);
System.out.println(result); // --> 1

result = uglyNumbers(3);
System.out.println(result); // --> 3
```

## **Advanced**

단순히 처음부터 끝까지 모든 수에 대해서 나눗셈 연산을 하는 대신 다른 방법(`O(N)`)을 탐구해 보세요.

## **힌트**

나눗셈 연산을 매번 다시 할 필요가 없습니다. ugly number에 2, 3 또는 5를 곱한 수 역시 ugly number 입니다.
 */

import java.util.ArrayList;
import java.util.List;

public class Q_52_uglyNumbers {
    public static void main(String[] args) {
        // write test case here
        Q_52_uglyNumbers coplit = new Q_52_uglyNumbers();

        int result = coplit.uglyNumbers(1);
        System.out.println(result); // --> 1

        result = coplit.uglyNumbers(3);
        System.out.println(result); // --> 3
    }

    /*
    solution1) 모든 증가하는 수에 대하여 2,3,5로 나누어 떨어지는 uglyNumber를 각각 찾아 n번째 수 구하기 -> 시간 복잡도 문제로 실패
    solution2) n으로 나누어떨어지면, n의 배수 또한 n으로 나누어 떨어진다는 원리를 이용해 n번째수 찾기
    [1, 1 * 2, ..., 2 * 2, ..., 3 * 2, ..., 4 * 2, ..., n * 2, ...]
     */
    public int uglyNumbers(int n) {
        // ugly number를 담을 배열
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);

        // 각각의 idx를 통해 배수를 관리합니다.
        int idx2 = 0, idx3 = 0, idx5 = 0;
        while (numbers.size() < n) {
            int multiple2 = numbers.get(idx2) * 2;  // 2의 배수
            int multiple3 = numbers.get(idx3) * 3;  // 3의 배수
            int multiple5 = numbers.get(idx5) * 5;  // 5의 배수

            // 3개의 값중 가장 작은 값이 numbers의 다음 요소값으로 들어갑니다.
            int[] candidates = new int[]{multiple2, multiple3, multiple5};
            int min = Integer.MAX_VALUE;
            for (int i : candidates) min = Math.min(i, min);
            numbers.add(min);

            // ugly number로 채택된 n의 배수값은 idx값을 올려 다음 배수로 비교해야합니다.
            // 또한 ugly number중 중복된 값(2 * 3 == 3 * 2)이 있을 수 있으므로 중복된 값들도 idx를 올려 다음 배수로 비교합니다.
            if (min == multiple2) idx2++;
            if (min == multiple3) idx3++;
            if (min == multiple5) idx5++;
        }
        return numbers.get(n - 1);
    }
}