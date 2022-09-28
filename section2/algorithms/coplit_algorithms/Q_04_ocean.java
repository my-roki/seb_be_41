package section2.algorithms.coplit_algorithms;

/*
# **금고를 털어라**

## **문제**

자신이 감옥에 간 사이 연인이었던 줄리아를 앤디에게 빼앗겨 화가 난 조지는 브레드,
맷과 함께 앤디 소유의 카지노 지하에 있는 금고를 털기로 합니다. 온갖 트랩을 뚫고 드디어 금고에 진입한 조지와 일행들.
조지는 이와중에 감옥에서 틈틈이 공부한 알고리즘을 이용해 target 금액을 훔칠 수 있는 방법의 경우의 수를 계산하기 시작합니다.

예를 들어 $50 을 훔칠 때 $10, $20, $50 이 있다면 다음과 같이 4 가지 방법으로 $50을 훔칠 수 있습니다.

- $50 한 장을 훔친다
- $20 두 장, $10 한 장을 훔친다
- $20 한 장, $10 세 장을 훔친다
- $10 다섯 장을 훔친다

훔치고 싶은 target 금액과 금고에 있는 돈의 종류 type 을 입력받아, 조지가 target 을 훔칠 수 있는 방법의 수를 리턴하세요.

## **입력**

### **인자 1: target**

- `int` 타입의 100,000 이하의 자연수

### **인자 2: type**

- `int` 타입을 요소로 갖는 100 이하의 자연수를 담은 배열

## **출력**

- `int` 타입을 리턴해야 합니다.
- 조지가 target을 훔칠 수 있는 방법의 수를 숫자로 반환합니다.

## **주의사항**

- 모든 화폐는 무한하게 있다고 가정합니다.

## **입출력 예시**

```
int output = ocean(50, new int[]{10, 20, 50});
System.out.println(output); // 4

output = ocean(100, new int[]{10, 20, 50});
System.out.println(output); // 10

output = ocean(30, new int[]{5, 6, 7});
System.out.println(output); // 4
```

## **Hint!**

해당 문제는 `동전 교환 알고리즘 (Coin Change)`을 활용하여 풀 수 있습니다.
검색해 보시고, 연구해 보세요!
 */

import java.util.Arrays;

public class Q_04_ocean {
    public static void main(String[] args) {
        // write test case here
        Q_04_ocean coplit = new Q_04_ocean();
        long output = coplit.ocean(5, new int[]{1, 2, 5});
        System.out.println(output); // 4

        output = coplit.ocean(100, new int[]{10, 20, 50});
        System.out.println(output); // 10

        output = coplit.ocean(30, new int[]{5, 6, 7});
        System.out.println(output); // 4
    }

    public long ocean(int target, int[] type) {
        long[] bucket = new long[target + 1];  // n을 만들 수 있는 조합을 담을 bucket
        bucket[0] = 1;  // 0을 만드는 방법은 아무것도 안 하기 1가지
        for (int money : type) {
            for (int n = 1; n < bucket.length; n++) {
                if (n < money) continue;  // 만들어야하는 수 n보다 재료 money가 더 크면 조합할 수 없습니다.
                bucket[n] += bucket[n - money];
            }
        }
        return bucket[target];
    }

    // 재귀를 이용한 풀이.. 시간복잡도가 O(n^2)이라 입력값이 많아지면 시관초과 에러가 뜹니다.
    public int recursiveSolve(int output, int target, int[] type) {
        // base case 더이상 나머지 잔돈을 나눌 수 없는 경우.
        if (type.length == 0) return output;

        int count = target / type[type.length - 1];
        for (int i = 0; i <= count; i++) {
            int rest = target - (type[type.length - 1] * i);
            if (rest != 0) {
                int[] copyType = Arrays.copyOfRange(type, 0, type.length - 1);
                output = recursiveSolve(output, rest, copyType);
            } else {
                output += 1;
                return output;
            }
        }
        return output;
    }
}

