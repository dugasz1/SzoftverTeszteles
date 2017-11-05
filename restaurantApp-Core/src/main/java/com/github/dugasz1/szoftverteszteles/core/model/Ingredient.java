package com.github.dugasz1.szoftverteszteles.core.model;

import com.github.dugasz1.szoftverteszteles.core.exceptions.NoIngredientItemException;

public class Ingredient {
    private IngredientItem ingredientItem;
    private float quantity;

    /**
     * Creates Ingredient object, do not use this use the dao interface.
     * @param ingredientItem
     * @param quantity
     */
    public Ingredient(IngredientItem ingredientItem, float quantity)throws NoIngredientItemException
    {
        setIngredientItem(ingredientItem);
        setQuantity(quantity);
    }

    public float getQuantity() {
        return quantity;
    }

    public IngredientItem getIngredientItem() {
        return ingredientItem;
    }

    public void setIngredientItem(IngredientItem ingredientItem) throws NoIngredientItemException {
        if(ingredientItem == null)
            throw new NoIngredientItemException("IngredientItem cannot be empty.");
        this.ingredientItem = ingredientItem;
    }

    public void setQuantity(float quantity) throws IllegalArgumentException {
        if(quantity < 1)
            throw  new IllegalArgumentException("Quantity cannot be negative or zero.");
        this.quantity = quantity;
    }
}
