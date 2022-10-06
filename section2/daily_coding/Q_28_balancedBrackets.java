package section2.daily_coding;

/*
# **balancedBrackets**

## **문제**

문자열을 입력받아 문자열 내의 모든 괄호의 짝이 맞는지 여부를 리턴해야 합니다.

- 다음 단계에 맞춰 함수를 작성해 보세요
    1. 괄호의 종류를 단 한가지로 한정합니다.
    2. 괄호의 종류를 늘려 모든 종류의 괄호에도 작동하도록 합니다.
    3. 괄호를 제외한 문자열이 포함된 경우에도 작동하도록 합니다.
    4. 괄호는 닫힌 괄호 `(, [, {` 가 시작되면, 이후로 열린 괄호가 입력될 수 없습니다 (이럴 경우 실패)

## **입력**

### **인자 1 : str**

- `String` 타입의 괄호가 포함된 문자열

## **출력**

- `boolean` 타입을 리턴해야 합니다.

## **주의사항**

- 괄호의 종류는 `(, )`만 고려합니다.
- 괄호는 먼저 열리고(`(`), 열린만큼만 닫혀야(`)`) 합니다.
- 빈 문자열을 입력받은 경우, `true`를 리턴해야 합니다.

## **입출력 예시**

```
boolean output = balancedBrackets("(");
System.out.println(output); // // -> false

output = balancedBrackets("()");
System.out.println(output); // --> true
```

## **Advanced**

- 모든 종류의 괄호(`(, ), {, }, [, ]`)가 포함된 문자열을 입력받아 모든 괄호의 짝이 맞는지 여부를 리턴해 보세요.

```
boolean output = balancedBrackets("[](){}");
System.out.println(output); // --> true

boolean output2 = balancedBrackets("[({})]");
System.out.println(output2); // --> true

boolean output3 = balancedBrackets("[(]{)}");
System.out.println(output3); // --> false
```
 */

import java.util.Stack;

public class Q_28_balancedBrackets {
    public static void main(String[] args) {
        // write test case here
        Q_28_balancedBrackets coplit = new Q_28_balancedBrackets();
        boolean output = coplit.balancedBrackets("[](){}");
        System.out.println(output); // --> true

        boolean output2 = coplit.balancedBrackets("[({})]");
        System.out.println(output2); // --> true

        boolean output3 = coplit.balancedBrackets("[(]{)}");
        System.out.println(output3); // --> false

        boolean output4 = coplit.balancedBrackets(")(");
        System.out.println(output4); // --> false

    }

    public boolean balancedBrackets(String str) {
        if (str.length() == 0) return true;
        Stack<Character> bucket = new Stack<>();
        bucket.add(' ');
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '[' || str.charAt(i) == '(' || str.charAt(i) == '{') {
                bucket.add(str.charAt(i));
                continue;
            }

            if (str.charAt(i) == ']' && bucket.get(bucket.size() - 1) == '[') {
                bucket.pop();
                continue;
            }
            if (str.charAt(i) == '}' && bucket.get(bucket.size() - 1) == '{') {
                bucket.pop();
                continue;
            }
            if (str.charAt(i) == ')' && bucket.get(bucket.size() - 1) == '(') {
                bucket.pop();
                continue;
            }
            return false;
        }
        return bucket.size() == 1;
    }
}

