package section2.daily_coding;

/*
# **longestPalindrome**

## **문제**

문자열을 입력받아 부분 문자열 중 가장 긴 palindrome의 길이를 리턴해야 합니다.

- `palindrome`: 데이터를 앞에서 뒤로 또는 뒤에서 앞으로 조회한 결과가 동일한 경우

## **입력**

### **인자 1 : str**

- `String` 타입의 공백이 있는 알파벳 소문자 문자열

## **출력**

- `int` 타입을 리턴해야 합니다.

## **주의사항**

- 문자열 `str`의 부분 문자열은 자기 자신을 포함합니다.
- 공백도 회문에 포함될 수 있습니다.

## **입출력 예시**

```
String str = "My dad is a racecar athlete";
int result = longestPalindrome(str);
System.out.println(result); // --> 11 ('a racecar a')

str = " dad ";
result = longestPalindrome(str);
System.out.println(result); // --> 5 (' dad ')
```

## **Advanced**

- 부분 문자열 중 가장 긴 회문을 계산하는 효율적인 알고리즘(`O(N^2)`)이 존재합니다. 쉽지 않기 때문에 바로 레퍼런스 코드를 보고 이해하는 데 집중하시기 바랍니다.
 */

public class Q_59_longestPalindrome {
    public static void main(String[] args) {
        // write test case here
        Q_59_longestPalindrome coplit = new Q_59_longestPalindrome();

        String str = "My dad is a racecar athlete";
        int result = coplit.longestPalindrome(str);
        System.out.println(result); // --> 11 ('a racecar a')

        str = " dad ";
        result = coplit.longestPalindrome(str);
        System.out.println(result); // --> 5 (' dad ')

    }

    public int longestPalindrome(String str) {
        /*
        완전탐색 -> 연속순열?
        모든 문자열에 대해 해당 문자열이 palindrome인지 확인해서 가장 긴 palindrome을 구합니다.
        TODO 해당 풀이는 3번의 반복문을 이용하기 때문에 시간복잡도가 O(N^3)입니다. O(N^2)의 알고리즘이 존재합니다.
         */

        if (str.length() < 2) return str.length();

        int output = 1;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                output = Math.max(output, isPalindrome(str, i, j + 1));
            }
        }
        return output;
    }

    private static int isPalindrome(String str, int start, int end) {
        int length = end - start;
        // 양 끝을 서로 비교하면서 점점 안쪽으로 들어오기 때문에 전체 길이의 절반만 반복
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(start + i) != str.charAt(end - 1 - i)) {
                return Integer.MIN_VALUE;  // 만약 해당 문자열이 palindrome가 아니면 비교가 안 되게 가장 작은 숫자를 리턴합니다.
            }
        }
        return length;
    }
}