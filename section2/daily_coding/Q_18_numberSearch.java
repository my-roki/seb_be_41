package section2.daily_coding;

/*
numberSearch
문제
문자열을 입력받아 문자열에서 숫자를 모두 찾아 더한 뒤에 해당 값을 (숫자와 공백을 제외한 나머지)
문자열의 길이로 나눈 값을 정수로 반올림하여 리턴해야 합니다.

입력
인자 1 : str
String 타입의 문자열

출력
int 타입을 리턴해야 합니다 (0 이상의 정수)

주의 사항
빈 문자열을 입력받은 경우, 0을 리턴해야 합니다.
숫자(digit)는 연속해서 등장하지 않습니다.

입출력 예시
int output = numberSearch("Hello6 ");
System.out.println(output); // --> 1

output = numberSearch("Hello6 9World 2,");
System.out.println(output); // --> 2

output = numberSearch("Hello6 9World 2, Nic8e D7ay!");
System.out.println(output); // --> 2

힌트
주어진 문자(길이 1의 문자열)이 숫자(digit)인지 판단하는 방법은 여러 가지 입니다.
그 중 하나는 해당 문자가 숫자들의 집합(문자열 또는 배열)에 속하는 지를 판단하는 것입니다.
이와 관련해서 Java String contains, Java String indexOf를 검색해 봅니다.
 */

public class Q_18_numberSearch {
    public static void main(String[] args) {
        // write test case here
        Q_18_numberSearch coplit = new Q_18_numberSearch();
        int output = coplit.numberSearch("Hello6 ");
        System.out.println(output); // --> 1

        output = coplit.numberSearch("Hello6 9World 2,");
        System.out.println(output); // --> 2

        output = coplit.numberSearch("Hello6 9World 2, Nic8e D7ay!");
        System.out.println(output); // --> 2
    }

    public int numberSearch(String str) {
        if (str.length() == 0) return 0;
        String digits = "0123456789";

        // int 타입의 나눗셈 연산은 소수점까지 출력을 해주지 못하기 때문에 소수 타입으로 진행해야합니다.
        double number = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char target = str.charAt(i);
            if (digits.indexOf(target) != -1) {
                number += Character.getNumericValue(target);
                continue;
            }
            if (target != ' ') {
                stringBuilder.append(target);
            }
        }

        double divider = stringBuilder.length();
        return (int) Math.round(number / divider);
    }
}
