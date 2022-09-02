
package section1.java_basic.string;

/* 
메서드의 호출(invoke; call)
변수에 메서드가 담겨있다면, 다른 변수와는 다르게 () 괄호를 붙여서 메서드를 호출할 수 있습니다. 또한 입력값을 설정할 수도 있는데요, 이를 전달인자(argument), 줄여서 인자라고 부릅니다.

String word = speakUp("hello world");
// 1. 메서드 speakUp에 ()를 붙여 함수를 호출합니다.
// 2. 호출 시 괄호 안에 "hello world"를 넣어 문자열 "hello world"를 인자로 전달합니다.
// 3. 호출된 메서드가 리턴하는 값을 변수 word에 할당합니다.
// TIP: 변수에 값을 담는 것을 "할당한다" 라고 합시다 :)
메서드의 리턴(return)
메서드가 호출되고 나면, 메서드의 body(중괄호 내의 코드)에 있는 코드가 실행되고 결과값을 리턴(return)합니다. 
이 결과 값은 메서드의 body에서 어떤 값을 return하는지에 따라서 결정됩니다. 다만, 메서드에서 지정한 타입과 같은 타입의 값만 반환이 가능합니다.

public int minusOne(int input) {
  input = input - 1;
  return input;
}
int result = minusOne(10); // 9

// void타입을 지정한다면, 해당 메서드는 어떠한 값도 반환하지 않습니다.
public void functionWithoutReturn() {
  System.out.println("I may return!");
}
메서드의 호출과 리턴에 유념하여 문제를 풀어보세요 !

문제
문자열을 인자로 받아서 느낌표를 붙여서 리턴해주는 메서드 returnWordWithJoy가 있습니다. 
메서드 returnWordWithJoy의 첫 번째 인자로 문자열 "I love coding"을 넣어서 호출하고, 그 결과값을 변수 word에 할당하세요.
 */

public class Q_08_callFunction {
    public static void main(String[] args) {
        Q_08_callFunction coplit = new Q_08_callFunction();
        System.out.println(coplit.invoke());
    }

    // 문자열을 인자로 받아서 느낌표를 붙여서 리턴 해주는 메서드 returnWordWithJoy가 있습니다.
    // 메서드 returnWordWithJoy의 첫 번째 인자로 문자열 "I love coding"을 넣어서 호출하고, 그 결과값을 변수
    // word에 할당하세요.
    public String invoke() {
        String word;
        // TODO :
        word = returnWordWithJoy("I love coding");

        // 아래 코드는 수정하지 말아야 합니다.
        return word;
    }

    // 아래의 메서드는 수정하지 말아야 합니다.
    public static String returnWordWithJoy(String str) {
        if (str.equals(""))
            return "empty value";
        else
            return str + "!";
    }
}