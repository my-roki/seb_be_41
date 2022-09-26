package section2.data_structure.coplit_data_structure;

/*
연결된 정점들
문제
방향이 없는 간선들의 목록이 주어질 때, 연결된 정점의 컴포넌트(그룹들)가 몇 개인지 반환하는 함수를 작성하세요.

입력
인자 1: edges
2차원 Array 타입을 요소로 갖는 시작과 도착 정점이 담겨있는 배열들을 담고 있는 목록 (2차원 배열, 정수 요소)
ex) [[0, 1], [1, 2], [3, 4]]

출력
int 타입을 리턴해야 합니다.
연결된 정점의 컴포넌트의 수를 숫자로 반환합니다.

주의 사항
주어진 간선은 무향입니다.
[1, 2] 는 정점 1에서 정점 2로도 갈 수 있으며, 정점 2에서 정점 1로도 갈 수 있습니다.

입출력 예시
int result = connectedVertices(new int[][]{
	{0, 1},
	{2, 3},
	{4, 5},
});
System.out.println(result); // 3

int result = connectedVertices(new int[][]{
	{0, 1},
	{2, 3},
	{3, 4},
	{3, 5},
});
System.out.println(result); // 2
 */

import java.util.LinkedList;
import java.util.Queue;

public class Q_12_connectedVertices {
    public static void main(String[] args) {
        // write test case here
        Q_12_connectedVertices coplit = new Q_12_connectedVertices();
        int result = coplit.connectedVertices(new int[][]{{0, 1}, {2, 3}, {4, 5}});
        System.out.println(result); // 3

        result = coplit.connectedVertices(new int[][]{{0, 1}, {2, 3}, {3, 4}, {3, 5}, {2, 5}});
        System.out.println(result); // 2
    }

    public int connectedVertices(int[][] edges) {
        // 그래프 행렬을 만들기 위한 max vertex 찾습니다.
        int maxVertex = 0;
        for (int[] edge : edges) {
            if (edge[0] > maxVertex) maxVertex = edge[0];
            if (edge[1] > maxVertex) maxVertex = edge[1];
        }

        // 그래프 행렬을 만들어줍니다.
        int[][] newMatrix = new int[maxVertex + 1][maxVertex + 1];
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            newMatrix[from][to] = 1;
            newMatrix[to][from] = 1;
        }

        // 완전탐색 - 중복 탐색 방지를 위헤 이미 탐색한 행은 더이상 탐색하지 않도록 기록을 합니다.
        boolean[] visited = new boolean[maxVertex + 1];
        int result = 0;
        for (int row = 0; row < visited.length; row++) {
            if (visited[row]) continue;
            result += 1;
            // 탐색을 시작합니다.
            // bfs_array(newMatrix, row, visited);
            dfs_array(newMatrix, row, visited);
        }
        return result;
    }

    // Queue를 이용한 완전 탐색
    public boolean[] bfs_array(int[][] matrix, int row, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(row);
        visited[row] = true;

        while (!queue.isEmpty()) {
            int currRow = queue.poll();
            for (int i = 0; i < matrix[currRow].length; i++) {
                if (matrix[currRow][i] ==1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        return visited;
    }

    // Recursion을 이용한 완전 탐색
    public boolean[] dfs_array(int[][] matrix, int row, boolean[] visited) {
        visited[row] = true;
        for (int i=0; i < matrix.length; i++) {
            if (matrix[row][i] == 1 && !visited[i]) {
                dfs_array(matrix, i, visited);
            }
        }
        return visited;
    }
}
