package com.codestates.section2week4.coffee;

public class CoffeeService {
    private final CoffeeRepository coffeeRepository;

    // CoffeeService 는 생성자를 통해 어떤 구현 객체가 주입될지 알 수 없으며, 알 필요도 없습니다.
    // 어떤 객체가 주입될지는 외부(DependencyConfig)에서 결정하게 됩니다. CoffeeService 는 오로지 실행에만 집중하게 됩니다.
    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    public void createCoffee(Coffee coffee) {
        coffeeRepository.postCoffee(coffee);
    }

    public Coffee editCoffee(Long coffeeId, String korName, int price) {
        return coffeeRepository.patchCoffee(coffeeId, korName, price);
    }

    public Coffee getCoffee(Long coffeeId) {
        return coffeeRepository.getCoffee(coffeeId);
    }

    public void deleteCoffee(Long coffeeId) {
        coffeeRepository.deleteCoffee(coffeeId);
    }
}