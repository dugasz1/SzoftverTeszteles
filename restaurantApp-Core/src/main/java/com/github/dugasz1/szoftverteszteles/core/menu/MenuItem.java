package com.github.dugasz1.szoftverteszteles.core.menu;

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
    public MenuItem(int id,float price,Recipe recipe)
    {
        if(price < 0)
            throw new IllegalArgumentException("Price cannot be negative.");
        if(recipe == null)
            throw new NullPointerException("Recipe cannot be null.");
        this.id = id;
        this.price = price;
        this.recipe = recipe;
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
