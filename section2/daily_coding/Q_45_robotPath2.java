package section2.daily_coding;

/*
# **robotPath2**

## **문제**

세로와 가로의 길이가 각각 M, N인 방의 지도가 2차원 배열로 주어졌을 때, `1`은 장애물을 의미하고 `0` 이동이 가능한 통로를 의미합니다.
로봇은 한 번에 임의의 k칸 직진과 90도 회전 중 1가지 동작을 할 수 있다.
로봇의 현재 위치와 방향, 목표 지점과 방향이 함께 주어집니다. 이 때, 방향은 위쪽이 1, 오른쪽이 2, 아래쪽이 3, 왼쪽이 4로 주어집니다.
로봇이 목표 지점까지 도달해 목표 방향으로 회전하는 데 필요한 동작의 수를 리턴해야 합니다.

## **입력**

### **인자 1 : room**

- 배열을 요소로 갖는 배열
- `room.length`는 M
- `room[i]`는 `int` 타입을 요소로 갖는 배열
- `room[i].length`는 N
- `room[i][j]`는 세로로 i, 가로로 j인 지점의 정보를 의미
- `room[i][j]`는 0 또는 1

### **인자 2 : src**

- `int` 타입을 요소로 갖는 배열
- `src.length`는 2
- `src[i]`는 0 이상의 정수
- `src`의 요소는 차례대로 좌표평면 위의 y좌표, x좌표

### **인자 3 : sDir**

- `int` 타입의 자연수

### **인자 4 : dst**

- `int` 타입을 요소로 갖는 배열
- `dst.length`는 2
- `dst[i]`는 0 이상의 정수
- `dst`의 요소는 차례대로 좌표평면 위의 y좌표, x좌표

### **인자 3 : dDir**

- `int` 타입의 자연수

## **출력**

- `int` 타입을 리턴해야 합니다.

## **주의사항**

- M, N은 20 이하의 자연수입니다.
- `src`, `dst`는 항상 로봇이 지나갈 수 있는 통로입니다.
- `src`에서 `dst`로 가는 경로가 항상 존재합니다.
- 목표 지점에 도달한 후 방향까지 일치해야 합니다.
- 직진은 1칸 직진이 아니라 임의의 k칸을 직진할 수 있습니다. 즉 한번의 직진 명령으로 장애물이 없는 한 계속 갈 수 있습니다.
- 왼쪽에서 오른쪽 또는 아래에서 위쪽으로 방향을 바꾸는 데 총 2번의 회전 동작이 필요합니다.

## **입출력 예시**

```java
int[][] room = new int[][]{
  {0, 0, 0, 0},
  {0, 1, 1, 0},
  {0, 1, 0, 0},
  {0, 0, 1, 1},
};
int[] src = new int[]{3, 0};
int sDir = 3;
int[] dst = new int[]{2, 2};
int dDir = 2;
int output = robotPath2(room, src, sDir, dst, dDir);
System.out.println(output); // --> 11

//    1. 시작 - (3, 0)에서 아래 방향을 향한 상태
//    장애물은 x로 표시, 출발지점은 s로 표시
//    [
//      [0, 0, 0, 0],
//      [0, x, x, 0],
//      [0, x, 0, 0],
//      [s, 0, x, x],
//    ]
//
//    2. 로봇은 아래 방향을 향하고 있음
//      3인 이유: 위로 가기 위해서는 90도 회전이 2번, 직진 1번 필요함. 직진 한번으로 도달할 수 있는 모든 칸을 표기.
//      2인 이유: 오른쪽으로 가기 위해서는 90도 회전 1번, 직진 1번이 필요함
//    [
//      [3, 0, 0, 0],
//      [3, x, x, 0],
//      [3, x, 0, 0],
//      [s, 2, x, x],
//    ]
//
//    3. (0, 0) 지점에서 로봇은 위 방향을 향하고 있음
//      5인 이유: 오른쪽으로 가기 위해서는 90도 회전이 1번, 직진 1번 필요함.
//      1인 이유: 직진 1번으로 충분
//    [
//      [3, 5, 5, 5],
//      [3, x, x, 0],
//      [3, x, 0, 0],
//      [s, 2, x, x],
//    ]
//
//    4. 비슷한 방식으로 계산하면 최종적으로 방향 전환까지 11번이 나오게 된다.

room = new int[][]{
  {0, 0, 0, 0, 0, 0},
  {0, 1, 1, 0, 1, 0},
  {0, 1, 0, 0, 0, 0},
  {0, 0, 1, 1, 1, 0},
  {1, 0, 0, 0, 0, 0},
};
src = new int[]{4, 2};
sDir = 1;
dst = new int[]{2, 2};
dDir = 3;
output = robotPath2(room, src, sDir, dst, dDir);
System.out.println(output); // --> 7
```
 */

import java.util.*;

public class Q_45_robotPath2 {
    public static void main(String[] args) {
        // write test case here
        Q_45_robotPath2 coplit = new Q_45_robotPath2();

        int[][] room = new int[][]{
                {0, 0, 0, 0},
                {0, 1, 1, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 1},
        };
        int[] src = new int[]{3, 0};
        int sDir = 3;
        int[] dst = new int[]{2, 2};
        int dDir = 2;
        int output = coplit.robotPath2(room, src, sDir, dst, dDir);
        System.out.println(output); // --> 11

        room = new int[][]{
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 0},
        };
        src = new int[]{4, 2};
        sDir = 1;
        dst = new int[]{2, 2};
        dDir = 3;
        output = coplit.robotPath2(room, src, sDir, dst, dDir);
        System.out.println(output); // --> 7


        room = new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 1, 1, 0},
                {1, 1, 0, 1, 1, 1, 0},
                {0, 0, 0, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        src = new int[]{6, 1};
        sDir = 1;  // up
        dst = new int[]{0, 1};
        dDir = 1;  // up
        output = coplit.robotPath2(room, src, sDir, dst, dDir);
        System.out.println(output); // --> 7


        room = new int[][]{
                {1, 0, 0},
                {0, 0, 0},
                {0, 0, 1}
        };

        src = new int[]{2, 0};
        sDir = 2;  // right
        dst = new int[]{0, 2};
        dDir = 1;  // up
        output = coplit.robotPath2(room, src, sDir, dst, dDir);
        System.out.println(output); // --> 6
    }

    public int robotPath2(int[][] room, int[] src, int sDir, int[] dst, int dDir) {
        /*
        너비우선탐색(BFS)으로 문제를 풀 수 있습니다.
        하지만 n칸 직진과 1회 회전을 동일한 1번의 카운트로 여기기 때문에 향상된 visited(경로추적)가 필요합니다.

        > 움직임: n칸 직진 또는 1번의 회전시 카운트 + 1
        > 칸이동: 상하좌우 1칸 이동시 카운트 + 1

        로봇이 짧은 경로의 꼬불꼬불한 길을 탐색하면 움직임은 많으나 칸이동은 적다.
        로봇이 긴 경로의 직진으로 이루어진 길을 탐색하면 움직임은 적으나 칸이동은 많다.

        예시)
        ```
        int[][] room = new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 1, 1, 0},
                {1, 1, 0, 1, 1, 1, 0},
                {0, 0, 0, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        int[] src = new int[]{6, 1};
        int sDir = 1;  // up
        int[] dst = new int[]{0, 1};
        int dDir = 1;  // up

        // 오른쪽(긴직진) vs 왼쪽(짧꼬불)
        // 움직임 -> 오른쪽: 7 / 왼쪽: 15
        // 칸이동 -> 오른쪽: 16 / 왼쪽: 12
        ```

        문제에서 요구하는 값은 칸이동이 아닌 움직임의 횟수이기 때문에 칸이동 방법으로 목표지점까지 도달하되, 그 경우의 수 중 가장 움직임이 작은 값으로 리턴해야합니다.
        누군가가 지나갔다고 이미 지나간 경로가 움직임이 가장 적은 효율적인 경로가 아니기 때문입니다.
         */

        // 전체 room의 가로와 세로의 길이
        int height = room.length;
        int width = room[0].length;

        // 상하좌우 방향을 배열로 담습니다.
        int[][] MOVES = new int[][]{
                {1, -1, 0}, // UP
                {2, 0, 1}, // RIGHT
                {3, 1, 0}, // DOWN
                {4, 0, -1} // LEFT
        };

        // 각 위치별 움직임의 수로 visited를 기록합니다.
        // 이미 누군가가 지나간 자리더라도 도착한 현재 움직임의 수가 더 적으면 최소 움직임으로 도달할 수 있는 가능성이 있기 때문에 중복으로 지나갈 수 있습니다.
        int[][] advancedVisited = new int[height][width];

        // ! direction을 따로 관리하는 이유는 항상 queue에서 나온 좌표는 최선의 움직임과 최선의 움직임을 취한 방향을 가지고 있어야합니다.
        // ! queue에 방향까지 같이 저장하게 되면 그 값이 queue에서 나오는 순간 최선의 방향이다라고 보장할 수 없습니다.
        // ! (들어가서 나오는 순간까지 많은 다른 움직임들이 업데이트 되었을거고 그 안에서도 많은 방향의 업데이트가 됨)
        int[][] directionList = new int[height][width];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                directionList[row][col] = 0;
                if (room[row][col] == 1)
                    advancedVisited[row][col] = -1;  // 장애물은 음수로 처리 -> 이렇게 처리하면 room 원본 배열을 쓰지 않아도 장애물 판별, 움직임 비교가 동시에 가능해집니다.
                else advancedVisited[row][col] = Integer.MAX_VALUE;  // 나중에 최소 움직임 비교를 위해 모든 값들을 MAX_VALUE로 채움
            }
        }

        // queue 를 통한 BFS
        // 큐 안에 들어가는 배열은 [current row, current column]
        Queue<int[]> queue = new LinkedList<>();

        advancedVisited[src[0]][src[1]] = 0;
        directionList[src[0]][src[1]] = sDir;
        queue.add(new int[]{src[0], src[1]});

        while (queue.size() != 0) {
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];
            int currentDirection = directionList[currentRow][currentCol];


            // 각각의 방향을 갈 수 있는지 판별합니다.
            for (int[] move : MOVES) {
                int direction = move[0];

                // 이동할 다음 좌표
                int nextRow = currentRow + move[1];
                int nextCol = currentCol + move[2];

                // 다음 좌표가 영역 밖이 되거나(또는) 다음 좌표가 장애물(-1)인 경우 이동하지 못하기 때문에 continue
                if (nextRow < 0 || nextRow >= height || nextCol < 0 || nextCol >= width || advancedVisited[nextRow][nextCol] == -1)
                    continue;

                int candidate;  // 현재까지 움직인 횟수를 담을 변수

                // 방향 전환을 해야하는가?
                // 현재 방향과 진행 방향이 같은 경우 카운트하지 않습니다(n번의 직진은 코두 1움직임이라고 간주)
                // 2번 회전(rotate = 2)해야 하는 경우 회전 2번 + 직진 1번을 움직임으로 추가합니다.
                // 1번 회전(rotate = 1 or 3)해야 하는 경우 회전 1번 + 직진 1번을 움직임으로 추가합니다.
                int rotate = Math.abs(direction - currentDirection);
                if (rotate == 0)
                    // 첫 시작점에서의 움직임이 방향전환 없이 이동만 있으면 +1, 중간의 n번의 움직임 중 하나라면 카운트 하지 않습니다.
                    candidate = advancedVisited[currentRow][currentCol] != 0 ? advancedVisited[currentRow][currentCol] : 1;
                else if (rotate == 2) candidate = advancedVisited[currentRow][currentCol] + 3;
                else candidate = advancedVisited[currentRow][currentCol] + 2;

                // 다음 위치가 dst 인가? -> 맞으면 방향까지 고려해서 최종 움직임 값을 계산합니다.
                if (nextRow == dst[0] && nextCol == dst[1]) {
                    int last = Math.abs(direction - dDir);

                    if (last == 0) candidate = candidate;
                    else if (last == 2) candidate += 2;
                    else candidate += 1;
                }

                // 현재까지 계산한 움직임이 advancedVisited 현재 좌표에 기록된 움직임보다 작다면 이 길을 지나고 있는 최선의 움직임이 됩니다.
                // (누군가가 먼저 지나갔다 하더라고 더 적은 움직임으로 현재 도달했으면 앞으로 목적지까지 더 적은 움직임으로 갈 수 있기 때문)
                // 따라서 더 효율적인 움직임들만 뽑아 다음 경로 탐색을 실시합니다.
                if (candidate < advancedVisited[nextRow][nextCol]) {
                    queue.add(new int[]{nextRow, nextCol});
                    advancedVisited[nextRow][nextCol] = candidate;  // 다음 이곳에 도착할 후보자를 위해 움직임의 수를 기록해놓습니다.
                    directionList[nextRow][nextCol] = direction;  // 최적의 방향을 기록합니다.
                }
            }

            /*

            // quque와 현재 상황 지도를 조회할 수 있는 코드입니다.
            for (int[] i : advancedVisited) {
                System.out.println(Arrays.toString(Arrays.stream(i).map(n -> n == Integer.MAX_VALUE ? 0 : n).toArray()).replace("-1", "x"));
            }

            System.out.print("queue: ");
            for (int[] q : queue) {
                System.out.print(Arrays.toString(q) + " ");
            }
            System.out.printf("%n%n");

            */
        }

        // 모든 탐색을 마치면 advancedVisited의 목표 지점의 값이 결국 최소 움직임 값이 되므로 해당 좌표 값을 리턴합니다.
        return advancedVisited[dst[0]][dst[1]];
    }
}



