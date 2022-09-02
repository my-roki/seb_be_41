
package section1.java_basic.string;

/* 
getFullName
문제
이름과 성을 입력받아 띄어쓰기 하나를 사이에 둔 단일 문자열을 리턴해야 합니다.

입력
인자 1 : firstName
String 타입의 알파벳 문자열
firstName.length()는 10 이하

인자 2 : lastName
String 타입의 알파벳 문자열
lastName.length()는 10 이하

출력
String 타입을 리턴해야 합니다.

입출력 예시
String output = getFullName("Joe", "Smith");
System.out.println(output); // --> "Joe Smith"

힌트
문자열을 합칠 때에는 + 연산자를 사용합니다.
"Code" + "States"; // "CodeStates"
"Hello " + "World"; // "HelloWorld"
 */

public class Q_13_getFullName {
    public static void main(String[] args) {
        Q_13_getFullName coplit = new Q_13_getFullName();
        System.out.println(coplit.getFullName("Code", "States"));
        System.out.println(coplit.getFullName("Rebecca", "Solnit"));
    }

    public String getFullName(String firstName, String lastName) {
        // TODO:
        return firstName + " " + lastName;
    }
}