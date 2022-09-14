package section1.java_collection.coplit_collection;

/* 
addFullNameEntry

문제
한 사람의 firstName, lastName Entry가 저장되어있는 HashMap을 입력 받아, fullName 이라는 새 Entry를 HashMap에 저장하고 해당 HashMap을 리턴해야 합니다.

입력
인자 1 : hashMap
<String, String> 타입을 요소로 가지는 HashMap

출력
HashMap에 firstName, lastName가 이미 저장되어 있음을 이용해 fullName이라는 key와 알맞은 문자열을 저장한 후 해당 HashMap을 리턴해야 합니다.

주의 사항
입력받은 HashMap과 리턴하는 HashMap는 같은 주소값을 가져야 합니다.
반복문(for, while) 사용은 금지됩니다.

입출력 예시
HashMap<String, String> hashMap = new HashMap<String, String>(){{
	put("firstName", "김");
	put("lastName", "코딩");
}};
HashMap<String, String> output =  addFullNameEntry(hashMap);
System.out.println(output); // --> {firstName=김, fullName=김코딩, l
*/

import java.util.HashMap;

public class Q_19_addFullNameEntry {
    public static void main(String[] args) {
        Q_19_addFullNameEntry coplit = new Q_19_addFullNameEntry();
        HashMap<String, String> hashMap = new HashMap<String, String>() {{
            put("firstName", "김");
            put("lastName", "코딩");
        }};
        HashMap<String, String> output = coplit.addFullNameEntry(hashMap);
        System.out.println(output); // --> {firstName=김, fullName=김코딩, l

    }

    public HashMap<String, String> addFullNameEntry(HashMap<String, String> hashMap) {
        String firstname = hashMap.get("firstName");
        String lastname = hashMap.get("lastName");
        hashMap.put("fullName",firstname+lastname);
        return hashMap;
    }
}