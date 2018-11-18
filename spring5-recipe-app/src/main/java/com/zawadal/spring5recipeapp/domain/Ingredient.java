package com.zawadal.spring5recipeapp.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

//Todo check why @Data does not work
@Getter
@Setter
@Entity
public class Ingredient  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;

    @OneToOne(fetch = FetchType.EAGER)  //fetch all the time (not only for demand)
    private UnitOfMeasure unitOfMeasure;

    /**
     * Added Many to One to in this class to make inverse side of relationship (now is BI_DIRECTIONAL)
     * we can navigate in both direction
     */
    @ManyToOne// do not set up cascade because when we delete Ingredient we do not want to delete Recipe!!
    private Recipe recipe;

    public Ingredient() {
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure unitOfMeasure) {
        this.description = description;
        this.amount = amount;
        this.unitOfMeasure = unitOfMeasure;
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure unitOfMeasure, Recipe recipe) {
        this.description = description;
        this.amount = amount;
        this.unitOfMeasure = unitOfMeasure;
        this.recipe = recipe;
    }

}
