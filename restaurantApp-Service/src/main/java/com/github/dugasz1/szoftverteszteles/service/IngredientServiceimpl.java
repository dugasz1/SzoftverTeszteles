package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.exceptions.*;
import com.github.dugasz1.szoftverteszteles.core.model.IngredientItem;
import com.github.dugasz1.szoftverteszteles.core.service.IngredientService;
import com.github.dugasz1.szoftverteszteles.service.dao.IngredientDAO;

public class IngredientServiceimpl implements IngredientService{

    private IngredientDAO ingredientDAO = null;

    public IngredientServiceimpl(IngredientDAO ingredientDAO) {
        this.ingredientDAO = ingredientDAO;
    }

    public IngredientItem getIngredientItem(int id) throws NoNameException, StorageNotAvaibleException, StorageException, NoIngredientException, NotFoundException {
        return ingredientDAO.getIngredientItem(id);
    }

    public boolean updateIngredientItem(int id) {
        return ingredientDAO.updateIngredientItem(id);
    }

    public boolean updateIngredientItem(IngredientItem recipe) throws AlreadyExistingException, StorageException, StorageNotAvaibleException, NotFoundException {
        return ingredientDAO.updateIngredientItem(recipe);
    }

    public boolean deleteIngredientItem(int id) throws StorageNotAvaibleException, StorageException, NotFoundException {
        return ingredientDAO.deleteIngredientItem(id);
    }

    public boolean deleteIngredientItem(IngredientItem recipe) throws StorageNotAvaibleException, StorageException, NotFoundException {
        return ingredientDAO.deleteIngredientItem(recipe);
    }
}
