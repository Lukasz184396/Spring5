package com.zawadal.spring5recipeapp.services;

import com.zawadal.spring5recipeapp.commands.IngredientCommand;

public interface IngredientService {
    IngredientCommand findByRecipeIdAndIngredientId(Long l1, Long l2);
}
