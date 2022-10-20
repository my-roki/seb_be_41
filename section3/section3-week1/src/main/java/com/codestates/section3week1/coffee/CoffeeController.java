package com.codestates.section3week1.coffee;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/coffees", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CoffeeController {
    @PostMapping
    public String postCoffee(@RequestParam("engName") String engName,
                             @RequestParam("korName") String korName,
                             @RequestParam("price") long price) {
        System.out.printf("# engName: %s%n", engName);
        System.out.printf("# korName: %s%n", korName);
        System.out.printf("# price: %s%n", price);

        String response = "{\"" +
                "engName\":\"" + engName + "\"," +
                "\"korName\":\"" + korName + "\",\"" +
                "price\":\"" + price + "\"}";
        return response;
    }

    @GetMapping
    public String getCoffees() {
        System.out.println("# get Coffees");

        // not implementation
        return null;

    }

    @GetMapping("/{coffee-id}")
    public String getCoffee(@PathVariable("coffee-id") long coffeeId) {
        System.out.printf("# coffeeId: %d%n", coffeeId);

        // not implementation
        return null;
    }
}