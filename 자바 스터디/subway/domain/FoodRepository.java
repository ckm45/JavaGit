package com.subway.domain;

import com.subway.entity.Ingredient;

public interface FoodRepository {
    
    
    void addIngredient(Ingredient ingredient);

    void updateIngredient(Ingredient ingredient);

    void deleteIngredient(Ingredient ingredient);

    void printMenu();

    void printIngredient(Ingredient ingredient);

}
