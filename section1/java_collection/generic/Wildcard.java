package section1.java_collection.generic;

class Phone {
}

class IPhone extends Phone {
}

class Galaxy extends Phone {
}

class IPhone14Pro extends IPhone {
}

class IPhoneSE2 extends IPhone {
}

class GalaxyS22 extends Galaxy {
}

class GalaxyZFlip extends Galaxy {
}

class User<T> {
    public T phone;

    public User(T phone) {
        this.phone = phone;
    }
}

class PhoneFunction {
    public static void call(User<? extends Phone> user) {
        System.out.println("-".repeat(50));
        System.out.println("user.phone = " + user.phone.getClass().getSimpleName());
        System.out.println("모든 Phone은 통화를 할 수 있습니다.");
    }

    public static void faceId(User<? extends IPhone> user) {
        System.out.println("-".repeat(50));
        System.out.println("user.phone = " + user.phone.getClass().getSimpleName());
        System.out.println("IPhone만 Face ID를 사용할 수 있습니다. ");
    }

    public static void samsungPay(User<? extends Galaxy> user) {
        System.out.println("-".repeat(50));
        System.out.println("user.phone = " + user.phone.getClass().getSimpleName());
        System.out.println("Galaxy만 삼성 페이를 사용할 수 있습니다. ");
    }

    public static void recordVoice(User<? super Galaxy> user) {
        System.out.println("-".repeat(50));
        System.out.println("user.phone = " + user.phone.getClass().getSimpleName());
        System.out.println("안드로이드 폰에서만 통화 녹음이 가능합니다. ");
    }
}

public class Wildcard {
    public static void main(String[] args) {
        User<Phone> phone = new User<>(new Phone());

        User<IPhone> iphone = new User<>(new IPhone());
        User<IPhone14Pro> pro14 = new User<>(new IPhone14Pro());
        User<IPhoneSE2> se2 = new User<>(new IPhoneSE2());

        User<Galaxy> galaxy = new User<>(new Galaxy());
        User<GalaxyS22> s22 = new User<>(new GalaxyS22());
        User<GalaxyZFlip> zflip = new User<>(new GalaxyZFlip());

        PhoneFunction.call(phone);
        PhoneFunction.call(iphone);
        PhoneFunction.call(pro14);
        PhoneFunction.call(se2);
        PhoneFunction.call(galaxy);
        PhoneFunction.call(s22);
        PhoneFunction.call(zflip);

        System.out.println("\n" + "#".repeat(50) + "\n");

        // PhoneFunction.faceId(phone);
        PhoneFunction.faceId(iphone);
        PhoneFunction.faceId(pro14);
        PhoneFunction.faceId(se2);
        // PhoneFunction.faceId(galaxy);
        // PhoneFunction.faceId(s22);
        // PhoneFunction.faceId(zflip);

        System.out.println("\n" + "#".repeat(50) + "\n");

        // PhoneFunction.samsungPay(phone);
        // PhoneFunction.samsungPay(iphone);
        // PhoneFunction.samsungPay(pro14);
        // PhoneFunction.samsungPay(se2);
        PhoneFunction.samsungPay(galaxy);
        PhoneFunction.samsungPay(s22);
        PhoneFunction.samsungPay(zflip);

        System.out.println("\n" + "#".repeat(50) + "\n");

        PhoneFunction.recordVoice(phone);
        // PhoneFunction.recordVoice(iphone);
        // PhoneFunction.recordVoice(pro14);
        // PhoneFunction.recordVoice(se2);
        PhoneFunction.recordVoice(galaxy);
        // PhoneFunction.recordVoice(s22);
        // PhoneFunction.recordVoice(zflip);

        System.out.println("\n" + "#".repeat(50) + "\n");

    }
}
