package com.zawadal.spring5recipeapp.controllers;

import com.zawadal.spring5recipeapp.domain.Category;
import com.zawadal.spring5recipeapp.domain.UnitOfMeasure;
import com.zawadal.spring5recipeapp.repositiories.CategoryRepository;
import com.zawadal.spring5recipeapp.repositiories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage() {
        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        System.out.println("Category Id is: " + categoryOptional.get().getId());
        System.out.println("UnitOfMeasure Id is : " + unitOfMeasureOptional.get().getId());
        return "index";  // return name should match html in resources in templates folder
                         // -> index.hml
    }
}
