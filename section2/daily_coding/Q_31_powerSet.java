package section2.daily_coding;

/*
# **powerSet**

## **문제**

하나의 집합을 의미하는 문자열을 입력받아 각 문자를 가지고 만들 수 있는 모든 부분집합을 리턴해야 합니다.

## **입력**

### **인자 1 : str**

- `String` 타입의 공백이 없는 알파벳 소문자 문자열

## **출력**

- `ArrayList<String>`을 리턴해야 합니다.
- `ArrayList`의 요소는 각 부분집합의 원소로 구성된 문자열

## **주의사항**

- `ArrayList`의 요소는 각 부분집합을 구성하는 원소를 연결한 문자열입니다.
- `ArrayList`의 요소는 알파벳 순서로 정렬되어야 합니다.
- 집합은 중복된 원소를 허용하지 않습니다.
- 부분집합은 빈 문자열을 포함합니다.
- `ArrayList`는 오름차순으로 정렬되어야 합니다.

## **입출력 예시**

```
ArrayList<String> output1 = powerSet("abc");
System.out.println(output1); // ["", "a", "ab", "abc", "ac", "b", "bc", "c"]

ArrayList<String> output2 = powerSet("jjump");
System.out.println(output2); // ["", "j", "jm", "jmp", "jmpu", "jmu", "jp", "jpu", "ju", "m", "mp", "mpu", "mu", "p", "pu", "u"]
```
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Q_31_powerSet {
    public static void main(String[] args) {
        // write test case here
        long start = System.currentTimeMillis();
        Q_31_powerSet coplit = new Q_31_powerSet();

        ArrayList<String> output1 = coplit.powerSet("abc");
        System.out.println(output1); // ["", "a", "ab", "abc", "ac", "b", "bc", "c"]

        ArrayList<String> output3 = coplit.powerSet("bac");
        System.out.println(output3); // ["", "a", "ab", "abc", "ac", "b", "bc", "c"]

        ArrayList<String> output2 = coplit.powerSet("jjump");
        System.out.println(output2); // ["", "j", "jm", "jmp", "jmpu", "jmu", "jp", "jpu", "ju", "m", "mp", "mpu", "mu", "p", "pu", "u"]

        // process time
        System.out.println("=".repeat(20));
        System.out.printf("Process end : %dms%n", System.currentTimeMillis() - start);
        System.out.println("=".repeat(20));
    }

    public ArrayList<String> powerSet(String str) {
        // 집합은 중복된 원소를 허용하지 않습니다.
        String strDistinct = "";
        for (int index = 0; index < str.length(); index++) {
            if (str.indexOf(str.charAt(index)) == index) {
                strDistinct += str.charAt(index);
            }
        }

        // ArrayList의 요소는 알파벳 순서로 정렬되어야 합니다.
        String[] strArr = strDistinct.split("");
        Arrays.sort(strArr);

        // ArrayList의 요소는 각 부분집합의 원소로 구성된 문자열 -> 재귀함수로 모든 문자에 대해 선택할지 말지를 결
        ArrayList<String> output = recursion(strArr, 0, "", new ArrayList<>());

        // ArrayList는 오름차순으로 정렬되어야 합니다.
        Collections.sort(output);
        return output;
    }

    public ArrayList<String> recursion(String[] str, int round, String bucket, ArrayList<String> output) {
        // 탈출 : 모든 문자에 대하여 선택(또는 선택하지 않음)이 완료된 시점
        if (round == str.length) {
            output.add(bucket);
            return output;
        }

        // 경우의 수는 모든 문자에 대하여 선택, 선택x 두 가지만 존재합니다(총 경우의 수는 2^문자개수).
        // 따라서 모든 문자에 대하여 선택하면 bucket +=, 선택하지 않으면 pass 방법으로 모든 경우의 수를 구할 수 있습니다.
        // ex "abc" -> a(선택x) + b(선택x) + c(선택x) -> "" + "" + "" -> ""
        // ex "abc" -> a(선택o) + b(선택x) + c(선택o) -> "a" + "" + "c" -> "ac"
        for (int ispick = 0; ispick < 2; ispick++) {
            // bucket이 이전 것들과 중복되지 않도록 복사
            String newBucket = bucket;

            // 만약 문자를 선택한다면 bucket에+=, 그렇지 않으면 pass.
            if (ispick == 0) newBucket += str[round];

            // 모든 문자에 대하여(round) 선택, 선택x 인지 여부를 재귀함수를 호출합니다.
            output = recursion(str, round + 1, newBucket, output);
        }
        return output;
    }
}





