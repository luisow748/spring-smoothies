package com.luisow748.smoothie.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class SmoothieServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void Should_create_Classic_smoothie_plus_chocolate() throws Exception {
        String smoothieName = "Classic";
        this.mockMvc.perform(get("/" + smoothieName + ",+chocolate"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("[\"banana\",\"chocolate\",\"honey\",\"ice\",\"mango\",\"peach\",\"pineapple\",\"strawberry\",\"yogurt\"]"));
    }

    @Test
    void Should_create_Classic_smoothie_plus_chocolate_minus_strawberry() throws Exception {
        String smoothieName = "Classic";
        this.mockMvc.perform(get("/" + smoothieName + ",+chocolate,-strawberry"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("[\"banana\",\"chocolate\",\"honey\",\"ice\",\"mango\",\"peach\",\"pineapple\",\"yogurt\"]"));
    }

    @Test
    void Should_create_Classic_smoothie() throws Exception {
        String smoothieName = "Classic";
        this.mockMvc.perform(get("/" + smoothieName + ""))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("[\"banana\",\"honey\",\"ice\",\"mango\",\"peach\",\"pineapple\",\"strawberry\",\"yogurt\"]"));
    }

    @Test
    void Should_create_Classic_smoothie_minus_strawberry() throws Exception {
        String smoothieName = "Classic";
        this.mockMvc.perform(get("/" + smoothieName + ",-strawberry"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("[\"banana\",\"honey\",\"ice\",\"mango\",\"peach\",\"pineapple\",\"yogurt\"]"));
    }

    @Test
    void Should_create_Just_Desserts_smoothie() throws Exception {
        String smoothieName = "Just Desserts";
        this.mockMvc.perform(get("/" + smoothieName + ""))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("[\"banana\",\"cherry\",\"chocolate\",\"ice cream\",\"peanut\"]"));
    }

    @Test
    void Should_create_Just_Desserts_smoothie_without_ice_cream_and_peanut() throws Exception {
        String smoothieName = "Just Desserts";
        this.mockMvc.perform(get("/" + smoothieName + ",-ice cream,-peanut"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("[\"banana\",\"cherry\",\"chocolate\"]"));
    }

    @Test
    void Should_create_Just_Desserts_smoothie_without_ingredients() throws Exception {
        String smoothieName = "Just Desserts";
        this.mockMvc.perform(get("/" + smoothieName + ",-banana,-cherry,-chocolate,-ice cream,-peanut"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));
    }

    @Test
    void Should_remove_unused_ingredients_from_Classic_smoothie() throws Exception {
        String smoothieName = "Classic";
        this.mockMvc.perform(get("/" + smoothieName + ",-banana,-mango,-peanut"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("[\"honey\",\"ice\",\"peach\",\"pineapple\",\"strawberry\",\"yogurt\"]"));
    }

}