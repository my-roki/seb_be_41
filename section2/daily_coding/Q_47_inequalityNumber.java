package section2.daily_coding;

/*
### **inequalityNumber**

## **문제**

아래와 같은 과정을 거쳐 부등호 수(inequalityNumber)를 만들 수 있습니다.

- 최대 9개의 부등호(`<`, `>`)가 주어집니다.
- 부등호의 좌우에는 0부터 9사이의 숫자가 한 번씩만 들어가야 합니다.
- 부등호를 만족하는 숫자의 조합을 차례대로 이어 붙여 만든 정수를 부등호 수라고 한다.

부등호 기호들을 입력받아 부등호를 만족하는 최대 부등호 수와 최소 부등호 수의 차이를 리턴해야 합니다.

## **입력**

### **인자 1 : signs**

- `String` 타입의 공백을 사이에 둔 부등호 기호들
- `signs.length()`는 17 이하 (최대 9개의 부등호 기호)

## **출력**

- `long` 타입을 리턴해야 합니다.

## **주의사항**

- 첫 자리가 0인 경우도 부등호 수에 포함되어야 합니다.
- 모든 입력에 답은 항상 존재합니다.

## **입출력 예시**

```
long output = inequalityNumber("<");
System.out.println(output); // --> 88 (89 - 01)

output = inequalityNumber("<,>");
System.out.println(output); // --> 876 (897 - 021)

output = inequalityNumber(">,<,>");
System.out.println(output); // --> 8,754 (9,786 - 1,032)
```
 */

import java.util.Arrays;

public class Q_47_inequalityNumber {
    public static void main(String[] args) {
        // write test case here
        Q_47_inequalityNumber coplit = new Q_47_inequalityNumber();

        long output = coplit.inequalityNumber("<");
        System.out.println(output); // --> 88 (89 - 01)

        output = coplit.inequalityNumber("<,>");
        System.out.println(output); // --> 876 (897 - 021)

        output = coplit.inequalityNumber(">,<,>");
        System.out.println(output); // --> 8,754 (9,786 - 1,032)

    }

    public long inequalityNumber(String signs) {
        // DFS로 문제를 해결합니다.
        // 재귀함수를 이용해 조건이 만족되는 숫자가 나올때까지 연산

        // 부등호 기호에 따라 연산을 하기 떄문에 각각의 부등호를 배열로 만듭니다.
        String[] signLists = signs.split(",");

        // max inequality number
        // visited는 0 ~ 9까지 숫자가 쓰였는지 확인하는 배열(visited[9] -> 9번 숫자가 사용 됐느냐 안 됐느냐)
        int[] numbers = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        boolean[] visited = new boolean[10];
        long max = recursion(signLists, -1, numbers, visited, "");

        // min inequality number
        numbers = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        visited = new boolean[10];
        long min = recursion(signLists, -1, numbers, visited, "");

        return max - min;
    }

    public long recursion(String[] signs, int idx, int[] numbers, boolean[] visited, String result) {
        // 탈출조건 : 모든 부등호 기호를 가지고 비교를 완료한 경우(비교에 맞는 숫자들의 조합이 나온 경우)
        if (idx == signs.length) {
            return Long.parseLong(result);
        }

        // 모든 숫자에 대해 비교를 합니다.
        for (int right : numbers) {
            if (visited[right]) continue;  // 현재 이미 사용중입니다.

            // 이전 숫자와 부등호 비교를 통해 조건에 만족하지 않는 경우는 continue.
            if (idx >= 0) {
                String sign = signs[idx];
                int left = Character.getNumericValue(result.charAt(result.length() - 1));

                if (sign.equals(">") && left <= right) continue;
                if (sign.equals("<") && left >= right) continue;
            }

            // 모든 조건을 만족한 경우 또는 제일 처음에 오는 숫자인 경우(idx < 0)
            visited[right] = true;
            String newResult = result + right;
            long target = recursion(signs, idx + 1, numbers, visited, newResult);

            // 부등호 비교 후 만족하는 값이 도출됐으면 다음 부등호 연산을 위해 메서드 종료.
            if (target != -1) return target;

            // 현재 모든 안 쓰인 나머지 숫자가 왼쪽과 비교했을 때 조건이 맞지 않는 경우 이전 번호부터 다시 시작.
            visited[right] = false;
        }
        return -1;
    }
}