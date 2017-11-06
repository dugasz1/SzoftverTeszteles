package com.github.dugasz1.szoftverteszteles.core.model;

import com.github.dugasz1.szoftverteszteles.core.exceptions.NoRecipeException;

public class MenuItem {
    private int id;
    private float price;
    private Recipe recipe;

    /**
     * Creates MenuItem object, do not use this use the dao interface.
     * @param id
     * @param price
     * @param recipe
     */
    public MenuItem(int id,float price,Recipe recipe) throws NoRecipeException
    {
        if(price < 0)
            throw new IllegalArgumentException("Price cannot be negative.");
        if(recipe == null)
            throw new NoRecipeException("MenuItem must have a Recipe.");
        this.id = id;
        this.price = price;
        this.recipe = recipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MenuItem menuItem = (MenuItem) o;

        return id == menuItem.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
