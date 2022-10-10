package section1.java_advanced.oop_encapsulation.package2;

import section1.java_advanced.oop_encapsulation.package1.AccessModifier1;

public class AccessModifier2 {
    public static void main(String[] args) {
        AccessModifier1 accessModifier1 = new AccessModifier1();


//        System.out.println(accessModifier1.privateNumber);  // 에러 발생 -> private은 동일 클래스 내에서만 사용 가능
//        System.out.println(accessModifier1.defaultNumber);  // 에러 발생 -> default는 동일 패키지까지만 사용 가능
//        System.out.println(accessModifier1.protectedNumber);  // 에러 발생 -> protected는 다른 패키지의 하위 클래스까지만 사용 가능
        System.out.println(accessModifier1.publicNumber);
    }

}

class AccessModifierTest2 extends AccessModifier1 {
    public void printEach() {
//        System.out.println(privateNumber);  // 에러 발생 -> private은 동일 클래스 내에서만 사용 가능
//        System.out.println(defaultNumber);  // 에러 발생 -> default는 동일 패키지 내에서만 사용 가능
        System.out.println(protectedNumber);
        System.out.println(publicNumber);
    }
}
