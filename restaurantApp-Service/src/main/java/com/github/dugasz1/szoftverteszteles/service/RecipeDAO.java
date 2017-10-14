package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.model.Recipe;

public interface RecipeDAO {
    public Recipe getRecipe(int id);

    public boolean updateRecipe(int id);
    public boolean updateRecipe(Recipe recipe);

    public boolean deleteRecipe(int id);
    public boolean deleteRecipe(Recipe recipe);
}
