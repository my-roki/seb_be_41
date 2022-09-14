package section1.java_collection.coplit_collection;

/* 
isMember

문제
회원 정보(username, password)가 저장되어있는 HashMap이 있습니다. username과 password를 입력받아 HashMap에 저장된 회원정보와 일치한지 확인하려 합니다. 입력받은 username과 password를 이용해 회원이 맞는지 여부를 리턴해야 합니다.

입력
인자 1 : member
<String, String> 타입을 요소로 갖는 HashMap

출력
전달받은 HashMap에 일치하는 username-password 쌍이 있는지 확인하고, 있으면 true를 없으면 false를 리턴해야 합니다.

입출력 예시
HashMap<String, String> member = new HashMap<String, String>(){{
	put("kimcoding", "1234");
	put("parkhacker", "qwer");
}};
boolean output = isMember(number, "parkhacker", "qwer");
System.out.println(output); // --> true
*/

import java.util.HashMap;

public class Q_22_isMember {
    public static void main(String[] args) {
        Q_22_isMember coplit = new Q_22_isMember();

        HashMap<String, String> member = new HashMap<String, String>() {{
            put("kimcoding", "1234");
            put("parkhacker", "qwer");
        }};
        boolean output = coplit.isMember(member, "parkhacker", "qwer");
        System.out.println(output); // --> true
    }

    public boolean isMember(HashMap<String, String> member, String username, String password) {
        if (!member.containsKey(username)) return false;
        return member.get(username).equals(password);
    }
}