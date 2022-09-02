package section1.java_basic.string;

// 변수에 값 할당하기(Assignment)
// 우리는 이제 막 변수를 선언했습니다. 어떤 값(value)를 넣을 수 있는 자리를 컴퓨터 메모리에 미리 잡아두었다는 의미입니다. 그렇다면 어떤 값을 넣는 것은 어떻게 할까요? 잡아놓은 letter이라는 빈 자리에 무언가를 넣는 작업을 변수에 값을 할당한다 라고 합니다. 변수 뒤에 = 연산자를 쓰고, = 뒤에 할당하고자 하는 값을 넣을 수 있습니다.

// char letter; // letter 변수 선언
// letter = 'A'; // letter 변수에 문자 'A' 할당

// 워낙 자주 사용되는 코드라서, 선언과 할당을 한 줄에 작성할 수도 있습니다. (char letter = 'A';) 그렇다면 선언을 하지 않고 할당을 시도하면 어떻게 될까요? 당연히 Java World에 아무것도 없기 때문에 할당을 할 수 없어서 에러가 발생하게 됩니다.

// 문제
// 선언되어 있는 변수 course에 char 타입의 문자 'A'를 할당하세요.

public class Q_02_assignment_char {
    public static void main(String[] args) {
        new Q_02_assignment_char().declarations();
    }

    char course;

    // TODO : 선언되어 있는 변수 course에 char 타입의 문자 'A'를 할당하세요.
    public void declarations() {
        // 코드는 아래 라인에 작성해야 합니다.
        course = 'A';
    }
}