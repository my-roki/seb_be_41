package section2.algorithms;

import java.util.regex.Pattern;

public class RegularExp {
    public static void main(String[] args) {
        RegularExp coplit = new RegularExp();
        boolean output1 = coplit.regex("asf876214ygf6");
        boolean output2 = coplit.non_regex("asf876214ygf6");
        System.out.println(output1);
        System.out.println(output2);

        boolean output3 = coplit.regex("32145");
        boolean output4 = coplit.non_regex("32145");
        System.out.println(output3);
        System.out.println(output4);

    }

    // 정규표현식 사용
    public boolean regex(String str) {
        String regExp = "\\d{5}$|\\d{7}$";
        return Pattern.matches(regExp, str);
    }

    // 정규표현식 미사용
    public boolean non_regex(String str) {
        if (str.length() == 5 || str.length() == 7) {
            for (int i = 0; i < str.length(); i++) {
                if (!Character.isDigit(str.charAt(i))) return false;
            }
            return true;
        }
        return false;
    }
}