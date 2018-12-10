package com.zawadal.spring5recipeapp.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //persistence framework generate identity value for us
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;

    @Lob
    private String directions;

    //EnumType.ORDINAL we need to fix ordinal number when we modify enum medium values
    @Enumerated(EnumType.STRING) //it is more safe when we add values to enum is recognize values by String name
    private Difficulty difficulty;

    /**
     * set up cascade to make Recipe owner of that
     * CascadeType.ALL - to persist all operation
     * this is BI_DIRECTIONAL - //we can navigate in both direction after adding @ManyToOne in Ingredient class
     * on private Set<Ingredient> ingredients;
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")  //mappedBy we want property in child claas "recipe"
    private Set<Ingredient> ingredients = new HashSet<>();

    @Lob
    private Byte[] images;

    //@OneToOne to create relationship for the OneToOne mapping
    @OneToOne(cascade = CascadeType.ALL)  //set up cascade to make Recipe owner of that
    private Notes notes;

    @ManyToMany
    @JoinTable(name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();

    public Recipe addIngredient(Ingredient ingredient) {
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
        return this;
    }


    public void setNotes(Notes notes) {
        if (notes != null) {
            this.notes = notes;
            notes.setRecipe(this);
        }
    }

}
