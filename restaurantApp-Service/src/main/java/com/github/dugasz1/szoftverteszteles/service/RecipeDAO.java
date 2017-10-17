package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.exceptions.NoCategoryException;
import com.github.dugasz1.szoftverteszteles.core.exceptions.NoIngredientException;
import com.github.dugasz1.szoftverteszteles.core.exceptions.NoNameException;
import com.github.dugasz1.szoftverteszteles.core.model.Recipe;

public interface RecipeDAO {
    public Recipe getRecipe(int id) throws NotFoundException, DatabaseNotAvaibleException, DatabaseException, NoNameException, NoCategoryException, NoIngredientException;

    public boolean updateRecipe(int id);
    public boolean updateRecipe(Recipe recipe);

    public boolean deleteRecipe(int id);
    public boolean deleteRecipe(Recipe recipe);
}
