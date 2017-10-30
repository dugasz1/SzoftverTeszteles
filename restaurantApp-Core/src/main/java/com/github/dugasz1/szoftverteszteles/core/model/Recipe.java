package com.github.dugasz1.szoftverteszteles.core.model;

import com.github.dugasz1.szoftverteszteles.core.exceptions.NoCategoryException;
import com.github.dugasz1.szoftverteszteles.core.exceptions.NoIngredientException;

import java.util.Collection;

public class Recipe {
    private int id;
    private Category category;
    private Collection<Ingredient> ingredients;

    public Recipe (int id, Category category, Collection<Ingredient> ingredients)throws NoIngredientException,NoCategoryException{
        if(category == null)
            throw new NoCategoryException("Recipe must have a Category");
        if(ingredients == null)
            throw new NoIngredientException("Recipe must have an Ingredients.");
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

    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        Recipe recipe = (Recipe) obj;
        if(this.id != recipe.id || !this.category.equals(recipe.category) || this.ingredients != recipe.ingredients)
            return false;
        return true;
    }
}
