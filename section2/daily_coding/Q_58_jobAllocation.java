package section2.daily_coding;

/*
# **jobAllocation**

## **문제**

공장의 조립 기계가 고장이 나 수리를 위해 여러 명의 수리공들이 왔습니다. 조립 기계는 일자 형태로 길게 배치되어 있기 때문에
수리공들 또한 나란히 위치해서 수리를 진행해야 합니다. 기계의 각 부품은 한 명의 수리공만 수리할 수 있고,
이동을 최소화하기 위해 각 수리공들은 서로 연속해서 있는 부품만 수리해야 합니다. 각 부품을 수리하는 데 걸리는 작업량은 제각각이고,
수리 시간은 작업량에 비례합니다. 작업량과 수리공들의 수가 주어질 때, 전체 수리가 가장 빠르게 끝나는 시간을 리턴해야 합니다.

문제를 다르게 표현하면 아래와 같습니다.

- 자연수 배열을 n개의 연속 구간으로 나눌 때, 합이 가장 큰 구간의 합을 sum이라고 합시다.
sum이 가장 작아지는 분배에서의 sum을 구해야 합니다.

## **입력**

### **인자 1 : jobs**

- `int` 타입을 요소로 갖는 배열
- `jobs[i]`는 1,000 이하의 양의 정수
- `jobs.length`는 1,000 이하

### **인자 2 : workersNum**

- `int` 타입의 1,000 이하의 자연수

## **출력**

- `int` 타입을 리턴해야 합니다.

## **입출력 예시**

```
int[] jobs = new int[]{1, 2, 3, 4, 5, 6, 7};
int workersNum = 3;
int output = jobAllocation(jobs, workersNum);
System.out.println(output); // --> 11 (1, 2, 3, 4 / 5, 6 / 7)

new int[]{10, 2, 3, 4, 16, 10, 10};
workersNum = 4;
output = jobAllocation(jobs, workersNum);
System.out.println(output); // --> 19 (10, 2, 3, 4 / 16 / 10 / 10
```
 */

import java.util.Arrays;

// TODO 이해하기
public class Q_58_jobAllocation {
    public static void main(String[] args) {
        // write test case here
        Q_58_jobAllocation coplit = new Q_58_jobAllocation();

        int[] jobs = new int[]{1, 2, 3, 4, 5, 6, 7};
        int workersNum = 3;
        int output = coplit.jobAllocation(jobs, workersNum);
        System.out.println(output); // --> 11 (1, 2, 3, 4 / 5, 6 / 7)

        jobs = new int[]{10, 2, 3, 4, 16, 10, 10};
        workersNum = 4;
        output = coplit.jobAllocation(jobs, workersNum);
        System.out.println(output); // --> 19 (10, 2, 3, 4 / 16 / 10 / 10)

    }

    /**
     * 재귀를 통한 문제풀이
     * <p>
     * 첫번째 사람이 가져가는 작업의 양에 따라 다음 작업자들이 가져갈 수 있는 작업량이 결정이 됩니다.
     * n명의 작업자에게 작업 분배를 할 때, 첫번째 작업자가 선택하고 남은 작업에서 n-1 작업자들의 작업 분배를 다시 재귀적으로 구할 수 있습니다.
     * <p>
     * ex) [1, 2, 3, 4, 5] 를 3명이서 분배하는 경우 <br>
     * 첫번째 작업자가 [1]을 가져간다면, [2,3,4,5]를 2, 3번째 작업자가 배분해야하는 상황이고
     * -> [2, 3, 4, 5]를 다시 2명이 분배하는 상황에서, 작업자중 첫번째 작업자가 가져가는 양에 따라 또 결정되는 상황
     * <br>
     * 첫번째 작업자가 [1, 2]을 가져간다면, [3,4,5]를 2, 3번째 작업자가 배분해야하는 상황이고
     * -> [3, 4, 5]를 다시 2명이 분배하는 상황에서, 작업자중 첫번째 작업자가 가져가는 양에 따라 또 결정되는 상황
     */

    // 총 5개의 작업을 3명이서 작업한다고 가정한다.
    // 첫번째 작업자는 최대 3개의 작업을 할 수 있다.
    // (jobs, workersNum)으로 표기하면, (jobs는 작업량이 아닌 작업의 인덱스만 표기한다고 한다)
    // 처음은 ([0, 1, 2, 3, 4], 3)인 상태이다.
    //  1) 첫번째 작업자가 1개의 작업을 하고 나머지 작업을 2명이 작업
    //    => ([1, 2, 3, 4], 2)
    //  2) 첫번째 작업자가 2개의 작업을 하고 나머지 작업을 2명이 작업
    //    => ([2, 3, 4], 2)
    //  3) 첫번째 작업자가 3개의 작업을 하고 나머지 작업을 2명이 작업
    //    => ([3, 4], 2)
    // 아래 두 가지 경우를 통해, 문제가 중복되어 계산된다는 것을 알 수 있다.
    //  1-1) 첫번째 작업자가 1개의 작업을 하고, 그 다음 작업자가 2개의 작업을 한 경우
    //    => ([3, 4], 1)
    //  2-1) 첫번째 작업자가 2개의 작업을 하고, 그 다음 작업자가 1개의 작업을 한 경우
    //    => ([3, 4], 1)
    // 메모이제이션을 통해 중복 계산을 피한다.

    public int jobAllocation(int[] jobs, int workersNum){
        // memo[i][j]는 i번째 worker가 j번째 job부터 작업한다고 할 때,
        // 최대 작업량이 최소가 되는 분배에서의 최대 작업량을 저장한다.
        // i, j 모두 인덱스이므로 0부터 시작
        int[][] memo = new int[workersNum][];
        for(int i = 0; i < workersNum; i++) {
            int[] arr = new int[jobs.length];
            Arrays.fill(arr, -1);
            memo[i] = arr;
        }
        // 마지막 작업자는 남아있는 모든 작업을 다 해야하므로 쉽게 계산이 가능하다.
        // 마지막 작업자는 최대 나머지 작업자의 수만큼을 제외한 일만 할 수 있다.
        int workload = 0;
        for (int i = jobs.length - 1; i >= workersNum - 1; i--) {
            workload = workload + jobs[i];
            memo[workersNum - 1][i] = workload;
        }

        return aux(0, 0, jobs, workersNum - 1, memo);
    }

    public int aux(int workerIdx, int jobIdx, int[] jobs, int left, int[][] memo) {
        // 이미 계산한 적이 있는 경우, 다시 풀지 않는다
        // 마지막 작업자의 작업량을 전부 계산했으므로, 탈출 조건을 굳이 작성하지 않아도 된다.
        if (memo[workerIdx][jobIdx] != -1) return memo[workerIdx][jobIdx];

        int workload = 0;
        int min = Integer.MAX_VALUE;
        for (int i = jobIdx; i < jobs.length - left; i++) {
            workload = workload + jobs[i];
            // 가장 많이 일하는 사람의 작업량을 구한다.
            int hardest = Math.max(
                    workload,
                    aux(workerIdx + 1, i + 1, jobs, left - 1, memo)
            );
            // 그 작업량이 최소화되는 분배에서 최대 작업량을 구한다.
            min = Math.min(min, hardest);
        }
        memo[workerIdx][jobIdx] = min;
        return min;
    }
}