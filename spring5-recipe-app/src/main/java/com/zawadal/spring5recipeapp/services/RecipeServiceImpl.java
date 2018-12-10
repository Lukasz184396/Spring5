package com.zawadal.spring5recipeapp.services;

import com.zawadal.spring5recipeapp.commands.RecipeCommand;
import com.zawadal.spring5recipeapp.converters.RecipeCommandToRecipe;
import com.zawadal.spring5recipeapp.converters.RecipeToRecipeCommand;
import com.zawadal.spring5recipeapp.domain.Recipe;
import com.zawadal.spring5recipeapp.repositiories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe, RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("I am in the service");
        
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
        return recipes;
    }

    @Override
    public Recipe findById(Long l) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(l);
        if (!recipeOptional.isPresent()) {
            throw new RuntimeException("Recipe Not Found");
        }
        return recipeOptional.get();
    }

    // We Make @Transactional because we go through the converters outside of the spring context;
    // Spring Data JPA repositories will implicitly start and end transaction;
    @Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand command) {
        Recipe detachedRecipe = recipeCommandToRecipe.convert(command); // detached from Hibernate Context
        Recipe savedRecipe = recipeRepository.save(detachedRecipe);
        log.debug("Saved RecipeId:" + savedRecipe);
        return recipeToRecipeCommand.convert(savedRecipe);
    }
}
