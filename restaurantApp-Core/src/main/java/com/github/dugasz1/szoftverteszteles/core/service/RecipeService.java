package com.github.dugasz1.szoftverteszteles.core.service;

import com.github.dugasz1.szoftverteszteles.core.model.Recipe;

public interface RecipeService {
    Recipe getRecipe(int id);

    boolean updateRecipe(int id);

    boolean updateRecipe(Recipe recipe);

    boolean deleteRecipe(int id);

    boolean deleteRecipe(Recipe recipe);
}
