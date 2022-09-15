package section1.java_effective.lambda;

import java.util.function.*;

class Member {
    private String id;
    private String name;

    public Member() {
        System.out.println("Member() 생성자입니다.");
    }

    public Member(String id) {
        System.out.println("Member(String id) 생성자입니다.");
    }

    public Member(String id, String name) {
        System.out.println("Member(String id, String name) 생성자입니다.");
    }
}


public class ConstructorReference {
    public static void main(String[] args) {
        Supplier<Member> function0 = Member::new;
        Member member0 = function0.get();

        Function<String, Member> function1 = Member::new;
        Member member1 = function1.apply("x9136rt7xb");

        BiFunction<String, String , Member> function2 = Member::new;
        Member member2 = function2.apply("a9s76vtf123", "roki");
    }
}