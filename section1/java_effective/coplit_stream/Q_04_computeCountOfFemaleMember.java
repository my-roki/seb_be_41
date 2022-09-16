package section1.java_effective.coplit_stream;

/*
computeCountOfFemaleMember

문제
Member 클래스를 이용해 회원의 이름과 성별을 관리하려고 합니다. Member타입의 List를 입력받아, 여성 회원의 수를 리턴해야 합니다.

입력
인자 1 : members
Member 타입을 요소로 가지는 List

출력
long 타입을 리턴해야 합니다.

주의 사항
반복문(for, while) 사용은 금지됩니다.

입출력 예시
Member coding = new Member("coding", "Female");
Member hacker = new Member("hacker", "Male");
List<Member> members = Arrays.asList(coding, hacker);
long output = computeCountOfFemaleMember(members);
System.out.println(output); // --> 1

힌트
List의 각 요소는 Member 클래스의 인스턴스 객체입니다.
각 요소(인스턴스 객체)에서 성별을 어떻게 알아낼 수 있을지 Member 객체의 메서드를 살펴보세요.
 */

import java.util.Arrays;
import java.util.List;

public class Q_04_computeCountOfFemaleMember {
    public static void main(String[] args) {
        Q_04_computeCountOfFemaleMember coplit = new Q_04_computeCountOfFemaleMember();
        Member coding = new Member("coding", "Female");
        Member hacker = new Member("hacker", "Male");
        List<Member> members = Arrays.asList(coding, hacker);
        long output = coplit.computeCountOfFemaleMember(members);
        System.out.println(output); // --> 1

    }


    public long computeCountOfFemaleMember(List<Member> members) {
        //구현된 Member 클래스의 getName(), getGender() 메소드로 해당 Member 클래스의 name, gender를 확인할 수 있습니다.
        long output = members.stream()
                .filter(member -> member.getGender().equals("Female"))
                .count();

//        int cnt = 0;
//        members.forEach(member -> {
//            if (member.getGender().equals("Female")) cnt += 1;
//        });
//        System.out.println(cnt);

        return output;
    }

    // 아래 코드는 변경하지 마세요.
    static class Member {
        String name;
        String gender;

        public Member(String name, String gender) {
            this.name = name;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public String getGender() {
            return gender;
        }
    }
}