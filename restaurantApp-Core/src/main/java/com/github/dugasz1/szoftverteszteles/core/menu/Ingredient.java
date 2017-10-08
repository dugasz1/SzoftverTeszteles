package com.github.dugasz1.szoftverteszteles.core.menu;

public class Ingredient {
    private IngredientItem ingredientItem;
    private float quantity;

    /**
     * Creates Ingredient object, do not use this use the dao interface.
     * @param ingredientItem
     * @param quantity
     */
    public Ingredient(IngredientItem ingredientItem, float quantity)
    {
        if(ingredientItem == null)
            throw new NullPointerException("ingredientItem cannot be null.");
        if(quantity < 0)
            throw  new IllegalArgumentException("quantity cannot be negative.");
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
