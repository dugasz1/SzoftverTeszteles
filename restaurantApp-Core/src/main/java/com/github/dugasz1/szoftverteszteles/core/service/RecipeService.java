package com.github.dugasz1.szoftverteszteles.core.service;

import com.github.dugasz1.szoftverteszteles.core.exceptions.*;
import com.github.dugasz1.szoftverteszteles.core.model.Recipe;

public interface RecipeService {
    public Recipe getRecipe(int id) throws NoCategoryException, StorageException, NoIngredientException, StorageNotAvaibleException, NotFoundException, NoNameException;

    public boolean updateRecipe(int id);
    public boolean updateRecipe(Recipe recipe);

    public boolean deleteRecipe(int id);
    public boolean deleteRecipe(Recipe recipe);
}
