package section2.data_structure.coplit_data_structure;

/*
박스 포장
문제
마트에서 장을 보고 박스를 포장하려고 합니다. 박스를 포장하는 데는 폭이 너무 좁습니다.
그렇기에 한 줄로 서 있어야 하고, 들어온 순서대로 한 명씩 나가야 합니다.

불행 중 다행은, 인원에 맞게 포장할 수 있는 기구들이 놓여 있어, 모두가 포장을 할 수 있다는 것입니다.
짐이 많은 사람은 짐이 적은 사람보다 포장하는 시간이 길 수밖에 없습니다.

뒷사람이 포장을 전부 끝냈어도 앞사람이 끝내지 못하면 기다려야 합니다. 앞사람이 포장을 끝내면,
포장을 마친 뒷사람들과 함께 한 번에 나가게 됩니다.

만약, 앞사람의 박스는 5 개고, 뒷사람 1의 박스는 4 개, 뒷사람 2의 박스는 8 개라고 가정했을 때,
뒷사람 1이 제일 먼저 박스 포장을 끝내게 되어도 앞사람 1의 포장이 마칠 때까지 기다렸다가 같이 나가게 됩니다.

이때, 통틀어 최대 몇 명이 한꺼번에 나가는지 알 수 있도록 함수를 구현해 주세요.

입력
인자 1 : boxes
int 타입을 요소로 갖는, 포장해야 하는 박스가 담긴 배열
1 ≤ 사람 수 ≤ 10,000
1 ≤ 박스 ≤ 10,000

출력
int 타입을 리턴해야 합니다.

주의 사항
먼저 포장을 전부 끝낸 사람이 있더라도, 앞사람이 포장을 끝내지 않았다면 나갈 수 없습니다.

예시
만약 5, 1, 4, 6이라는 배열이 왔을 때, 5개의 박스를 포장하는 동안 1, 4 개의 박스는 포장을 끝내고 기다리게 되고,
6 개의 박스는 포장이 진행 중이기 때문에, 5, 1, 4 세 개가 같이 나가고, 6이 따로 나가게 됩니다.
그렇기에 최대 3 명이 같이 나가게 됩니다.

int[] boxes = new int[]{5, 1, 4, 6};
int output = paveBox(boxes);
System.out.println(output); // 3

int[] boxes2 = new int[]{1, 5, 7, 9};
int output2 = paveBox(boxes);
System.out.println(output2); // 1
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Q_04_paveBox {
    public static void main(String[] args) {
        // write test case here
        Q_04_paveBox coplit = new Q_04_paveBox();
        Integer[] boxes1 = new Integer[]{5, 1, 4, 6};
        int output1 = coplit.paveBox(boxes1);
        System.out.println(output1); // 3

        Integer[] boxes2 = new Integer[]{1, 5, 7, 9};
        int output2 = coplit.paveBox(boxes2);
        System.out.println(output2); // 1

        Integer[] boxes3 = new Integer[]{1, 5, 7, 4, 4, 9, 1, 1, 1, 1, 1};
        int output3 = coplit.paveBox(boxes3);
        System.out.println(output3); // 6

    }

    public int paveBox(Integer[] boxes) {
        ArrayList<Integer> groups = new ArrayList<>();  // 나가는 사람 그룹을 담을 ArrayList
        int cnt = 0;
        int target = boxes[0];
        for (int i = 0; i < boxes.length; i++) {
            int candidate = boxes[i];
            if (target >= candidate) {  // 뒷사람의 상자수가 더 작으면 같이 나갈 수 있습니다.
                cnt++;
            } else {  // 뒷사람의 상자수가 더 많으면 (뒷사람을 포함한)1부터 다시 시작
                groups.add(cnt);
                target = boxes[i];
                cnt = 1;
            }
            if (i == boxes.length -1) groups.add(cnt); // 마지막 사람은 결국 나가니 그룹에 추가해줍니다.
        }
        int output = groups.stream().max(Integer::compareTo).orElse(0);
        return output;
    }
}
