package section2.data_structure.coplit_data_structure;

/*
인접 행렬 길찾기
문제
주어진 인접행렬에서 한 정점으로부터 다른 정점으로 이어지는 길이 존재하는지 반환해야 합니다.

입력
인자 1: matrix
Array 타입을 요소로 갖는 인접 행렬이 담긴 2차원 배열
인자 2: from
int 타입의 시작 정점
인자 3: to
int 타입의 도착 정점

출력
boolean 타입을 리턴해야 합니다.

입출력 예시
boolean result = getDirections(new int[][]
	{
		{0, 1, 0, 0},
		{0, 0, 1, 0},
		{0, 0, 0, 1},
		{0, 1, 0, 0}
  },
	0,
	2
);
System.out.println(result); // true
// 정점 0에서 2로 가는 길이 존재하는지 확인합니다.
// 0 --> 1 로 가는 간선이 존재하고, 1 --> 2 로 가는 간선이 존재하기 때문에 true를 반환합니다.

boolean result2 = getDirections(new int[][]
	{
		{0, 1, 0, 0, 0},
		{0, 0, 0, 1, 0},
		{0, 1, 0, 0, 0},
		{0, 1, 1, 0, 0},
		{1, 1, 1, 1, 0}
	},
	1,
	4
);
System.out.println(result); // false
// 정점 1에서 4로 가는 길이 존재하는지 확인합니다.
// 1 --> 3,
// 3 --> 1 (정점 1을 다녀왔으니 다시 돌아가지 않습니다),
// 3 --> 2,
// 2 --> 1 (정점 1을 다녀왔으니 다시 돌아가지 않습니다)
// ...으로, 4에 도달할 수 없습니다.
 */

import java.util.LinkedList;
import java.util.Queue;

public class Q_11_getDirections {
    public static void main(String[] args) {
        // write test case here
        Q_11_getDirections coplit = new Q_11_getDirections();
        boolean result = coplit.getDirections(new int[][]{{0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}, {0, 1, 0, 0}}, 0, 2);
        System.out.println(result); // true
        boolean result2 = coplit.getDirections(new int[][]{{0, 1, 0, 0, 0}, {0, 0, 0, 1, 0}, {0, 1, 0, 0, 0}, {0, 1, 1, 0, 0}, {1, 1, 1, 1, 0}}, 1, 4);
        System.out.println(result2); // false
    }

    public boolean getDirections(int[][] matrix, int from, int to) {
//        return dfs_getDirection(matrix, from, to);
        return bfs_getDirection(matrix, from, to);

    }

    public boolean dfs_getDirection(int[][] matrix, int from, int to) {
        int[][] newMatrix = new int[matrix.length][];
        for (int idx = 0; idx < matrix.length; idx++) {
            newMatrix[idx] = matrix[idx].clone();
        }

        // base case
        if (newMatrix[from][to] == 1) return true;

        // recursive case
        boolean result = false;
        for (int i = 0; i < newMatrix[from].length; i++) {
            if (newMatrix[from][i] != 0) {
                newMatrix[from][i] = 0; // 무한루프를 방지하기 위해 지나왔던 길은 다시 오지 않습니다.
                result = getDirections(newMatrix, i, to);
            }
            if (result) break;
        }
        return result;
    }

    public boolean bfs_getDirection(int[][] matrix, int from, int to){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(from);
        boolean[] isVisited = new boolean[matrix.length];

        isVisited[from] = true;
        while (!queue.isEmpty()) {
            int curFrom = queue.poll();

            if (matrix[curFrom][to] == 1) return true;
            for (int i =0; i < matrix[curFrom].length; i++) {
                if (matrix[curFrom][i] != 0 && !isVisited[i]) {
                    queue.add(i);
                    isVisited[i] = true;
                }
            }
        }
        return false;
    }
}

