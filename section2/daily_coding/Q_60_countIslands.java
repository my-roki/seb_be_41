package section2.daily_coding;

/*
# **countIslands**

## **문제**

세로와 가로의 길이가 각각 R, M인 2차원 R X M 배열 `grid`가 주어졌을 때, `'1'`은 땅을 의미하고 `'0'` 은 물을 의미합니다.
주어진 2차원 배열에 존재하는 섬의 개수를 리턴해야 합니다.

## **입력**

### **인자 1 : grid**

- 세로와 가로의 길이가 각각 R, M인 2차원 배열
- `arr.length`는 R
- `arr[i].length`는 M
- `arr[i][j]`는 '0' 또는 '1'

## **출력**

- `int` 타입을 리턴해야 합니다.

## **주의사항**

- `섬`이란 물로 둘러싸여 있는 땅을 말합니다.
- 가로 혹은 세로로 땅이 연결되어 있는 경우 하나의 섬으로 간주합니다.
- 2차원 배열의 범위 밖은 물로 둘러싸여 있다고 가정합니다.

## **입출력 예시**

```
char[][] grid = new char[][]{
  {'0', '1', '1', '1'},
  {'0', '1', '1', '1'},
  {'1', '1', '0', '0'},
};
int result = countIslands(grid);
System.out.println(result); // --> 1

grid = new char[][]{
  {'0', '1', '1', '1', '0'},
  {'0', '1', '0', '0', '0'},
  {'0', '0', '0', '1', '0'},
  {'1', '1', '0', '1', '0'},
  {'1', '1', '0', '1', '0'}
};
result = countIslands(grid);
System.out.println(result); // --> 3
```
 */

public class Q_60_countIslands {
    public static void main(String[] args) {
        // write test case here
        Q_60_countIslands coplit = new Q_60_countIslands();
        char[][] grid = new char[][]{
                {'0', '1', '1', '1'},
                {'0', '1', '1', '1'},
                {'1', '1', '0', '0'},
        };
        int result = coplit.countIslands(grid);
        System.out.println(result); // --> 1

        grid = new char[][]{
                {'0', '1', '1', '1', '0'},
                {'0', '1', '0', '0', '0'},
                {'0', '0', '0', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '1', '0'}
        };
        result = coplit.countIslands(grid);
        System.out.println(result); // --> 3

    }

    public int countIslands(char[][] grid) {
        /*
        dfs를 이용한 풀이 -> 재귀
        섬이 연결되있는 조건 : 상하좌우로 '1'이 이어져야 있어야 합니다.
        따라서 어떤 한 점에서 상하좌우 모두 연결이 끊어지면 그것은 독립된 섬 1개입니다.
         */
        int output = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                // 현재 좌표가 '0' 이라는 뜻은 애초에 물이었던가
                // 이전 좌표들의 탐색으로 인해 이미 지나간 자리이기 때문에 해당 좌표에서 섬 탐색(?)을 하지 않습니다.
                if (grid[row][col] == '0') continue;

                recursion(row, col, grid);  // 해당 좌표를 기준으로 섬 탐색을 시작합니다.
                output += 1;  // 섬 탐색이 종료되었다는 것읕 1개의 섬을 다 돌았다는 의미이므로 섬 개수 +1
            }
        }

        return output;
    }

    public void recursion(int row, int col, char[][] grid) {
        // 점의 범위 초과
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) return;

        // 상하좌우로 한 칸 이동한 좌표가 '1'(땅)이 아니면 종료
        if (grid[row][col] == '0') return;

        // 상하좌우로 한 칸 이동한 좌표가 땅이면 그 좌표를 기준으로 다시 상하좌우의 점이 땅인지 확인
        grid[row][col] = '0';
        recursion(row - 1, col, grid);
        recursion(row + 1, col, grid);
        recursion(row, col - 1, grid);
        recursion(row, col + 1, grid);
    }
}