package section2.daily_coding;

/*
# **largestRectangularArea**

## **문제**

히스토그램(histogram)은 표(도수 분포표, 빈도표)로 되어 있는 도수 분포(frequency distribution)를 정보 그림으로 나타낸 것입니다. 예를 들어, 대학교의 한 학과에서 신입생들의 현재 거주 지역을 조사한 결과가 다음과 같다고 가정해 봅시다.

- 서울 2명, 경기 1명, 대전 4명, 부산 5명, 대구 1명, 광주 3명, 제주도 3명...

이 자료를 히스트그램으로 나타내면 각각 높이 2, 1, 4, 5, 1, 3, 3인 직사각형이 왼쪽부터 그려지게 됩니다. 편의상 직사각형의 너비는 1이라고 가정합니다. 이를 그림으로 나타내면 아래와 같습니다.

```
6 |
5 |       x
4 |     x x
3 |     x x   x x
2 | x   x x   x x
1 | x x x x x x x
------------------
```

이 히스토그램 내에서 만들 수 있는 가장 큰 직사각형의 면적은 8입니다 (O로 표시한 부분).

```
6 |
5 |       x
4 |     O O
3 |     O O   x x
2 | x   O O   x x
1 | x x O O x x x
------------------
```

이처럼 임의의 히스토그램 내에서 가장 큰 직사각형의 면적을 리턴해야 합니다.

## **입력**

### **인자 1 : histogram**

- `int` 타입을 요소로 갖는 배열
- `histogram[i]`는 100,000 이하의 양의 정수
- `histogram.length`는 100,000 이하

## **출력**

- `int` 타입을 리턴해야 합니다.

## **입출력 예시**

```
int[] histogram = new int[]{2, 1, 4, 5, 1, 3, 3};
int output = largestRectangularArea(histogram);
System.out.println(output); // --> 8

histogram = new int[]{6, 2, 5, 4, 5, 1, 6};
output = largestRectangularArea(histogram);
System.out.println(output); // --> 12

// 6 | x           x
// 5 | x   x   x   x
// 4 | x   O O O   x
// 3 | x   O O O   x
// 2 | x x O O O   x
// 1 | x x O O O x x
// ------------------
```

## **Advanced**

- 임의의 히스토그램에서 가장 큰 직사각형의 넓이를 계산하는 효율적인 알고리즘(`O(N * logN)`)이 존재합니다. 쉽지 않기 때문에 바로 레퍼런스 코드를 보고 이해하는 데 집중하시기 바랍니다.

## **힌트**

- Stack을 사용하여 PLE(previous less element), NLE(next less element) 알고리즘을 구현하여 해결합니다.
 */

import java.util.Arrays;
import java.util.Stack;

public class Q_54_largestRectangularArea {
    public static void main(String[] args) {
        // write test case here
        Q_54_largestRectangularArea coplit = new Q_54_largestRectangularArea();

        int[] histogram = new int[]{2, 1, 4, 5, 1, 3, 3};
        int output = coplit.largestRectangularArea(histogram);
        System.out.println(output); // --> 8

        // 5 |       x
        // 4 |     o o
        // 3 |     o o   x x
        // 2 | x   o o   x x
        // 1 | x x o o x x x
        // ------------------

        histogram = new int[]{6, 2, 5, 4, 5, 1, 6};
        output = coplit.largestRectangularArea(histogram);
        System.out.println(output); // --> 12

        // 6 | x           x
        // 5 | x   x   x   x
        // 4 | x   O O O   x
        // 3 | x   O O O   x
        // 2 | x x O O O   x
        // 1 | x x O O O x x
        // ------------------
    }

    /**
     * Stack을 사용하여 PLE(previous less element), NLE(next less element) 알고리즘을 구현하면 O(N * logN) 복잡도로 구하기 가능
     */
    public int largestRectangularArea(int[] histogram) {
        int maxArea = 0;
        int[] tempPLE = new int[histogram.length];
        int[] tempNLE = new int[histogram.length];
        Arrays.fill(tempPLE, -1);
        Arrays.fill(tempNLE, -1);

        int[] PLE = findPLE(tempPLE, histogram);
        int[] NLE = findNLE(tempNLE, histogram);
        for (int i = 0; i < histogram.length; i++) {
            int barsOnLeft = PLE[i] == -1 ? i : i - PLE[i] - 1;
            int barsOnRight = NLE[i] == -1 ? histogram.length - 1 - i : NLE[i] - i - 1;
            int width = barsOnLeft + barsOnRight + 1;
            maxArea = Math.max(maxArea, width * histogram[i]);
        }
        return maxArea;
    }

    public int[] findPLE(int[] PLE, int[] histogram) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < histogram.length; i++) {
            while (stack.size() > 0 && histogram[stack.get(stack.size() - 1)] >= histogram[i]) {
                stack.pop();
            }
            if (stack.size() > 0) {
                PLE[i] = stack.get(stack.size() - 1);
            }
            stack.push(i);
        }
        return PLE;
    }

    public int[] findNLE(int[] NLE, int[] histogram) {
        Stack<Integer> stack = new Stack<>();
        for (int i = histogram.length - 1; i >= 0; i--) {
            while (stack.size() > 0 && histogram[stack.get(stack.size() - 1)] >= histogram[i]) {
                stack.pop();
            }
            if (stack.size() > 0) {
                NLE[i] = stack.get(stack.size() - 1);
            }
            stack.push(i);
        }
        return NLE;
    }

}