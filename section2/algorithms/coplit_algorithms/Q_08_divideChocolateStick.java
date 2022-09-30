package section2.algorithms.coplit_algorithms;

/*
# **빼빼로 데이**

## **문제**

오늘은 빼빼로 데이입니다. 한 회사의 팀장은 출근길에 아몬드 빼빼로 M개와 누드 빼빼로 N개를 구매하여 아침 일찍 출근길에 나섰습니다.

팀장은 자신보다 먼저 출근해 있는 직원들에게 구매한 빼빼로를 전부 나누어 주려고 합니다.
단, 서로 질투하는 경우를 만들지 않기 위해 모든 직원들에게 공평하게 빼빼로를 나누어 주려고 합니다.
직원들은 각각의 빼빼로를 똑같은 개수만큼 받아야 합니다. 빼빼로를 쪼개서 줄 수는 없습니다.

하지만 회사에 도착하기 전이라 몇 명의 직원들이 있는지 모르는 상황입니다.
팀장이 아몬드 빼빼로를 4개, 누드 빼빼로를 8개를 구매 했다면, 다음과 같이 세 가지 방법으로 나누어 줄 수 있습니다.

- 출근한 직원이 1명이라면 아몬드 빼빼로 4개와 누드 빼빼로 8개를 줄 수 있습니다.
- 출근한 직원이 2명이라면 아몬드 빼빼로 2개와 누드 빼빼로 4개를 각각 줄 수 있습니다.
- 출근한 직원이 3명이라면 빼빼로를 남기지 않고 공평하게 주는 방법은 없습니다.
- 출근한 직원이 4명이라면 아몬드 빼빼로 1개와 누드 빼빼로 2개를 각각 줄 수 있습니다.

팀장은 출근한 직원 수에 따라 어떻게 빼빼로를 나누어 줄지 고민하고 있습니다.
여러분이 직원 수에 따라 빼빼로를 나누어 주는 방법을 구하는 솔루션을 제공해 주세요.

## **입력**

### **인자 1: M**

- `int` 타입의 양의 정수 (1 ≤ M ≤ 1,000,000,000)

### **인자 2: N**

- `int` 타입의 양의 정수 (1 ≤ N ≤ 1,000,000,000)

## **출력**

- `ArrayList<Integer[]>` 타입의 `output`을 리턴해야 합니다.
- `output[i]`은 다음과 같은 순서를 가진 길이 3의 배열입니다.
    - `[빼빼로를 받게 되는 직원의 수, 나누어 주는 아몬드 빼빼로의 수, 나누어 주는 누드 빼빼로의 수]`
- `output`은 `output[i][0]`, 즉 '빼빼로를 받게 되는 직원의 수'를 기준으로 오름차순으로 정렬합니다.

## **입출력 예시**

```
int M = 4;
int N = 8;
ArrayList<Integer[]> output = divideChocolateStick(M, N);
System.out.println(output);
// [[1, 4, 8], [2, 2, 4], [4, 1, 2]]
```
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Q_08_divideChocolateStick {
    public static void main(String[] args) {
        // write test case here
        Q_08_divideChocolateStick coplit = new Q_08_divideChocolateStick();

        ArrayList<Integer[]> output = coplit.divideChocolateStick(4, 8);
        System.out.println(output);
        // [[1, 4, 8], [2, 2, 4], [4, 1, 2]]

        output = coplit.divideChocolateStick(20, 10);
        System.out.println(output);
        // [[1, 20, 10], [2, 10, 5], [5, 4, 2], [10, 2, 1]]

    }

    public ArrayList<Integer[]> divideChocolateStick(int M, int N) {
        ArrayList<Integer[]> output = new ArrayList<>();

        // 최대공약수를 구합니다.
        int gcd = 0;
        for (int i = 1; i <= N && i <= M; i++) {
            if (M % i == 0 && N % i == 0) gcd = i;
        }

        // 최대공약수의 약수들을 가려내서.
        // [약수, M / 약수, N / 약수] 배열들 생성 후 output에 add
        for (int j = 1; j <= gcd; j++) {
            if (gcd % j == 0) {
                output.add(new Integer[]{j, M / j, N / j});
            }
        }
        return output;
    }
}

