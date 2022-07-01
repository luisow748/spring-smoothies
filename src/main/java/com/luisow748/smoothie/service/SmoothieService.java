package com.luisow748.smoothie.service;

import com.luisow748.smoothie.domain.Smoothie;
import com.luisow748.smoothie.repository.SmoothiesFakeRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SmoothieService {

    public List<String> getIngredientsUpdated(String smoothieName, String[] commandsReceived){
        List<String> ingredientsReceived = getIngredientsFromCommandLine(commandsReceived);
        Smoothie smoothie = getByName(smoothieName);
        addOperation(smoothie, ingredientsReceived);
        removeOperation(smoothie, ingredientsReceived);
        return sort(smoothie.getIngredients());
    }

    private void removeOperation(Smoothie smoothie, List<String> ingredientsReceived) {
        ingredientsReceived.stream()
                .filter(ingredient -> ingredient.startsWith("-"))
                .forEach(ingredient -> removeIngredient(smoothie, ingredient.replace("-", "")));
    }

    private void addOperation(Smoothie smoothie, List<String> ingredients) {
        ingredients.stream()
                .filter(ingredient -> ingredient.startsWith("+"))
                .forEach(ingredient -> addIngredient(smoothie, ingredient.replace("+", "")));
    }

    private void removeIngredient(Smoothie smoothie, String ingredientToBeRemoved){
        smoothie.getIngredients()
                .removeIf(ingredient -> ingredient.equals(ingredientToBeRemoved));
    }

    private void addIngredient(Smoothie smoothie, String ingredientToBeAdded){
        if(!smoothie.getIngredients().contains(ingredientToBeAdded)){
            smoothie.getIngredients()
                    .add(ingredientToBeAdded);
        }
    }

    private Smoothie getByName(String name){
        List<Smoothie> smoothies = SmoothiesFakeRepository.getSmoothies();
        return smoothies.stream()
                .filter(smoothie -> smoothie.getName().equals(name))
                .findFirst().orElse(null);
    }

    private List<String> sort(List<String> ingredients){
        Collections.sort(ingredients);
        return ingredients;
    }

    private List<String> getIngredientsFromCommandLine(String[] commands){
        return Arrays.stream(commands).skip(0).map(String::trim).collect(Collectors.toList());
    }
}
