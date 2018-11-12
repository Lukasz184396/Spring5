package com.zawadal.spring5recipeapp.domain;

import javax.persistence.*;
import java.util.Set;

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
    private String directions;
    //todo add
    //private Difficulty difficulty;

    /**
     * set up cascade to make Recipe owner of that
     * CascadeType.ALL - to persist all operation
     * this is BI_DIRECTIONAL - //we can navigate in both direction after adding @ManyToOne in Ingredient class
     * on private Set<Ingredient> ingredients;
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")  //mappedBy we want property in child claas "recipe"
    private Set<Ingredient> ingredients;

    @Lob
    private Byte[] images;

    //@OneToOne to create relationship for the OneToOne mapping
    @OneToOne(cascade = CascadeType.ALL)  //set up cascade to make Recipe owner of that
    private Notes notes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public Byte[] getImages() {
        return images;
    }

    public void setImages(Byte[] images) {
        this.images = images;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }
}
