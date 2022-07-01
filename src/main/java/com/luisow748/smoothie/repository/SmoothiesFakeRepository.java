package com.luisow748.smoothie.repository;

import com.luisow748.smoothie.domain.Smoothie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SmoothiesFakeRepository {

    public static List<Smoothie> getSmoothies() {
        List<Smoothie> smoothies = new ArrayList<>();
        smoothies.add(new Smoothie("Classic", new ArrayList<String>(List.of("strawberry", "banana", "pineapple", "mango", "peach", "honey", "ice", "yogurt"))));
        smoothies.add(new Smoothie("Forest Berry", new ArrayList<String>(List.of("strawberry", "raspberry", "blueberry", "honey", "ice", "yogurt"))));
        smoothies.add(new Smoothie("Freezie", new ArrayList<String>(List.of("blackberry", "blueberry", "black currant", "grape juice", "frozen yogurt"))));
        smoothies.add(new Smoothie("Greenie", new ArrayList<String>(List.of("green apple", "kiwi", "lime", "avocado", "spinach", "ice", "apple juice"))));
        smoothies.add(new Smoothie("Vegan Delite", new ArrayList<String>(List.of("strawberry", "passion fruit", "pineapple", "mango", "peach", "ice", "soy milk"))));
        smoothies.add(new Smoothie("Just Desserts", new ArrayList<String>(List.of("banana", "ice cream", "chocolate", "peanut", "cherry"))));
        return smoothies;
    }
}
