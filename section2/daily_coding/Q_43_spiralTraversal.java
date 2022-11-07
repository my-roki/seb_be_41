package section2.daily_coding;

/*
# **spiralTraversal**

## **문제**

2차원 M x N 배열을 나선형(spiral)으로 순회해야 합니다.

## **입력**

### **인자 1 : matrix**

- 세로 길이(`matrix.length`)가 M, 가로 길이(`matrix[i].length`)가 N인 2차원 배열
- `matrix[i]`는 `Character` 타입을 요소로 갖는 배열
- `matrix[i][j].length`는 1

## **출력**

- `String` 타입을 리턴해야 합니다.

## **주의사항**

- 순회는 좌측 상단 (0,0)에서 시작합니다.
- 배열의 모든 요소를 순서대로 이어붙인 문자열을 리턴해야 합니다.

## **입출력 예시**

```
Character[][] matrix = new Character[][]{
  {'A', 'B', 'C'},
  {'D', 'E', 'F'},
  {'G', 'H', 'I'},
};
String output = spiralTraversal(matrix);
System.out.println(output); // --> "ABCFIHGDE"

matrix = new Character[][]{
  {'T', 'y', 'r', 'i'},
  {'i', 's', 't', 'o'},
  {'n', 'r', 'e', 'n'},
  {'n', 'a', 'L', ' '},
};
output = spiralTraversal(matrix);
System.out.println(output); // --> 'Tyrion Lannister'
```
 */

public class Q_43_spiralTraversal {
    public static void main(String[] args) {
        // write test case here
        Q_43_spiralTraversal coplit = new Q_43_spiralTraversal();

        Character[][] matrix = new Character[][]{
                {'A', 'B', 'C'},
                {'D', 'E', 'F'},
                {'G', 'H', 'I'},
        };
        String output = coplit.spiralTraversal(matrix);
        System.out.println(output); // --> "ABCFIHGDE"

        matrix = new Character[][]{
                {'T', 'y', 'r', 'i'},
                {'i', 's', 't', 'o'},
                {'n', 'r', 'e', 'n'},
                {'n', 'a', 'L', ' '},
        };
        output = coplit.spiralTraversal(matrix);
        System.out.println(output); // --> 'Tyrion Lannister'

    }

    public String spiralTraversal(Character[][] matrix) {
        // 지나온 자리를 기록할 배열
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        // 지난 자리의 문자열을 담을 빌더
        StringBuilder stringBuilder = new StringBuilder();

        // 시계방향으로 이동해서 문자를 집어넣으면 됨(모든 자리를 지나면 종료)
        // 벽에 닿거나, 지나갔던 길을 만나면 전 자리로 돌아가 방행 전환
        // 매 행위마다 지나온 자리 체크 후 문자를 빌더에 넣는다
        int direction = 0;
        int row = 0, col = 0;
        int count = matrix.length * matrix[0].length;
        while (count != 0) {
            // 지나온 자리를 체크하고, 빌더에 문자열을 추가합니다.
            visited[row][col] = true;
            stringBuilder.append(matrix[row][col]);

            // 방향 케이스에 따라 다음 요소로 이동하는 경우가 달라짐
            switch (direction) {
                // 오른쪽으로 이동
                case 0:
                    col += 1;
                    if (col == matrix[0].length || visited[row][col]) {
                        row++;
                        col--;
                        direction = 1;
                    }
                    break;
                // 아래로 이동
                case 1:
                    row += 1;
                    if (row == matrix.length || visited[row][col]) {
                        row--;
                        col--;
                        direction = 2;
                    }
                    break;
                // 왼쪽으로 이동
                case 2:
                    col -= 1;
                    if (col == -1 || visited[row][col]) {
                        row--;
                        col++;
                        direction = 3;
                    }
                    break;
                // 위로 이동
                case 3:
                    row -= 1;
                    if (row == 0 || visited[row][col]) {
                        row++;
                        col++;
                        direction = 0;
                    }
                    break;
            }
            count--;
        }
        return stringBuilder.toString();
    }
}