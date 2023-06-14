package com.subway.domain;

import java.util.List;
import com.subway.entity.Ingredient;
import com.subway.entity.Sandwich;


public class Cook implements FoodRepository {
    
    Sandwich sandwich = new Sandwich();
    
    @Override
    public void addIngredient(Ingredient ingredient) {
        List<Ingredient> ingredients = sandwich.getIngredients();
        ingredients.add(ingredient);
        sandwich.setTotalCalorie(sandwich.getTotalCalorie()+ingredient.getCalorie());
        sandwich.setIngredients(ingredients);

    }
    
    @Override
    public void updateIngredient(Ingredient ingredient) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void deleteIngredient(Ingredient ingredient) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void printMenu() {
        List<Ingredient> ingredients = sandwich.getIngredients();
        for(Ingredient ingredient : ingredients) {
            System.out.println(ingredient.toString());            
        }
        
        
    }

    @Override
    public void printIngredient(Ingredient ingredient) {
        // TODO Auto-generated method stub
        
    }

    


}
