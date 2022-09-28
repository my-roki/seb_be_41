package section2.algorithms.coplit_algorithms;

/*
보드 게임
문제
N * N의 크기를 가진 보드판 위에서 게임을 하려고 합니다. 게임의 룰은 다음과 같습니다.
  1. 좌표 왼쪽 상단(0, 0)에 말을 놓는다.
  2. 말은 상, 하, 좌, 우로 이동할 수 있고, 플레이어가 조작할 수 있다.
  3. 조작의 기회는 딱 한 번 주어진다.
  4. 조작할 때 U, D, L, R은 각각 상, 하, 좌, 우를 의미하며 한 줄에 띄어쓰기 없이 써야 한다.
     예시: UDDLLRRDRR, RRRRR
  5. 한 번 움직일 때마다 한 칸씩 움직이게 되며, 그 칸 안의 요소인 숫자를 획득할 수 있다.
  6. 방문한 곳을 또 방문해도 숫자를 획득할 수 있다.
  7. 보드 밖을 나간 말은 OUT 처리가 된다.
  8. 칸 안의 숫자는 0 또는 1이다.
     단, 좌표 왼쪽 상단(0, 0)은 항상 0이다.
  9. 획득한 숫자를 합산하여 숫자가 제일 큰 사람이 이기게 된다.

보드판이 담긴 board와 조작하려고 하는 문자열 operation이 주어질 때, 말이 해당 칸을 지나가면서 획득한 숫자의 합을 구하는 함수를 작성하세요.

입력
인자 1: board
- int 타입의 2차원 배열
- 2 <= board.length <= 1,000
- 예: [ [0, 0, 1], [1, 0, 1], [1, 1, 1] ]
인자 2: operation
- string 타입의 대문자 영어가 쓰여진 문자열
- 1 <= operation.length <= board.length * 2
- U, L, D, R 이외의 문자열은 없습니다.

출력
int 타입을 반환해야 합니다.
board와 operation이 입력값의 예시
([ [0, 0, 1], [1, 0, 1], [1, 1, 1] ], DDR)일 때, (0, 0) -> (1, 0) -> (2, 0) -> (2, 1) 순서로 이동하게 되고,
각 0, 1, 1, 1을 얻어 3을 반환합니다.

주의사항
만약, 말이 보드 밖으로 나갔다면 즉시 null 을 반환합니다.

입출력 예시
int[][] board1 = new int[]{
  {0, 0, 0, 1},
  {1, 1, 1, 0},
  {1, 1, 0, 0},
  {0, 0, 0, 0}
}
int output1 = boardGame(board1, "RRDLLD");
System.out.println(output1); // 4


int[][] board2 = new int[]{
  {0, 0, 1},
  {1, 1, 1},
  {1, 0, 0}
}
int output2 = boardGame(board2, "UUUDD");
System.out.println(output2); // null

int[][] board3 = new int[][]{
  {0, 0, 0, 0, 0},
  {0, 0, 1, 0, 0},
  {0, 0, 0, 0, 0},
  {0, 0, 0, 1, 0},
  {0, 0, 0, 0, 0}
}
int output3 = boardGame(board3, "DDRRRUDUDUD");
System.out.println(output3); // 0
 */

public class Q_03_boardGame {
    public static void main(String[] args) {
        // write test case here
        Q_03_boardGame coplit = new Q_03_boardGame();

        int[][] board1 = new int[][]{
                {0, 0, 0, 1},
                {1, 1, 1, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 0}
        };
        Integer output1 = coplit.boardGame(board1, "RRDLLD");
        System.out.println(output1); // 4


        int[][] board2 = new int[][]{
                {0, 0, 1},
                {1, 1, 1},
                {1, 0, 0}
        };
        Integer output2 = coplit.boardGame(board2, "UUUDD");
        System.out.println(output2); // null

        int[][] board3 = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0}
        };
        Integer output3 = coplit.boardGame(board3, "DDRRRUDUDUD");
        System.out.println(output3); // 0
    }

    public Integer boardGame(int[][] board, String operation) {
        int[] currentPosition = new int[]{0, 0};
        int output = 0;
        for (int i = 0; i < operation.length(); i++) {
            // 말의 위치 이동
            switch (operation.charAt(i)) {
                case 'U':
                    currentPosition[0]--;
                    break;
                case 'D':
                    currentPosition[0]++;
                    break;
                case 'L':
                    currentPosition[1]--;
                    break;
                case 'R':
                    currentPosition[1]++;
                    break;
            }

            // 말이 보드를 빠져나갔을 경우 null 반환
            if (currentPosition[0] < 0 || currentPosition[0] >= board.length) return null;
            if (currentPosition[1] < 0 || currentPosition[1] >= board.length) return null;

            // 포인트 누적
            output += board[currentPosition[0]][currentPosition[1]];
        }
        return output;
    }
}

