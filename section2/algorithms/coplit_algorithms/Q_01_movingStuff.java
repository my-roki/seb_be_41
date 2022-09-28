package section2.algorithms.coplit_algorithms;

/*
짐 나르기
문제
김코딩과 박해커는 사무실 이사를 위해 짐을 미리 싸 둔 뒤, 짐을 넣을 박스를 사왔다.
박스를 사오고 보니 각 이사짐의 무게는 들쭉날쭉한 반면,
박스는 너무 작아서 한번에 최대 2개의 짐 밖에 넣을 수 없었고 무게 제한도 있었다.

예를 들어, 짐의 무게가 [70kg, 50kg, 80kg, 50kg]이고 박스의 무게 제한이 100kg이라면
2번째 짐과 4번째 짐은 같이 넣을 수 있지만 1번째 짐과 3번째 짐의 무게의 합은 150kg이므로
박스의 무게 제한을 초과하여 같이 넣을 수 없다.

박스를 최대한 적게 사용하여 모든 짐을 옮기려고 합니다.
짐의 무게를 담은 배열 stuff와 박스의 무게 제한 limit가 매개변수로 주어질 때,
모든 짐을 옮기기 위해 필요한 박스 개수의 최소값을 return 하도록 movingStuff 함수를 작성하세요.

입력
인자 1: stuff
int 타입의 40 이상 240 이하의 자연수를 담은 배열
ex) [70, 50, 80, 50]
인자 2: limited
int 타입의 40 이상 240 이하의 자연수

출력
int 타입을 리턴해야 합니다.
모든 짐을 옮기기 위해 필요한 박스 개수의 최솟값을 숫자로 반환합니다.

주의사항
옮겨야 할 짐의 개수는 1개 이상 50,000개 이하입니다.
박스의 무게 제한은 항상 짐의 무게 중 최대값보다 크게 주어지므로 짐을 나르지 못하는 경우는 없습니다.
입출력 예시
int output = movingStuff(new int[]{70, 50, 80, 50}, 100);
System.out.println(output); // 3

int output = movingStuff(new int[]{60, 80, 120, 90, 130}, 140);
System.out.println(output); // 4
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q_01_movingStuff {
    public static void main(String[] args) {
        // write test case here
        Q_01_movingStuff coplit = new Q_01_movingStuff();

        int output = coplit.movingStuff(new int[]{70, 50, 80, 50}, 100);
        System.out.println(output); // 3

        output = coplit.movingStuff(new int[]{60, 80, 120, 90, 130}, 140);
        System.out.println(output); // 4

        output = coplit.movingStuff(new int[]{42, 25, 60, 73, 103, 167}, 187);
        System.out.println(output); // 4
    }

    public int movingStuff(int[] stuff, int limit) {
        List<Integer> copyStuff = Arrays.stream(stuff)
                .sorted()
                .boxed()
                .collect(Collectors.toList());

        int output = 0;
        int weight = 0;
        while (copyStuff.size() != 0) {
            weight += copyStuff.remove(copyStuff.size() - 1);  // remove 메서드의 리턴값은 제거되는 요소값

            boolean isStuff = copyStuff.size() != 0;  // 남아있는 짐 중에 가장 무거운 짐을 넣은게 마지막 값이 될 수 있습니다.
            if (isStuff && weight + copyStuff.get(0) <= limit) copyStuff.remove(0);
            weight = 0;
            output += 1;
        }
        return output;
    }
}

