package section2.daily_coding;

/*
# **rotateMatrix**

## **문제**

2차원 N x N 배열을 시계 방향으로 90도 회전시킨 배열을 리턴해야 합니다.

## **입력**

### **인자 1 : matrix**

- 가로 길이(`matrix[i].length`)와 세로 길이(`matrix.length`)가 모두 N인 2차원 배열
- `matrix[i][j]`는 `int` 타입
- 빈 배열일 경우 matrix == null

### **인자 2 : K**

- `int` 타입
- 배열의 회전 수

## **출력**

- 2차원 배열을 리턴해야 합니다.

## **입출력 예시**

```
int[][] matrix = new int[]{
  {1, 2, 3, 4},
  {5, 6, 7, 8},
  {9, 10, 11, 12},
  {13, 14, 15, 16}
}
int K = 1;

System.out.println(matrix[0][0]); // --> 1
System.out.println(matrix[3][2]); // --> 15

int[][] rotatedMatrix = rotateMatrix(matrix, K);
System.out.println(rotatedMatrix[0][0]); // --> 13
System.out.println(rotatedMatrix[3][2]); // --> 8
```

이때 `matrix[i][j]`는 '행(세로축)을 기준으로 i만큼 아래에 있고 열(가로축)을 기준으로 j만큼 옆에 있다.`를 뜻합니다.
이 방식은 기하학에서 좌표 평면 위의 한 점을 나타낼 때 (x, y), 즉 가로축을 먼저 표기하고 세로축을 다음에 표기하는 방식과는 다릅니다.
그래프를 인접행렬로 구현할 때, 이 점을 주의하셔야 합니다.

## **Advanced**

- 세로와 가로의 길이가 각각 M, N인 2차원 M X N 배열을 시계방향으로 90도씩 K번 회전시킨 배열을 리턴해 보세요. 회전수가 두 번째 입력으로 주어집니다
 */

public class Q_34_rotateMatrix {
    public static void main(String[] args) {
        // write test case here
        Q_34_rotateMatrix coplit = new Q_34_rotateMatrix();

        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int K = 1;

        System.out.println(matrix[0][0]); // --> 1
        System.out.println(matrix[3][2]); // --> 15

        int[][] rotatedMatrix = coplit.rotateMatrix(matrix, K);
        System.out.println(rotatedMatrix[0][0]); // --> 13
        System.out.println(rotatedMatrix[3][2]); // --> 8
    }

    public int[][] rotateMatrix(int[][] matrix, int K) {
        if (matrix == null) return null;

        // 완전하게 한번 돌가가는 경우
        if (K % 4 == 0) return matrix;

        // 홀수번 돌아가면 matrix 의 행과 열의 길이가 바뀌고
        // 짝수번 돌아가면 행과 열의 길이는 그대로 유지된다.
        int[][] output;
        if (K % 2 == 1) output = new int[matrix[0].length][matrix.length];
        else output = new int[matrix.length][matrix[0].length];

        // 회전 작업
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[i].length; j++) {

                if (K % 4 == 1) output[i][j] = matrix[matrix.length - (1 + j)][i];
                else if (K % 4 == 2) output[i][j] = matrix[matrix.length - (1 + i)][matrix[0].length - (j + 1)];
                else output[i][j] = matrix[j][matrix[0].length - (1 + i)];
            }
        }
        return output;
    }

}

