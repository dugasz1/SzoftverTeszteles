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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ingredient that = (Ingredient) o;

        if (Float.compare(that.quantity, quantity) != 0) return false;
        return ingredientItem != null ? ingredientItem.equals(that.ingredientItem) : that.ingredientItem == null;
    }

    @Override
    public int hashCode() {
        int result = ingredientItem != null ? ingredientItem.hashCode() : 0;
        result = 31 * result + (quantity != +0.0f ? Float.floatToIntBits(quantity) : 0);
        return result;
    }
}
