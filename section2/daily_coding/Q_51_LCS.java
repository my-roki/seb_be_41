package section2.daily_coding;

/*
# **LCS**

## **문제**

두 문자열을 입력받아 다음의 조건을 만족하는 LCS*의 길이를 리턴해야 합니다.

- `LCS`: 두 문자열에 공통으로 존재하는 **연속되지 않는** 부분 문자열(Longest Common Subsequence)
- 문자열 `"abc"`의 subseqeunce는 `"a"`, `"b"`, `"c"`, `"ab"`, `"ac"`, `"bc"`, `"abc"` 입니다.

## **입력**

### **인자 1 : str1**

- `String` 타입의 알파벳 소문자와 숫자로 이루어진 문자열
- `str1.length`는 50 이하

### **인자 2 : str2**

- `String` 타입의 알파벳 소문자와 숫자로 이루어진 문자열
- `str2.length`는 50 이하

## **출력**

- `int` 타입을 리턴해야 합니다.

## **주의사항**

- LCS의 **길이**를 리턴해야 합니다.
- LCS가 존재하지 않는 경우, 0을 리턴해야 합니다.

## **입출력 예시**

```
int output = LCS("abcd", "aceb");
System.out.println(output); // --> 2 ("ab" or "ac")

output = LCS("acaykp", "capcak");
System.out.println(output); // --> 4 ("acak")
```

## **Advanced**

- LCS를 계산하는 효율적인 알고리즘(`O(M * N)`)이 존재합니다(두 문자열의 길이가 각각 M, N일 경우). 쉽지 않기 때문에 바로 레퍼런스 코드를 보고 이해하는 데 집중하시기 바랍니다.
- LCS의 길이 대신 LCS 자체를 리턴하는 함수를 구현해 보시기 바랍니다.
- LIS와 LCS를 변형하여 두 문자열 또는 배열을 입력받아 LCIS(Longest Common Increasing Subsequence)의 길이 또는 그 자체를 리턴하는 함수를 구현해 보시기 바랍니다.
 */

import java.util.Arrays;

public class Q_51_LCS {
    public static void main(String[] args) {
        // write test case here
        Q_51_LCS coplit = new Q_51_LCS();

        int output = coplit.LCS("abcd", "aceb");
        System.out.println(output); // --> 2 ("ab" or "ac")

        output = coplit.LCS("acaykp", "capcak");
        System.out.println(output); // --> 4 ("acak")

    }

    public int LCS(String str1, String str2) {
        // dynamic programming: O(M * N)
        // memoization을 활용해 중복 계산되는 문제를 제거한다.
        // LCS('ABCD', 'ACEB')의 경우 재귀 호출을 적어보면 아래와 같다.
        // => 1) LCS('BCD', 'CEB')
        //  => 1-1) LCS('CD', 'CEB'), 1-2) LCS('BCD', 'EB')
        //    => 1-1-1) LCS('D', 'CEB'), 1-1-2) LCS('CD', 'EB')
        //    => 1-2-1) LCS('CD', 'EB'), 1-2-2) LCS('BCD', 'B')
        // 더 볼 필요 없이 1-1-2)와 1-2-1)은 같은 문제임을 알 수 있다.
        int M = str1.length();
        int N = str2.length();
        // 중복 계산을 방지하기 위해 left, right
        int[][] memo = new int[M + 1][N + 1];
        for(int[] data : memo) Arrays.fill(data, -1);

        return compareOneByOne(0, 0, 0, memo, str1, str2);

    }
    public int compareOneByOne(int left, int right, int len, int[][] memo, String str1, String str2) {
        if (memo[left][right] != -1) return memo[left][right];

        if (left == str1.length() || right == str2.length()) return 0;

        if (str1.charAt(left) == str2.charAt(right)) {
            memo[left][right] = 1 + compareOneByOne(left + 1, right + 1, len + 1, memo, str1, str2);
            return memo[left][right];
        }

        memo[left][right] = Math.max(
                compareOneByOne(left + 1, right, len, memo, str1, str2),
                compareOneByOne(left, right + 1, len, memo, str1, str2)
        );
        return memo[left][right];
    }

}