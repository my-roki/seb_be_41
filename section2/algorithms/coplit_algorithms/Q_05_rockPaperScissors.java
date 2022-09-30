package section2.algorithms.coplit_algorithms;

/*
rockPaperScissors
문제
가위바위보 게임은 2인 이상의 사람이 동시에 '가위, 바위, 보'를 외치고 동시에 가위,
바위 또는 보 중에서 한 가지를 의미하는 손 모양을 내밀어 승부를 결정짓는 게임입니다.
세 판의 가위바위보 게임을 할 경우, 한 사람은 세 번의 선택(예. 가위, 가위, 보)을 할 수 있습니다.
입력받은 rounds만큼의 선택으로 가능한 모든 경우의 수를 구하는 함수를 작성합니다.

입력
int타입의 게임 횟수 rounds

출력
ArrayList<String[]>타입을 리턴해야 합니다.
ArrayList가 담고있는 배열은 전체 경우의 수 중 한 가지 경우(총 세 번의 선택)를 의미하는 배열입니다.
String[]은 'rock', 'paper', 'scissors' 중 한 가지 이상을 요소로 갖는 배열입니다.

주의사항
최종적으로 리턴되는 배열의 순서는 가중치 적용 정렬(Weighted Sort)을 따릅니다.
중요도는 'rock', 'paper', 'scissors' 순으로 높습니다.
쉽게 생각해 올림픽 순위 결정 방식을 참고하면 됩니다.
금메달('rock')이 은메달('paper')보다 우선하고, 은메달('paper')이 동메달('scissors')보다 우선합니다.

입출력 예시
ArrayList<String[]> output = rockPaperScissors(5);

System.out.println(output);

//    [
//      ["rock", "rock", "rock", "rock", "rock"],
//      ["rock", "rock", , "rock", "rock", "paper"],
//      ["rock", "rock", , "rock", "rock", "scissors"],
//      ["rock", "rock", "rock", "paper", "rock"],
//      ["rock", "rock", "rock", "paper", "paper"],
//      ["rock", "rock", "rock", "paper", "scissors"],
//      ["rock", "rock", "rock", "scissors", "rock"],
//      // ...etc ...
//    ]

 */

import java.util.ArrayList;
import java.util.Arrays;

public class Q_05_rockPaperScissors {
    public static void main(String[] args) {
        // write test case here
        Q_05_rockPaperScissors coplit = new Q_05_rockPaperScissors();
        ArrayList<String[]> output = coplit.rockPaperScissors(5);

        System.out.println(output);
        /*
        [
          ["rock", "rock", "rock", "rock", "rock"],
          ["rock", "rock", , "rock", "rock", "paper"],
          ["rock", "rock", , "rock", "rock", "scissors"],
          ["rock", "rock", "rock", "paper", "rock"],
          ["rock", "rock", "rock", "paper", "paper"],
          ["rock", "rock", "rock", "paper", "scissors"],
          ["rock", "rock", "rock", "scissors", "rock"],
          // ...etc ...
        ]
        */
    }

    public ArrayList<String[]> rockPaperScissors(int rounds) {
        ArrayList<String[]> output = new ArrayList<>();
        return recursion(rounds, new String[]{}, output);
    }

    public ArrayList<String[]> recursion(int round, String[] bucket, ArrayList<String[]> output) {
        if (round == 0) {
            output.add(bucket);
            return output;
        }

        String[] rcp = new String[]{"rock", "paper", "scissors"};
        for (String item : rcp) {
            String[] newBucket = Arrays.copyOf(bucket, bucket.length + 1);
            newBucket[newBucket.length - 1] = item;
            output = recursion(round - 1, newBucket, output);
        }
        return output;
    }
}




