package section1.java_effective.stream;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

@Getter
@AllArgsConstructor
class OptionalMember {
    String name;
    String id;
    Optional<Car> car;
}

@Getter
@AllArgsConstructor
class Insurance {
    String companyName;
}

@Getter
@AllArgsConstructor
class Car {
    String carName;
    int price;
    Optional<Insurance> insurance;
}

class MemberService {
    public Optional<OptionalMember> getMember(String id) {
        Optional<Insurance> insurance = Optional.of(new Insurance("Samsung direct"));
        Optional<Car> car = Optional.of(new Car("XC-60", 60_000_000, insurance));
        return Optional.of(new OptionalMember("Kevin", "kevin1234", car));
    }
}

public class OptionalPractice {
    public static void main(String[] args) {
        MemberService memberService = new MemberService();
        String insuranceName = memberService
                .getMember("kevin1234")
                .flatMap(OptionalMember::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getCompanyName)
                .orElse("Not result");
        System.out.println(insuranceName);
    }
}
