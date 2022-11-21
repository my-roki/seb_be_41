package section2.daily_coding;

/*
# **LPS**

## **문제**

문자열을 입력받아 다음의 조건을 만족하는 LPS*를 찾아 그 길이를 리턴해야 합니다.

- `LPS`: 주어진 문자열의 가장 긴 접두어이자 접미어(Longest Prefix which is also Suffix)
- non-overlapping: 접두어와 접미어는 서로 겹치는 부분이 없어야 합니다. 다시 말해, prefix와 suffix는 문자열의 동일한 인덱스에 위치한 문자를 요소로 가지면 안 됩니다.

## **입력**

### **인자 1 : str**

- `String` 타입의 임의의 알파벳 소문자 문자열
- `str.length`는 60,000 이하

## **출력**

- `int` 타입을 리턴해야 합니다.

## **주의사항**

- prefix(접두어)는 문자열의 첫 인덱스부터 시작하는 모든 부분 문자열을 의미합니다.
- suffix(접미어)는 문자열의 마지막 인덱스부터 시작하는 모든 부분 문자열을 의미합니다.

## **입출력 예시**

```
int output = LPS("abbbcc");
System.out.println(output); // --> 0

output = LPS("aaaa");
System.out.println(output); // --> 2
// prefix: str.substring(0, 2)
// suffix: str.substring(2)
// non-overlapping 조건이 없는 경우 정답은 4 입니다.

output = LPS("aaaaa");
System.out.println(output); // --> 2
// prefix: str.substring(0, 2)
// suffix: str.substring(3)
// non-overlapping 조건이 없는 경우 정답은 5 입니다.
```
 */

public class Q_50_LPS {
    public static void main(String[] args) {
        // write test case here
        Q_50_LPS coplit = new Q_50_LPS();

        int output = coplit.LPS("abcdefgh");
        System.out.println(output); // --> 0

        output = coplit.LPS("aaaa");
        System.out.println(output); // --> 2

        output = coplit.LPS("aabcdaabc");
        System.out.println(output); // --> 4
    }

    public int LPS(String str) {
        int output = 0;
        for (int i = 1; i <= str.length() / 2; i++) {
            String prefix = str.substring(0, i);
            String suffix = str.substring(str.length() - i);

            if (prefix.equals(suffix)) output = i;
        }
        return output;
    }
}