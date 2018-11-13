package com.zawadal.spring5recipeapp.repositiories;

import com.zawadal.spring5recipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
