package com.zawadal.spring5recipeapp.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;


@Data
@EqualsAndHashCode(exclude = "recipe") //only @Data does not work without it
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;

    @OneToOne(fetch = FetchType.EAGER)  //fetch all the time (not only for demand)
    private UnitOfMeasure uom;

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
        this.uom = unitOfMeasure;
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure unitOfMeasure, Recipe recipe) {
        this.description = description;
        this.amount = amount;
        this.uom = unitOfMeasure;
        this.recipe = recipe;
    }

}
