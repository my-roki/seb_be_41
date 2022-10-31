package section2.daily_coding;

/*
# **primePassword**

## **문제**

다음의 조건을 만족하면서 현재의 비밀번호('curPwd')를 새 비밀번호(`newPwd`)로 변경하는 데 필요한 최소 동작의 수를 리턴해야 합니다.

- 한 번에 한 개의 숫자만 변경가능하다.
- 4자리의 소수(prime)인 비밀번호로만 변경가능하다.

정리하면, 비밀번호가 계속 소수를 유지하도록 숫자 한 개씩을 바꿔갈 때 현재 비밀번호에서 새 비밀번호로 바꾸는 데 최소 몇 개의 숫자를 변경해야 하는지를 리턴해야 합니다.

## **입력**

### **인자 1 : curPwd**

- `int` 타입의 1,000 이상 9,999 이하의 자연수

### **인자 2 : newPwd**

- `int` 타입의 1,000 이상 9,999 이하의 자연수

## **출력**

- `int` 타입을 리턴해야 합니다.

## **주의사항**

- 4자리인 소수는 1,000 이상의 소수를 말합니다.(0011, 0997 등은 제외)
- 새 비밀번호를 만들 수 없는 경우 -1을 리턴합니다.

## **입출력 예시**

```
int output = primePassword(1033, 1033);
System.out.println(output); // --> 0

output = primePassword(3733, 8779);
System.out.println(output); // --> 3 (3733 -> 3739 -> 3779 -> 8779)
```
 */

import java.util.LinkedList;
import java.util.Queue;

class Q_40_primePassword {
    public static void main(String[] args) {
        // write test case here
        Q_40_primePassword coplit = new Q_40_primePassword();

        int output = coplit.primePassword(1033, 1033);
        System.out.println(output); // --> 0

        output = coplit.primePassword(3733, 8779);
        System.out.println(output); // --> 3 (3733 -> 3739 -> 3779 -> 8779)

        output = coplit.primePassword(1009, 1171);
        System.out.println(output); // --> 3 (3733 -> 3739 -> 3779 -> 8779)
    }

    public int primePassword(int curPwd, int newPwd) {
        /*
         * bfs를 통한 문제 풀이
         * 각 자릿수마다 1씩 증가시켜보고 그것이 새 비밀번호라면 횟수 리턴
         * 소수라면 횟수 +1, 다음 소수를 찾아 반복
         * 중복으로 같은 숫자를 확인하면 안 되므로 visited 배열 필요.
         * 공간 복잡도를 고려해 재귀보단 Queue를 이용해 풀 예정
         */

        if (curPwd == newPwd) return 0;

        Queue<int[]> queue = new LinkedList<>();  // bfs를 위해 Queue 선언
        boolean[] visited = new boolean[10000];  // 0000 ~ 9999 까지 방문 여부를 담는 배열

        visited[curPwd] = true;
        queue.add(new int[]{0, curPwd});  // 시작점

        int[] data;
        int cnt, password;
        while (queue.size() > 0) {
            data = queue.poll();
            cnt = data[0];
            password = data[1];

            // 자릿수 상관 없이 숫자의 증감을 편하게 하기위해 각 자릿수의 숫자로 하나의 배열을 만들어서 처리합니다.
            // 1234 -> [1, 2, 3, 4]  이렇게 하면 +1, +10, +100, +1000 나눠서 고려할 필요가 없어집니다.
            for (int i = 0; i < 4; i++) {
                String[] numberArr = Integer.toString(password).split("");

                //  각 자리수에 대하여 0 ~ 9 를 대입해보면서 만들어진 숫자에 대해 방문여부 체크, 소수 판별 체크
                for (int j = 0; j < 10; j++) {
                    if (j == 0 && i == 0) continue;  // 천의 자리가 0이 되는 것을 방지
                    if (j == Integer.parseInt(numberArr[i])) continue;  // 같은 숫자면 중복 검사이기 ㅈ때문에 수행하지 않습니다.

                    numberArr[i] = Integer.toString(j);
                    int targetNumber = Integer.parseInt(String.join("", numberArr));  // 새로운 숫자

                    if (targetNumber == newPwd) return cnt + 1;
                    if (!visited[targetNumber] && isPrime(targetNumber)) {
                        visited[targetNumber] = true;
                        queue.add(new int[]{cnt + 1, targetNumber});
                    }
                }
            }
        }
        return -1;
    }

    // 소수판별
    public boolean isPrime(int number) {
        if (number % 2 == 0) return false;
        int sqrt = (int) Math.sqrt(number);
        for (int i = 3; i <= sqrt; i += 2) if (number % i == 0) return false;
        return true;
    }
}