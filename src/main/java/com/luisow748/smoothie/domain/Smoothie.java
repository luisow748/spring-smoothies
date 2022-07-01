package com.luisow748.smoothie.domain;

import lombok.Data;

import java.util.List;

@Data
public class Smoothie {

    private String name;
    private final List<String> ingredients;

    public Smoothie(String smoothieName, List<String> ingredients) {
        this.name = smoothieName;
        this.ingredients = ingredients;
    }

    public String getName(){
        return this.name;
    }

    public List<String> getIngredients(){
        return this.ingredients;
    }
}
