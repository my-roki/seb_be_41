
package section1.java_basic.string;

/* 
타입(type)
이제 우리는 변수를 선언하고, 값을 할당하는 법에 대해서 배웠습니다. 자바의 모든 값(value)는 각자 타입을 가집니다. 평소에 우리는 의식적으로 숫자와 문자를 구분하지 않지만, 우리는 이를 무의식적으로 구분할 수 있을 만큼 똑똑합니다. 문맥을 이해할 수 있기 때문이죠. 하지만 컴퓨터는 상황과 문맥을 이해하는 능력이 없습니다.

'혜선아, 그 우리 일요일에 그 일본 가정식 하나 먹을까?';
컴퓨터에게 숫자를 구분하는 방식을 알려줬더니, 이렇게 해석했습니다.

'혜선아, 그 우리 '1'요'1'에 그 '1'본 가정식 '1' 먹을까?';
아주 처참하죠? 이것을 컴퓨터가 명확하게 표현하기 위해서는 모든 값에 타입을 정해주고, 그에 맞게 행동하도록 규정을 정해주는 것이 상식적입니다.

String person = "혜선";
String date = "일요일";
int quantity = 1;
letsGoGetFood(person, date, quantity);
우리가 평소에 대화하는 것과 같이, 컴퓨터에게도 문자로 인식을 시켜주기 위해서는 " 따옴표로 둘러 쌓아서 표시 "hello world"할 수 있습니다. 
조금 더 개발자 답게 String(문자열)이라고 합니다. 숫자는 그대로 입력 1234 하면 됩니다. int가 되겠네요. 
비슷한 문제를 한번 풀어봅시다. 코딩이에게 공구함의 건전지의 종류를 물어볼까요?

문제
변수 thing에 문자(char) 'A'를 할당하고, 변수 num에 숫자(int) 3을 할당합니다.
 */

public class Q_09_type {
    public static void main(String[] args) {
        Q_09_type coplit = new Q_09_type();
        System.out.println(coplit.type());
    }

    public String type() {
        int num;
        char thing;

        // TODO :
        thing = 'A';
        num = 3;

        // 아래 코드는 수정하지 말아야 합니다.
        return goCheck(num, thing);
    }

    // 아래 메소드는 수정하지 말아야 합니다.
    public String goCheck(int num, char thing) {
        return String.format("코딩아, 공구함에 있는 건전지말야. %c가 %d개 들어있는게 맞니?", thing, num);
    }
}