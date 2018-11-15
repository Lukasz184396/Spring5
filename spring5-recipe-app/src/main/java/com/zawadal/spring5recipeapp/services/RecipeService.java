package com.zawadal.spring5recipeapp.services;

import com.zawadal.spring5recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
