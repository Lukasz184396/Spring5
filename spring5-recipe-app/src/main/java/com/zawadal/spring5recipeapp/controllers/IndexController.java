package com.zawadal.spring5recipeapp.controllers;

import com.zawadal.spring5recipeapp.domain.Category;
import com.zawadal.spring5recipeapp.domain.UnitOfMeasure;
import com.zawadal.spring5recipeapp.repositiories.CategoryRepository;
import com.zawadal.spring5recipeapp.repositiories.UnitOfMeasureRepository;
import com.zawadal.spring5recipeapp.services.RecipeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Slf4j
@Controller
public class IndexController {

    private final RecipeServiceImpl recipeServiceImpl;

    public IndexController(RecipeServiceImpl recipeServiceImpl) {
        this.recipeServiceImpl = recipeServiceImpl;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        log.debug("Getting Index page");

        model.addAttribute("recipes", recipeServiceImpl.getRecipes());
        return "index";
    }
}
