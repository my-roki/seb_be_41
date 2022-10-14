package section2.daily_coding;

/*
# **orderOfPresentation**

## **문제**

말썽꾸러기 김코딩은 오늘도 장난을 치다가 조별 발표 순서가 담긴 통을 쏟고 말았습니다.

선생님께서는 미리 모든 발표 순서의 경우의 수를 저장해 놓았지만 김코딩의 버릇을 고치기 위해 문제를 내겠다고 말씀하셨습니다.

김코딩은 모든 조별 발표 순서에 대한 경우의 수를 차례대로 구한 뒤 발표 순서를 말하면 이 발표 순서가 몇 번째 경우의 수인지를 대답해야 합니다.

총 조의 수 N과 선생님이 말씀하시는 발표 순서 k가 주어질 때, 김코딩이 정답을 말 할 수 있게 올바른 리턴 값을 구하세요.

모든 경우의 수가 담긴 배열은 번호가 작을수록 앞에 위치한다고 가정합니다.
ex) N = 3일경우, [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

## **입력**

### **인자 1: N**

- `int` 타입의 1 <= N <= 12인 조의 개수

### **인자 2: K**

- `int`타입을 요소로 가지는 배열 (0 <= index)

ex) n이 3이고 k가 [2, 3, 1]일 경우

모든 경우의 수를 2차원 배열에 담는다면 [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]이 되고,

반환하는 값은 3이 됩니다.

## **주의사항**

- k내에 중복되는 요소는 없다고 가정합니다.

## **입출력 예시**

```
int output = orderOfPresentation(3, new int[]{2, 3, 1});
System.out.println(output); // 3

output = orderOfPresentation(5, new int[]{1, 3, 2, 4, 5});
System.out.println(output); // 6
```
 */

import java.util.Arrays;

// TODO : 현재 정확성에서는 통과를 하지만 효율성 측면에서 통과를 하지 못하고 있습니다. 리팩토링이 필요한 코드입니다.
public class Q_32_orderOfPresentation {
    public static void main(String[] args) {
        // write test case here
        Q_32_orderOfPresentation coplit = new Q_32_orderOfPresentation();

        int output = coplit.orderOfPresentation(3, new int[]{2, 3, 1});
        System.out.println(output); // 3

        output = coplit.orderOfPresentation(5, new int[]{1, 3, 2, 4, 5});
        System.out.println(output); // 6
    }

    public int orderOfPresentation(int N, int[] K) {
        // 조 배열 생성
        int[] lookup = new int[N];
        for (int i = 0; i < N; i++) lookup[i] = i + 1;

        StringBuilder target = new StringBuilder();
        for (int n : K) target.append(n);  // 배열 안에 있는 요소를 비교하기 쉽게 문자열로 만듭니다.

        int[] output = permutation(N, lookup, new int[]{}, target.toString(), new int[]{0, 0});
        return output[1];
    }

    public int[] permutation(int round, int[] lookup, int[] bucket, String target, int[] count) {
        if (round == 0) {
            StringBuilder candidate = new StringBuilder();
            for (int b : bucket) candidate.append(b);
            if (target.equals(candidate.toString())) {
                count[0] = 1;
                return count;
            }
            count[1]++;
        }

        for (int number : lookup) {
            int[] newBucket = Arrays.copyOf(bucket, bucket.length + 1);
            newBucket[newBucket.length - 1] = number;
            int[] filterLookup = Arrays.stream(lookup).filter(i -> i != number).toArray();
            count = permutation(round - 1, filterLookup, newBucket, target, count);
            if (count[0] == 1) return count;
        }

        return count;
    }
}

