package section2.daily_coding;

/*
# **gossipProtocol**

## **문제**

세로와 가로의 길이가 각각 M, N인 마을지도가 배열로 주어졌을 때, `'1'`은 주민이 있는 집을 의미하고 `'0'`은 주민이 없는 땅을 의미합니다.
이 마을은 소문이 시작되면 하루에 상하좌우 한 칸 바로 옆에 있는 집으로 퍼집니다. 특정 주민의 집 (R, C)으로부터 어떤 소문이 시작될 경우,
마을 전체로 소문이 퍼지는데 걸리는 시간(일)을 리턴해야 합니다.

## **입력**

### **인자 1 : village**

- `String` 타입을 요소로 갖는 배열
- `village.length`는 M
- `village[i]`는 `String` 타입
- `village[i].length`는 N
- `village[i][j]`는 세로로 i, 가로로 j인 지점의 정보를 의미
- `village[i][j]`는 `'0'` 또는 `'1'`

### **인자 2: row**

- `int` 타입의 0 이상의 정수
- 소문이 시작되는 집의 세로 위치

### **인자 3: col**

- `int` 타입의 0 이상의 정수
- 소문이 시작되는 집의 가로 위치

## **출력**

- `int` 타입을 리턴해야 합니다.

## **주의사항**

- M, N은 100 이하의 자연수입니다.
- `row`, `col`에는 항상 주민이 살고 있습니다.
- 모든 집은 연결되어 있습니다. 즉, 한 집에서 다른 집으로 가는 경로가 항상 존재합니다.
- village를 그래프로 구현하는 함수가 주어집니다.

## **입출력 예시**

```
String[] village = new String[]{
  "0101", // 첫 번째 줄
  "0111",
  "0110",
  "0100"
};

int row = 1;
int col = 2;
int output = gossipProtocol(village, row, col);
System.out.println(output); // --> 3

// 1. 시작: (1, 2)에서 시작, 소문이 퍼진 곳을 x로 표기
//  [
//   "0101",
//   "01x1",
//   "0110",
//   "0100",
//  ]
//
// 2. 1일 뒤
//  [
//   "0101",
//   "0xxx",
//   "01x0",
//   "0100",
//  ]
//
// 3. 2일 뒤
//  [
//   "0x0x",
//   "0xxx",
//   "0xx0",
//   "0100",
//  ]
//
// 4. 3일 뒤: 소문이 전부 퍼짐 (끝)
//  [
//   "0x0x",
//   "0xxx",
//   "0xx0",
//   "0x00",
//  ]
```
 */

import java.util.LinkedList;
import java.util.Queue;

public class Q_55_gossipProtocol {
    public static void main(String[] args) {
        // write test case here
        Q_55_gossipProtocol coplit = new Q_55_gossipProtocol();
        String[] village = new String[]{
                "0101", // 첫 번째 줄
                "0111",
                "0110",
                "0100"
        };

        int row = 1;
        int col = 2;
        int output = coplit.gossipProtocol(village, row, col);
        System.out.println(output); // --> 3

    }

    public int gossipProtocol(String[] village, int row, int col) {
        // dfs를 통해 문제 해결
        // 원본 배열을 탐색이 용이하도록 가공
        String[][] matrix = new String[village.length][];
        for (int i = 0; i < village.length; i++) {
            String str = village[i];
            String[] split = str.split("");
            matrix[i] = split;
        }

        // 방향에 따른 움직임
        int[][] MOVES = new int[][]{
                {-1, 0},  // UP
                {1, 0},   // DOWN
                {0, 1},   // RIGHT
                {0, -1}   // LEFT
        };

        int height = village.length;
        int width = village[0].length();

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col, 0});
        int output = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentColumn = current[1];
            int currentCnt = current[2];

            for (int[] move : MOVES) {
                int rDiff = move[0];
                int cDiff = move[1];
                int nextRow = currentRow + rDiff;
                int nextCol = currentColumn + cDiff;
                if (isValid(nextRow, nextCol, height, width) && matrix[nextRow][nextCol].equals("1")) {
                    matrix[nextRow][nextCol] = "x";  // 소문이 퍼진 곳 표시
                    queue.add(new int[]{nextRow, nextCol, currentCnt + 1});
                    output = Math.max(currentCnt + 1, output);
                }
            }
        }
        return output;
    }

    public boolean isValid(int row, int column, int width, int height) {
        return row >= 0 && row < width && column >= 0 && column < height;
    }
}
