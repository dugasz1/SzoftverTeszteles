package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.exceptions.*;
import com.github.dugasz1.szoftverteszteles.core.model.Recipe;
import com.github.dugasz1.szoftverteszteles.core.service.RecipeService;
import com.github.dugasz1.szoftverteszteles.service.dao.RecipeDAO;

public class ReciepeServiceimpl implements RecipeService{

    private RecipeDAO recipeDAO = null;

    public ReciepeServiceimpl(RecipeDAO recipeDAO) {
        this.recipeDAO = recipeDAO;
    }

    public Recipe getRecipe(int id) throws NoCategoryException, StorageException, NoIngredientException, StorageNotAvaibleException, NotFoundException, NoNameException {
        return recipeDAO.getRecipe(id);
    }

    public boolean updateRecipe(int id) {
        return recipeDAO.updateRecipe(id);
    }

    public boolean updateRecipe(Recipe recipe) {
        return recipeDAO.updateRecipe(recipe);
    }

    public boolean deleteRecipe(int id) {
        return recipeDAO.deleteRecipe(id);
    }

    public boolean deleteRecipe(Recipe recipe) {
        return recipeDAO.deleteRecipe(recipe);
    }
}
