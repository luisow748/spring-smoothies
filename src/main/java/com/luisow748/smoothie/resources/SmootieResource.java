package com.luisow748.smoothie.resources;

import com.luisow748.smoothie.service.SmoothieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SmootieResource {

    private final SmoothieService smoothieService;

    public SmootieResource(SmoothieService smoothieService) {
        this.smoothieService = smoothieService;
    }

    @GetMapping("/{command}")
    List<String> getIngredients(@PathVariable String command) {
        String[] commands = command.split(",");
        String smoothieName = commands[0];
        return smoothieService.getIngredientsUpdated(smoothieName, commands);
    }
}
