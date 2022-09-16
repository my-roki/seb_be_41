package section1.java_effective.coplit_stream;

/*
computeAverageOfMaleMember

문제
이번엔 Member 클래스를 이용해 회원의 이름, 성별, 나이까지 관리하려고 합니다.
Member 타입을 요소로 가지는 List를 입력받아, 남성 회원들의 평균 나이를 리턴해야 합니다.

입력
인자 1 : members
Member 타입을 요소로 가지는 List

출력
double 타입을 리턴해야 합니다.

주의 사항
반복문(for, while) 사용은 금지됩니다.
회원의 수가 0이거나, 남자 회원이 없는 경우 0을 리턴해야 합니다.

입출력 예시
Member coding = new Member("coding", "Female", 25);
Member hacker = new Member("hacker", "Male", 30);
Member ingi = new Member("ingi", "Male", 32);
List<Member> members = Arrays.asList(coding, hacker, ingi);
double output = computeAverageOfMaleMember(members);
System.out.println(output); // --> 31.0

힌트
List의 각 요소는 Member 클래스의 인스턴스 객체입니다.
각 요소(인스턴스 객체)에서 성별을 어떻게 알아낼 수 있을지 Member 객체의 메서드를 살펴보세요.
 */

import java.util.Arrays;
import java.util.List;

public class Q_05_computeAverageOfMaleMember {
    public static void main(String[] args) {
        Q_05_computeAverageOfMaleMember coplit = new Q_05_computeAverageOfMaleMember();
        Member coding = new Member("coding", "Female", 25);
        Member hacker = new Member("hacker", "Male", 30);
        Member ingi = new Member("ingi", "Male", 32);
        List<Member> members = Arrays.asList(coding, hacker, ingi);
        double output = coplit.computeAverageOfMaleMember(members);
        System.out.println(output); // --> 31.0

    }

    public double computeAverageOfMaleMember(List<Member> members) {
        //구현된 Member 클래스의 getName(), getGender(), getAge() 메소드로 해당 Member 클래스의 name, gender, age를 확인할 수 있습니다.
        double output = members.stream()
                .filter(n -> n.getGender()
                        .equals("Male"))
                .mapToInt(Member::getAge)
                .average()
                .orElse(0);
        return output;
    }

    // 아래 코드는 변경하지 마세요.
    static class Member {
        String name;
        String gender;
        int age;

        public Member(String name, String gender, int age) {
            this.name = name;
            this.gender = gender;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public String getGender() {
            return gender;
        }

        public int getAge() {
            return age;
        }
    }
}