package com.github.dugasz1.szoftverteszteles.service.dao;

import com.github.dugasz1.szoftverteszteles.core.exceptions.*;
import com.github.dugasz1.szoftverteszteles.core.model.Recipe;

public interface RecipeDAO {
    public Recipe getRecipe(int id) throws NotFoundException, StorageNotAvaibleException, StorageException, NoNameException, NoCategoryException, NoIngredientException;

    public boolean updateRecipe(int id);
    public boolean updateRecipe(Recipe recipe);

    public boolean deleteRecipe(int id);
    public boolean deleteRecipe(Recipe recipe);
}
