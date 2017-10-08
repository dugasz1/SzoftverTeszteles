package com.github.dugasz1.szoftverteszteles.core.menu;

import java.util.Collection;

public class Recipe {
    private int id;
    private Category category;
    private Collection<Ingredient> ingredients;

    public Recipe (int id, Category category, Collection<Ingredient> ingredients){
        if(category == null)
            throw new NullPointerException("Category can not be null.");
        if(ingredients == null)
            throw new NullPointerException("Ingredient can not be null.");
        if(ingredients.isEmpty())
            throw new IllegalArgumentException("Recipe must contain at least one ingredient.");

        this.id = id;
        this.category = category;
        this.ingredients = ingredients;
    }

    public int getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Collection<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Collection<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
