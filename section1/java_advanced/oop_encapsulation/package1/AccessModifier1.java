package section1.java_advanced.oop_encapsulation.package1;

public class AccessModifier1 {
    // 각각 private, default, protected, public 접근제어자 지정
    private int privateNumber = 1;
    int defaultNumber = 2;
    protected int protectedNumber = 3;
    public int publicNumber = 4;

    public void printEach() { // 동일 클래스이기 때문에 에러발생하지 않음
        System.out.println(privateNumber);
        System.out.println(defaultNumber);
        System.out.println(protectedNumber);
        System.out.println(publicNumber);
    }
}

class AccessModifierTest1 { // AccessModifierTest 클래스의 접근 제어자는 default
    public static void main(String[] args) {
        AccessModifier1 accessModifier1 = new AccessModifier1();

        // System.out.println(accessModifier2.privateNumber); // 동일 클래스가 아니기 때문에 에러발생!
        System.out.println(accessModifier1.defaultNumber);
        System.out.println(accessModifier1.protectedNumber);
        System.out.println(accessModifier1.publicNumber);
    }
}
