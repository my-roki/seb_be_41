package section2.daily_coding;

/*
# **isSubsetOf**

## **문제**

두 개의 배열(`base`, `sample`)을 입력받아 `sample`이 `base`의 부분집합인지 여부를 리턴해야 합니다.

## **입력**

### **인자 1 : base**

- `int` 타입을 요소로 갖는 임의의 배열
- `base.length`는 50,000 이하

### **인자 2 : sample**

- `int` 타입을 요소로 갖는 임의의 배열
- `sample.length`는 50,000 이하

## **출력**

- `boolean` 타입을 리턴해야 합니다.

## **주의사항**

- `base`, `sample` 내에 중복되는 요소는 없다고 가정합니다.

## **입출력 예시**

```java
int[] base = new int[]{1, 2, 3, 4, 5};
int[] sample = new int[]{1, 3};
boolean output = isSubsetOf(base, sample);
System.out.println(output); // --> true

sample = new int[]{6, 7};
output = isSubsetOf(base, sample);
System.out.println(output); // --> false

base = new int[]{10, 99, 123, 7};
sample = new int[]{11, 100, 99, 123};
output = isSubsetOf(base, sample);
System.out.println(output); // --> false
```
 */

import java.util.Arrays;

public class Q_24_isSubsetOf {
    public static void main(String[] args) {
        // write test case here
        Q_24_isSubsetOf coplit = new Q_24_isSubsetOf();

        int[] base = new int[]{1, 2, 3, 4, 5};
        int[] sample = new int[]{1, 3};
        boolean output = coplit.isSubsetOf(base, sample);
        System.out.println(output); // --> true

        sample = new int[]{6, 7};
        output = coplit.isSubsetOf(base, sample);
        System.out.println(output); // --> false

        base = new int[]{10, 99, 123, 7};
        sample = new int[]{11, 100, 99, 123};
        output = coplit.isSubsetOf(base, sample);
        System.out.println(output); // --> false

    }

    public boolean isSubsetOf(int[] base, int[] sample) {
        for (int number : sample) {
            if (Arrays.stream(base).noneMatch(n -> n == number)) return false;
        }
        return true;
    }
}

