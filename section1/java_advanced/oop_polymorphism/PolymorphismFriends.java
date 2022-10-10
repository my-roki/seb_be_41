package section1.java_advanced.oop_polymorphism;

class Friend {
    public void friendInfo() {
        System.out.println("I'm your friend");
    }
}

class BoyFriend extends Friend {
    public void friendInfo() {
        System.out.println("I'm your boyfriend");
    }
}

class GirlFriend extends Friend {
    public void friendInfo() {
        System.out.println("I'm your girlfriend");
    }

    public void girlfriendName() {
        System.out.println("I'm a girl");
    }
}

public class PolymorphismFriends {
    public static void main(String[] args) {
        Friend friend = new Friend(); // 객체 타입과 참조변수 타입의 일치
        BoyFriend boyfriend = new BoyFriend();
        Friend girlfriend = new GirlFriend(); // 객체 타입과 참조변수 타입의 불일치

        friend.friendInfo();
        boyfriend.friendInfo();
        girlfriend.friendInfo();
//        girlfriend.girlfriendName();  // Cannot resolve method 'girlfriendName' in 'Friend'
    }
}
