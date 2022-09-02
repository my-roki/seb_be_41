
package section1.java_basic.string;

/* 
메서드의 선언
자바에서는 아래와 같은 방식으로 메서드를 직접 구현할 수 있습니다. 첫번째는 정수를 입력받아 1을 더한 값을 반환하는 메서드입니다. 두번째는 정수를 입력받아 1을 뺀 값을 반환하는 메서드입니다.

public int plusOne(int input1) {
  input1 = input1 + 1;
  return input1;
}

public int minusOne(int input2) {
  input2 = input2 - 1;
  return input2;
};

그렇다면 이번에는 곱셈과 나눗셈을 하는 메서드를 만들어볼까요?

문제
첫 번째 인자에 2를 곱하는 메서드 multiplyBy2와 비슷하게 첫 번째 인자를 2로 나누는 메서드 divideBy2를 선언하세요.
 */

public class Q_07_declareFunction {
  public static void main(String[] args) {
  }

  public int multipleBy2(int input) {
    input = input * 2;
    return input;
  }
  // 위의 코드는 수정하지 말아야 합니다

  public int devideBy2(int input) {
    // TODO : 첫 번째 인자에 2를 곱하는 함수 multiplyBy2와 비슷하게
    // 첫 번째 인자를 2로 나누는 함수 divideBy2를 선언하세요.
    input /= 2;

    // 아래의 코드는 수정하지 말아야 합니다
    return input;
  }
}