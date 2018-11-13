package com.zawadal.spring5recipeapp.repositiories;

import com.zawadal.spring5recipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
