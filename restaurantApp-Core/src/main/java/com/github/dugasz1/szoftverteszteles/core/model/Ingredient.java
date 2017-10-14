package com.github.dugasz1.szoftverteszteles.core.model;

import com.github.dugasz1.szoftverteszteles.core.exceptions.NoIngredientException;

public class Ingredient {
    private IngredientItem ingredientItem;
    private float quantity;

    /**
     * Creates Ingredient object, do not use this use the dao interface.
     * @param ingredientItem
     * @param quantity
     */
    public Ingredient(IngredientItem ingredientItem, float quantity)throws NoIngredientException
    {
        if(ingredientItem == null)
            throw new NoIngredientException("IngredientItem cannot be empty.");
        if(quantity < 1)
            throw  new IllegalArgumentException("Quantity cannot be negative or zero.");
        this.ingredientItem = ingredientItem;
        this.quantity = quantity;
    }

    public float getQuantity() {
        return quantity;
    }

    public IngredientItem getIngredientItem() {
        return ingredientItem;
    }

    public void setIngredientItem(IngredientItem ingredientItem) {
        this.ingredientItem = ingredientItem;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }
}
