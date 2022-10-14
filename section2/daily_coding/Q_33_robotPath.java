package section2.daily_coding;

/*

# **robotPath**

## **문제**

세로와 가로의 길이가 각각 M, N인 방의 지도가 2차원 배열로 주어졌을 때, `1`은 장애물을 의미하고 `0` 이동이 가능한 통로를 의미합니다.
로봇은 지도 위를 일분에 한 칸씩 상하좌우로 이동할 수 있습니다. 로봇의 위치와 목표 지점이 함께 주어질 경우,
로봇이 목표 지점까지 도달하는 데 걸리는 최소 시간을 리턴해야 합니다.

## **입력**

### **인자 1 : room**

- `int` 타입을 요소로 가지는 배열을 요소로 갖는 배열
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

### **인자 3 : dst**

- `int` 타입을 요소로 갖는 배열
- `dst.length`는 2
- `dst[i]`는 0 이상의 정수
- `dst`의 요소는 차례대로 좌표평면 위의 y좌표, x좌표

## **출력**

- `int` 타입을 리턴해야 합니다.

## **주의사항**

- M, N은 20 이하의 자연수입니다.
- `src`, `dst`는 항상 로봇이 지나갈 수 있는 통로입니다.
- `src`에서 `dst`로 가는 경로가 항상 존재합니다.

## **입출력 예시**

```
int[][] room = new int[]{
    {0, 0, 0, 0, 0, 0},
    {0, 1, 1, 0, 1, 0},
    {0, 1, 0, 0, 0, 0},
    {0, 0, 1, 1, 1, 0},
    {1, 0, 0, 0, 0, 0}
};
int[] src = new int[]{4, 2};
int[] dst = new int[]{2, 2};
int output = robotPath(room, src, dst);
System.out.println(output); // --> 8
```
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q_33_robotPath {
    public static void main(String[] args) {
        // write test case here
        Q_33_robotPath coplit = new Q_33_robotPath();

        int[][] room = new int[][]{
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 0}
        };

        int[] src = new int[]{4, 2};
        int[] dst = new int[]{2, 2};
        int output = coplit.robotPath(room, src, dst);
        System.out.println(output); // --> 8

    }

    public int robotPath(int[][] room, int[] src, int[] dst) {
        /*
         BFS 를 통한 완전탐색.
         갈 수 있는 방향으로 모두 가보고 거기가 목적지인가를 확인 후 목적지가 아니라면,
         그 지점에서 또 갈 수 있는 방향을 모두 탐색해보면서 목적지에 도달할때까지 반복 탐색 합니다.

         현재 위치에서 갈 수 있는 모든 방향을 담는다.
         담는 형식은 [row, col, cnt] (cnt 는 이 경로로 얼만큼 움직였는지 세고, 도착지점에 왔을 때 return 되는 값)

         도착지점이라면 return cnt,
         도착지점이 아니라면 꺼낸 좌표에서 상하좌우의 요소값을 큐에 계속 담는다.
         */

        // 탐색 지도 copy
        int[][] visited = new int[room.length][room[0].length];
        for (int i = 0; i < visited.length; i++) {
            // 막혀있는 부분도 가지 못하는 곳이기 때문에 1로 똑같이 복사함으로써 이후 방문하지 못하게 한다.
            System.arraycopy(room[i], 0, visited[i], 0, room[0].length);
        }

        // queue 를 통해 BFS
        Queue<int[]> queue = new LinkedList<>();

        // 시작점을 방문한 것으로 표시하고 큐에 add
        visited[src[0]][src[1]] = 1;
        src = Arrays.copyOf(src, src.length + 1);  // 3번째 요소는 얼만큼 이동했는지 카운트하는 요소
        queue.add(src);

        while (queue.size() != 0) {
            int[] current = queue.poll();

            // 현재 위치가 dst 인가?
            if (current[0] == dst[0] && current[1] == dst[1]) {
                return current[2];
            }

            // 위로 갈 수 있는 길이 있는가?
            if (current[0] - 1 >= 0 && current[0] < visited.length && visited[current[0] - 1][current[1]] != 1) {
                visited[current[0] - 1][current[1]] = 1;
                queue.add(new int[]{current[0] - 1, current[1], current[2] + 1});
            }
            // 아래로 갈 수 있는 길이 있는가?
            if (current[0] + 1 >= 0 && current[0] + 1 < visited.length && visited[current[0] + 1][current[1]] != 1) {
                visited[current[0] + 1][current[1]] = 1;
                queue.add(new int[]{current[0] + 1, current[1], current[2] + 1});
            }
            // 왼쪽으로 갈 수 있는 길이 있는가?
            if (current[1] - 1 >= 0 && current[1] - 1 < visited[0].length && visited[current[0]][current[1] - 1] != 1) {
                visited[current[0]][current[1] - 1] = 1;
                queue.add(new int[]{current[0], current[1] - 1, current[2] + 1});
            }
            // 오른쪽으로 갈 수 있는 길이 있는가?
            if (current[1] + 1 >= 0 && current[1] + 1 < visited[0].length && visited[current[0]][current[1] + 1] != 1) {
                visited[current[0]][current[1] + 1] = 1;
                queue.add(new int[]{current[0], current[1] + 1, current[2] + 1});
            }
        }
        return -1;  // 갈 수 없는 통로라면 -1을 return
    }
}
