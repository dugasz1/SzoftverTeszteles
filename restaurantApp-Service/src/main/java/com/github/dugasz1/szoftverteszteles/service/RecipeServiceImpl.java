package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.exceptions.NoCategoryException;
import com.github.dugasz1.szoftverteszteles.core.model.Category;
import com.github.dugasz1.szoftverteszteles.core.model.Ingredient;
import com.github.dugasz1.szoftverteszteles.core.model.Recipe;
import com.github.dugasz1.szoftverteszteles.core.service.RecipeService;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.ExistingProblemException;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.MissingArgumentException;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.StorageProblemException;
import com.github.dugasz1.szoftverteszteles.service.dao.CategoryDAO;
import com.github.dugasz1.szoftverteszteles.service.dao.IngredientDAO;
import com.github.dugasz1.szoftverteszteles.service.dao.RecipeDAO;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.*;

public class RecipeServiceImpl implements RecipeService {

    private RecipeDAO recipeDAO;
    private CategoryDAO categoryDAO;
    private IngredientDAO ingredientDAO;

    public RecipeServiceImpl(RecipeDAO recipeDAO) {
        this.recipeDAO = recipeDAO;
        this.categoryDAO = categoryDAO;
        this.ingredientDAO = ingredientDAO;
    }

    public Recipe getRecipe(int id) throws ExistingProblemException, StorageProblemException, MissingArgumentException, NoCategoryException {
        try {
            return recipeDAO.getRecipe(id);
        } catch (NotFoundException e) {
            throw new ExistingProblemException();
        } catch (StorageException | StorageNotAvailableException e) {
            throw new StorageProblemException();
        }
    }

    public boolean updateRecipe(int id) throws ExistingProblemException, StorageProblemException {
        try {
            return recipeDAO.updateRecipe(id);
        } catch (NotFoundException | AlreadyExistingException e) {
            throw new ExistingProblemException();
        } catch (StorageNotAvailableException | StorageException e) {
            throw new StorageProblemException();
        }
    }

    public boolean updateRecipe(Recipe recipe) throws ExistingProblemException, StorageProblemException {
        try {
            return recipeDAO.updateRecipe(recipe);
        } catch (NotFoundException | AlreadyExistingException e) {
            throw new ExistingProblemException();
        } catch (StorageNotAvailableException | StorageException e) {
            throw new StorageProblemException();
        }
    }

    public boolean deleteRecipe(int id) throws StorageProblemException, ExistingProblemException {
        try {
            return recipeDAO.deleteRecipe(id);
        } catch (NotFoundException e) {
            throw new ExistingProblemException();
        } catch (StorageNotAvailableException | StorageException e) {
            throw new StorageProblemException();
        }
    }

    public boolean deleteRecipe(Recipe recipe) throws ExistingProblemException, StorageProblemException {
        try {
            return recipeDAO.deleteRecipe(recipe);
        } catch (NotFoundException e) {
            throw new ExistingProblemException();
        } catch (StorageNotAvailableException | StorageException e) {
            throw new StorageProblemException();
        }
    }

}
