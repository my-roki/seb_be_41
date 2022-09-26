package section2.data_structure.coplit_data_structure;

/*
인접 행렬 생성하기
문제
방향이 있는 간선과 방향이 없는 간선들의 목록들을 받아 2차원 배열의 인접행렬을 반환하는 함수를 작성하세요.

조건
각 간선은 3가지 정보를 담고 있습니다.
- 0번째: 간선의 시작 정점 (0 이상의 정수)
- 1번째: 간선의 도착 정점 (0 이상의 정수)
- 2번째: 방향성 (1 == 일시 무향, 0 == 일시 방향)

입력
인자 1: edges
int 타입의 방향/무향인 간선들의 목록이 담긴 배열

출력
Array 타입을 리턴해야 합니다.
2차원 배열의 인접 행렬

주의 사항
정점 0에서 정점 4로 이어주는 간선이 존재할 경우 정점 1, 2, 3도 존재합니다.
반환하는 인접행렬은 2차원 배열이며, 행(row)는 바깥 배열, 열(column)은 안쪽 배열입니다.
    int[][] matrix = new int[][]{{0, 0}, {0, 0}}
    matrix[0] == 0번째 행
    matrix[0][0] == 0번째 행의 0번째 열
두 정점간의 간선의 유무는 0과 1로 표시합니다.
    0: 두 정점간에 간선이 존재하지 않을 경우
    1: 두 정점간에 간선이 존재할 경우
아래의 2차원 배열에서 세로축은 시작 정점, 가로축은 도착 정점입니다.
음수는 올 수 없습니다.
self loop 없습니다.
int[][] matrix = new int[][]{
	{0, 0, 0},
	{0, 0, 0},
	{0, 0, 0},
};

입출력 예시
int[][] output1 = createMatrix(new int[][]{
	{0, 3, 0},
	{0, 2, 0},
	{1, 3, 0},
	{2, 1, 0},
});

System.out.println(output1);

// [
//  [0, 0, 1, 1],
//  [0, 0, 0, 1],
//  [0, 1, 0, 0],
//  [0, 0, 0, 0]
// ]

int[][] output2 = createMatrix(new int[][]{
        {0, 2, 0},
        {2, 4, 1},
        {1, 3, 1},
        {2, 1, 0},
        });

        System.out.println(output2);

// [
//  [0, 0, 1, 0, 0],
//  [0, 0, 0, 1, 0],
//  [0, 1, 0, 0, 1],
//  [0, 1, 0, 0, 0],
//  [0, 0, 1, 0, 0],
// ]
 */

import java.util.Arrays;

public class Q_10_createMatrix {
    public static void main(String[] args) {
        // write test case here
        Q_10_createMatrix coplit = new Q_10_createMatrix();
        int[][] output1 = coplit.createMatrix(new int[][]{
                {0, 3, 0},
                {0, 2, 0},
                {1, 3, 0},
                {2, 1, 0},});
        System.out.println(Arrays.deepToString(output1));
        // [
        //  [0, 0, 1, 1],
        //  [0, 0, 0, 1],
        //  [0, 1, 0, 0],
        //  [0, 0, 0, 0]
        // ]

        int[][] output2 = coplit.createMatrix(new int[][]{
                {0, 2, 0},
                {2, 4, 1},
                {1, 3, 1},
                {2, 1, 0},
        });
        System.out.println(Arrays.deepToString(output2));
        // [
        //  [0, 0, 1, 0, 0],
        //  [0, 0, 0, 1, 0],
        //  [0, 1, 0, 0, 1],
        //  [0, 1, 0, 0, 0],
        //  [0, 0, 1, 0, 0],
        // ]

    }

    public int[][] createMatrix(int[][] edges) {
        int maxVertex = 0;
        for (int[] edge : edges) {
            if (edge[0] > maxVertex) maxVertex = edge[0];
            if (edge[1] > maxVertex) maxVertex = edge[1];
        }

        int[][] output = new int[maxVertex + 1][maxVertex + 1];
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int direction = edge[2];
            output[from][to] = 1;
            if (direction == 1) output[to][from] = 1;
        }
        return output;
    }
}

