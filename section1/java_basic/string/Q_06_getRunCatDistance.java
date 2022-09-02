
package section1.java_basic.string;

/* 
우리는 지금 개발을 하기 위해서 여기 모여서 공부하고 있습니다. 당면한 어떤 문제를 해결하기 위해서 새로운 것을 만드는 것, 개발이죠. 
그 중 새로운 것, 특히 새로운 소프트웨어를 만들기 위해서는 무엇을 해야 할까요? 해결해야 할 문제도 찾아야 되고, 어떻게 해결할지에 대해서 고민을 해야할 것입니다.

문제를 어떻게 해결할지에 대한 다양한 해결 방법을 알고리즘이라 합니다. 
메서드는 이러한 문제 해결을 위한 고민을 체계적으로 잘 구성한 하나의 작은 기능으로 볼 수 있습니다. 
계산기를 만드는 경우, 계산기가 해결하고자 하는 문제인 숫자 계산을 위해서는 몇 가지의 기능이 필요할까요? 
아래 그림을 참고해보세요. 메서드 하나를 만드는 것은 저 작은 네모를 하나 만드는 것입니다.

메서드(Method)
조금 더 좁게 이야기 하자면, 메서드는 입력(input)을 받아 출력(output)을 하는 하나의 작은 기능 단위입니다.

가장 단순한 덧셈 문제를 풀어보겠습니다. 두 개의 숫자를 더하는 메소드는 다음과 같습니다.

public int sum(int num1, int num2) {
  int result;
  result = num1 + num2;
  return result;
}
int output = sum(1, 2); // 3

우리는 두 개의 숫자를 입력받아, 잘 짜여진 코드를 거쳐, 두 숫자의 합을 출력했습니다. 
이렇게 작은 메서드를 모아서 여러분의 선배 개발자들은 페이스북도 만들고, 카카오톡도 만들었습니다. 
즉, 여러분이 메서드를 하나 만든 것은 이미 작은 단위의 개발을 마쳤다고 볼 수 있습니다. 축하드립니다!

이번에는 귀여운 runcat이 얼마나 이동했는지 알아봅시다 :)

문제
속력 speed , 시간 time 이 숫자로 주어졌을 때, 이동한 거리를 변수 distance에 할당하여 리턴하는 getRunCatDistance 메서드를 작성하세요.


 */

public class Q_06_getRunCatDistance {
    public static void main(String[] args) {
    }

    public int getRunCatDistance(int speed, int time) {
        int distance;
        // TODO: 속력(speed), 시간(time)이 숫자로 주어졌을 때, 이동한 거리를 변수 distance에 할당하여 리턴하는
        // getRunCatDistance 함수를 작성하세요.
        distance = speed * time;

        // 아래의 코드는 수정하지 말아야 합니다
        return distance;
    }
}