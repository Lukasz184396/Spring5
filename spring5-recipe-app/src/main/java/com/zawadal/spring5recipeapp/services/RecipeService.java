package com.zawadal.spring5recipeapp.services;

import com.zawadal.spring5recipeapp.commands.RecipeCommand;
import com.zawadal.spring5recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    RecipeCommand findCommandById(Long l);

    void deleteById(Long idToDelete);
}
