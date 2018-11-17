package com.zawadal.spring5recipeapp.domain;


import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.Set;

//TODO check why @Data does not work here - hwy we need to stay here getter and setter for recipes???
@Getter
@Setter
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }
}
