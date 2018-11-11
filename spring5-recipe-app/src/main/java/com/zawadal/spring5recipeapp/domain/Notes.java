package com.zawadal.spring5recipeapp.domain;

import javax.persistence.*;

@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //we do not specify CASCADE because we allow the Recipe to own this
    // IF WE DELETE Notes object WE DO NOT WANT TO DELETE Recipe object !!!!!!!!!!!!!!!!
    @OneToOne
    private Recipe recipe;

    //CLOB Character Large Object
    //BLOB Binary Large Object
    @Lob // It will be created as CLOB in database to allow user more input than Default in hibernate and JPA - 255 chars
    private String recipeNotes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public String getRecipeNotes() {
        return recipeNotes;
    }

    public void setRecipeNotes(String recipeNotes) {
        this.recipeNotes = recipeNotes;
    }
}
