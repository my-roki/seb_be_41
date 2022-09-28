package section2.algorithms.coplit_algorithms;

/*
문제
편의점에서 아르바이트를 하고 있는 중에, 하필이면 피크 시간대에 손님에게 거스름돈으로 줄 동전이 부족하다는 것을 알게 되었습니다.
현재 가지고 있는 동전은 1원, 5원, 10원, 50원, 100원, 500원으로 오름차순으로 정렬되어 있고, 각 동전들은 서로 배수 관계에 있습니다.
동전 개수를 최소화하여 거스름돈 K를 만들어야 합니다. 이때, 필요한 동전 개수의 최솟값을 구하는 함수를 작성해 주세요.

입력
인자: k
int 타입의 k
1 <= k <= 100,000,000

출력
int 타입의 거스름돈 K원을 만드는데 필요한 동전 개수의 최솟값을 반환해야 합니다.

입출력 예시
// 4000원을 받았을 때 500원짜리 동전 8개를 반환합니다.
int output1 = partTimeJob(4000);
System.out.println(output1); // --> 8

// 4972원을 받았을 때 500원짜리 동전 9개, 100원짜리 동전 4개, 50원짜리 동전 1개, 10원짜리 동전 2개, 1원짜리 동전 2개, 총 18개를 반환합니다.
int output2 = partTimeJob(4972);
System.out.println(output2); // --> 18
 */

public class Q_02_partTimeJob {
    public static void main(String[] args) {
        // write test case here
        Q_02_partTimeJob coplit = new Q_02_partTimeJob();

        // 4000원을 받았을 때 500원짜리 동전 8개를 반환합니다.
        int output1 = coplit.partTimeJob(4000);
        System.out.println(output1); // --> 8

        // 4972원을 받았을 때 500원짜리 동전 9개, 100원짜리 동전 4개, 50원짜리 동전 1개, 10원짜리 동전 2개, 1원짜리 동전 2개, 총 18개를 반환합니다.
        int output2 = coplit.partTimeJob(4972);
        System.out.println(output2); // --> 18
    }

    public int partTimeJob(int k) {
        int output = 0;
        int[] coins = new int[]{500, 100, 50, 10, 5, 1};
        for (int coin : coins) {
            output += k / coin;
            k -= coin * (k / coin);
        }
        return output;
    }

}

