package section2.daily_coding;

/*
# **tiling**

## **문제**

세로 길이 2, 가로 길이 n인 2 x n 보드가 있습니다. 2 x 1 크기의 타일을 가지고 이 보드를 채우는 모든 경우의 수를 리턴해야 합니다.

## **입력**

### **인자 1 : n**

- `int` 타입의 1 이상의 자연수

## **출력**

- `int` 타입을 리턴해야 합니다.

## **주의사항**

- 타일을 가로, 세로 어느 방향으로 놓아도 상관없습니다. (입출력 예시 참고)

## **입출력 예시**

```
int output = tiling(2);
System.out.println(output); // --> 2

output = tiling(4);
System.out.println(output); // --> 5

// 2 x 4 보드에 타일을 놓는 방법은 5가지
// 각 타일을 a, b, c, d로 구분
//
// 2 | a b c d
// 1 | a b c d
// ------------
//
// 2 | a a c c
// 1 | b b d d
// ------------
//
// 2 | a b c c
// 1 | a b d d
// ------------
//
// 2 | a a c d
// 1 | b b c d
// ------------
//
// 2 | a b b d
// 1 | a c c d
// ------------
```
## **Advanced**

- 타일링 문제를 해결하는 효율적인 알고리즘(`O(N)`)이 존재합니다. 반드시 직접 문제를 해결하시면서 입력의 크기에 따라 어떻게 달라지는지 혹은 어떻게 반복되는지 관찰하시기 바랍니다.
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Q_29_tiling {
    public static void main(String[] args) {
        // write test case here
        Q_29_tiling coplit = new Q_29_tiling();

        int output = coplit.tiling(2);
        System.out.println(output); // --> 2

        output = coplit.tiling(4);
        System.out.println(output); // --> 5
    }

    public int tiling(int num) {
        // 2 x 0 => 0가지
        // 2 x 1 => 1가지
        // 2 x 2 => 2가지
        // 2 x 3 => 3가지
        // 2 x 4 => 5가지
        ArrayList<Integer> bucket = new ArrayList<>(Arrays.asList(0, 1, 2));
        return recursion(num, bucket);
    }

    public int recursion(int size, ArrayList<Integer> bucket) {
        // bucket의 사이즈가 원하는 값(size)보다 크다면 그것은 이미 이전의 값들이 모두 들어있다는 증거 -> 연산x
        if (bucket.size() > size) return bucket.get(size);

        // 새로운 마지막 연산을 bucket에 담는다
        bucket.add(recursion(size - 1, bucket) + recursion(size - 2, bucket));
        return bucket.get(size);
    }
}

