package com.codestates.section2week4.coffee;

public class CoffeeTest {
    public static void main(String[] args) {
        CoffeeService coffeeService = new CoffeeService();

        Coffee coffee = new Coffee(0L, "바닐라 라테", "Vanilla Latte", 5000);
        coffeeService.createCoffee(coffee);

        if (coffeeService.getCoffee(0L).getKorName().equals(coffee.getKorName())) {
            System.out.printf("%s가(이) 등록되었습니다.%n", coffee.getKorName());
        }

        String newName = "바닐라 라테";
        int newPrice = 3000;
        coffeeService.editCoffee(0L, newName, newPrice);
        if (coffeeService.getCoffee(0L).getPrice() == newPrice) {
            System.out.printf("%s의 가격이 %d 원으로 변경되었습니다.%n", newName, newPrice);
        }

        Long deleteId = 0L;
        String deleteKorName = coffeeService.getCoffee(deleteId).getKorName();
        coffeeService.deleteCoffee(deleteId);
        if (coffeeService.getCoffee(deleteId) == null) {
            System.out.printf("%s가(이) 정상적으로 삭제되었습니다.%n", deleteKorName);
        }
    }
}