package section2.daily_coding;

/*
# **LSCS**

## **문제**

정수를 요소로 갖는 배열을 입력받아 다음의 조건을 만족하는 LSCS*를 리턴해야 합니다.

- `LSCS`: 주어진 배열의 연속된 부분 배열*의 합을 구한다고 할 때, 이 중 가장 큰 값(Largest Sum of Contiguous Subarray)
- `연속된 부분 배열들`: 배열 `[1,2,3]`의 연속 부분 배열은 `[1]`, `[1, 2]`, `[1, 2, 3]`, `[2]`, `[2, 3]`, `[3]` 입니다.

## **입력**

### **인자 1 : arr**

- `int` 타입을 요소로 갖는 배열
- `arr.length`는 60,000 이하
- `arr[i]`는 -100,000 이상 100,000 이하의 정수

## **출력**

- `int` 타입을 리턴해야 합니다.

## **주의사항**

- 배열의 모든 요소가 음수인 경우도 있습니다.

## **입출력 예시**

```
int output = LSCS(new int[]{1, 2, 3});
System.out.println(output); // --> 6

output = LSCS(new int[]{1, 2, 3, -4});
System.out.println(output); // --> 6 ([1, 2, 3])

output = LSCS(new int[]{1, 2, 3, -4, 5});
System.out.println(output); // --> 7 ([1, 2, 3, -4, 5])

output = LSCS(new int[]{10, -11, 11});
System.out.println(output); // --> 11 ([11])
```

## **Advanced**

- LSCS를 계산하는 효율적인 알고리즘(`O(N)`)이 존재합니다. 쉽지 않기 때문에 바로 레퍼런스 코드를 보고 이해하는 데 집중하시기 바랍니다.
 */

public class Q_44_LSCS {
    public static void main(String[] args) {
        // write test case here
        Q_44_LSCS coplit = new Q_44_LSCS();

        int output = coplit.LSCS(new int[]{1, 2, 3});
        System.out.println(output); // --> 6

        output = coplit.LSCS(new int[]{1, 2, 3, -4});
        System.out.println(output); // --> 6 ([1, 2, 3])

        output = coplit.LSCS(new int[]{1, 2, 3, -4, 5});
        System.out.println(output); // --> 7 ([1, 2, 3, -4, 5])

        output = coplit.LSCS(new int[]{10, -11, 11});
        System.out.println(output); // --> 11 ([11])
    }

    public int LSCS(int[] arr) {
        // 1. 현재까지 연속된 수들의 합이 음수가 된다면, 현재까지 더했던 부분 배열의 합을 버리고,
        //    이후의 값들로 이루어진 부분 배열이 더 큰 값을 가지게 됩니다.
        // 2. 1번을 만족하는 부분 배열의 합 중(1번 조건으로 부분 배열의 구간이 여러군데 나올 수 있기 때문)
        //    가장 큰 값이 전체 배열에서 가질 수 있는 부분 배열의 최대합이 됩니다.

        // initial: 첫 인덱스가 음수일 경우 정상적으로 비교가 되지 않아 처음 값을 설정해줍니다.
        int output = arr[0]; // 부분배열의 최대 합
        int candidate = arr[0]; //현재 연속된 부분배열들의 합

        // 두번째 인덱스부터 비교 시작
        for (int idx = 1; idx < arr.length; idx++) {
            candidate += arr[idx];

            if (candidate < arr[idx]) candidate = arr[idx];  // 1.
            if (output < candidate) output = candidate;  // 2.
        }
        return output;
    }
}