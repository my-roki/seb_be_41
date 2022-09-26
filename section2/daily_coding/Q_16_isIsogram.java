package section2.daily_coding;

/*
isIsogram
문제
문자열을 입력받아 아이소그램인지 여부를 리턴해야 합니다. 아이소그램(isogram)은 각 알파벳을 한번씩만 이용해서 만든 단어나 문구를 말합니다.

입력
인자 1 : str
String 타입의 공백이 없는 알파벳 문자열

출력
boolean 타입을 리턴해야 합니다.

주의 사항
빈 문자열을 입력받은 경우, true를 리턴해야 합니다.
대소문자는 구별하지 않습니다.

입출력 예시
boolean output = isIsogram("aba");
System.out.println(output); // false

output = isIsogram("Dermatoglyphics");
System.out.println(output); // true

output = isIsogram("moOse");
System.out.println(output); // false
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q_16_isIsogram {
    public static void main(String[] args) {
        // write test case here
        Q_16_isIsogram coplit = new Q_16_isIsogram();

        boolean output = coplit.isIsogram("aba");
        System.out.println(output); // false

        output = coplit.isIsogram("Dermatoglyphics");
        System.out.println(output); // true

        output = coplit.isIsogram("moOse");
        System.out.println(output); // false
    }

    public boolean isIsogram(String str) {
        String[] strArr = str.toLowerCase().split("");
        Set<String> strSet = new HashSet<>(List.of(strArr));
        return strArr.length == strSet.size();
    }
}
