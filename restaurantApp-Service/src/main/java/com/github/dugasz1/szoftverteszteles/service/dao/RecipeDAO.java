package com.github.dugasz1.szoftverteszteles.service.dao;

import com.github.dugasz1.szoftverteszteles.core.exceptions.*;
import com.github.dugasz1.szoftverteszteles.core.model.Recipe;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.NotFoundException;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.StorageException;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.StorageNotAvailableException;

public interface RecipeDAO {
    Recipe getRecipe(int id) throws NotFoundException, StorageNotAvailableException, StorageException, NoNameException, NoCategoryException, NoIngredientException;

    boolean updateRecipe(int id);
    boolean updateRecipe(Recipe recipe);

    boolean deleteRecipe(int id);
    boolean deleteRecipe(Recipe recipe);
}
