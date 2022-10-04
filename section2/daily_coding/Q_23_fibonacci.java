package section2.daily_coding;

/*
# **fibonacci**

## **문제**

아래와 같이 정의된 피보나치 수열 중 n번째 항의 수를 리턴해야 합니다.

- 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1입니다. 그 다음 2번째 피보나치 수부터는 바로 직전의 두 피보나치 수의 합으로 정의합니다.
- 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ...

## **입력**

### **인자 1 : n**

- `int` 타입의 n (n은 0 이상의 정수)

## **출력**

- `int` 타입을 리턴해야합니다.

## **주의사항**

- **재귀함수를 이용해** 구현해야 합니다.
- 반복문(`for`, `while`) 사용은 금지됩니다.
- 함수 `fibonacci`가 반드시 재귀함수일 필요는 없습니다.

## **입출력 예시**

```
int output = fibonacci(0);
System.out.println(output); // --> 0

output = fibonacci(1);
System.out.println(output); // --> 1

output = fibonacci(5);
System.out.println(output); // --> 5

output = fibonacci(9);
System.out.println(output); // --> 34
```

## **Advanced**

- 피보나치 수열을 구하는 효율적인 알고리즘(`O(N)`)이 존재합니다. 재귀함수의 호출을 직접 관찰하여 비효율이 있는지 확인해 보시기 바랍니다.
 */

import java.util.HashMap;

public class Q_23_fibonacci {
    public static void main(String[] args) {
        // write test case here
        Q_23_fibonacci coplit = new Q_23_fibonacci();

        int output = coplit.fibonacci(0);
        System.out.println(output); // --> 0

        output = coplit.fibonacci(1);
        System.out.println(output); // --> 1

        output = coplit.fibonacci(5);
        System.out.println(output); // --> 5

        output = coplit.fibonacci(9);
        System.out.println(output); // --> 34
    }

    public int fibonacci(int num) {
        HashMap<Integer, Integer> history = new HashMap<>();
        history.put(0, 0);
        history.put(1, 1);
        history.put(2, 1);

        history = recursion(num, history);
        return history.get(num);
    }

    public HashMap<Integer, Integer> recursion(int num, HashMap<Integer, Integer> history) {
        if (num == 0 || num == 1 || num == 2) {
            return history;
        }

        if (!history.containsKey(num - 1)) {
            history = recursion(num - 1, history);
        }

        history.put(num, history.get(num - 1) + history.get(num - 2));
        return history;
    }
}




