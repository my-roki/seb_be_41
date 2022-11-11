package section2.daily_coding;

/*
# **coinChange**

## **문제**

다양한 동전들을 가지고 특정 금액을 만들 수 있는 모든 경우의 수를 리턴해야 합니다.

- 예를 들어, 100원, 500원짜리 동전을 가지고 1,000원을 만들 수 있는 방법은 총 3가지 입니다.
- 100원 10개, 100원 5개 + 500원 1개, 500원 2개

## **입력**

### **인자 1 : total**

- `int` 타입의 이하의 자연수

### **인자 2 : coins**

- `int` 타입을 요소로 갖는 배열
- `coins.length`는 10,000 이하
- `coins[i]`는 20 이하의 양의 정수

## **출력**

- `int` 타입을 리턴해야 합니다.

## **주의사항**

- 동전의 금액은 다양하게 주어집니다.
- `coins`는 오름차순으로 정렬되어 있습니다.
- 각 동전의 개수는 무수히 많다고 가정합니다.

## **입출력 예시**

```
int total = 10;
int[] coins = new int[]{1, 5};
int output = coinChange(total, coins);
System.out.println(output); // --> 3

total = 4;
coins = new int[]{1, 2, 3};
output = coinChange(total, coins);
System.out.println(output); // --> 4 ([1, 1, 1, 1], [1, 1, 2], [2, 2], [1, 3])
```

## **Advanaced**

- coinChange를 계산하는 효율적인 알고리즘(`O(M * N)`)이 존재합니다(`total`과 `coins.length`가 N, M일 경우). 쉽지 않기 때문에 바로 레퍼런스 코드를 보고 이해하는 데 집중하시기 바랍니다.
 */

public class Q_46_coinChange {
    public static void main(String[] args) {
        // write test case here
        Q_46_coinChange coplit = new Q_46_coinChange();

        int total = 10;
        int[] coins = new int[]{1, 5};
        int output = coplit.coinChange(total, coins);
        System.out.println(output); // --> 3

        total = 4;
        coins = new int[]{1, 2, 3};
        output = coplit.coinChange(total, coins);
        System.out.println(output); // --> 4 ([1, 1, 1, 1], [1, 1, 2], [2, 2], [1, 3])

    }

    public int coinChange(int total, int[] coins) {
        // TODO :
        return 1;
    }

}