package section2.daily_coding;

/*
# **rangeMinimum**

## **문제**

정수를 요소로 갖는 배열과 특정 구간을 입력받아, 해당 구간 내에서 최소값을 리턴해야 합니다.

## **입력**

### **인자 1 : arr**

- `int` 타입을 요소로 갖는 배열
- `arr.length`는 500,000 이하
- `arr[i]`는 -100,000 이상 100,000 이하의 정수

### **인자 2 : ranges**

- `int` 타입을 요소로 갖는 배열
- `ranges.length`는 10,000 이하
- `ranges[i]`는 특정 구간을 의미
- `ranges[i][0]`은 `i`번째 구간의 시작 인덱스
- `ranges[i][1]`은 `i`번째 구간의 마지막 인덱스

## **출력**

- 배열(`arr`)를 리턴해야 합니다. (입출력 예시 참고)
- `arr[i]`는 `i`번째 구간(`ranges[i]`)의 최소값

## **입출력 예시**

```
int[] arr = new int[]{1, 3, 2, 7, 9, 11};
int[][] ranges = new int[][]{
  {1, 4},
  {0, 3}
};
int[] mins = rangeMinimum(arr, ranges);
System.out.println(mins); // --> [2, 1]
```

## **Advanced**

- Advanced1: 주어진 배열에서 특정 구간의 최소값을 구하는 단순한 알고리즘은 단순 순회(`O(N)`)입니다. 같은 배열에 대해서 다양한 구간에 대한 최소값을 구할 경우, 단순 순회는 `O(N^2)` 입니다(구간의 개수도 N개라 가정할 경우). 적절한 자료구조를 통해 이와 같은 구간 조회에 대한 반복 작업을 효율적(`O(N * logN)`)으로 수행할 수 있습니다. 구간 트리(segment tree)에 대해서 학습하시고, Advanced 테스트 케이스를 통과해 보시기 바랍니다.
- 트리를 배열로 구현할 수 있습니다. 객체로 구현하는 것이 보다 직관적이기 때문에 객체로 먼저 도전하시기 바랍니다. 레퍼런스는 모두 주어집니다.
- 구간의 최대값, 합도 동일한 로직으로 구현하면 됩니다.
 */

import java.util.Arrays;

public class Q_53_rangeMinimum {
    public static void main(String[] args) {
        // write test case here
        Q_53_rangeMinimum coplit = new Q_53_rangeMinimum();

        int[] arr = new int[]{1, 3, 2, 7, 9, 11};
        int[][] ranges = new int[][]{
                {1, 4},
                {0, 3}
        };
        int[] mins = coplit.rangeMinimum(arr, ranges);
        System.out.println(Arrays.toString(mins));  // --> [2, 1]

    }

    //createMinTree 메서드 활용을 위해 필드변수 선언
    static int[] tree;

    public int[] rangeMinimum(int[] arr, int[][] ranges) {
        // 트리 전체의 높이(루트 노트에서 가장 깊은 리프 노드까지의 거리)를 구하고
        // 전체 배열의 크기를 구한다.
        double log2 = Math.log(arr.length) / Math.log(2);
        double height = Math.ceil(log2);
        double size = Math.pow(2, height + 1) - 1;
        tree = new int[(int)size];
        Arrays.fill(tree, 0);
        createMinTree(arr, 0, arr.length - 1, tree, 0);
        return mins(ranges, arr);
    }

    public int findMin(int ts, int te, int rs, int re, int idx) {
        if (rs <= ts && te <= re) {
            return tree[idx];
        }

        if (te < rs || re < ts) {
            return Integer.MAX_VALUE;
        }

        int mid = (ts + te) / 2;
        return Math.min(
                findMin(ts, mid, rs, re, 2 * idx + 1),
                findMin(mid + 1, te, rs, re, 2 * idx + 2)
        );
    }

    public int[] mins(int[][] range, int[] arr) {
        int[] result = new int[range.length];
        for(int i = 0; i < range.length; i++) {
            int start = range[i][0];
            int end = range[i][1];
            result[i] = (findMin(0, arr.length - 1, start, end, 0));
        }
        return result;
    }

    public int createMinTree(int[] arr, int ts, int te, int[] tree, int idx) {
        if(ts == te) {
            tree[idx] = arr[ts];
            return arr[ts];
        }
        int mid = (ts + te) / 2;
        tree[idx] = Math.min(
                createMinTree(arr, ts, mid, tree, (idx * 2) + 1),
                createMinTree(arr, mid + 1, te, tree, (idx * 2) + 2)
        );
        return tree[idx];
    }
}