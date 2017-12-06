package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.exceptions.NoIngredientException;
import com.github.dugasz1.szoftverteszteles.core.model.Ingredient;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.StorageProblemException;
import com.github.dugasz1.szoftverteszteles.service.dao.IngredientDAO;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.NotFoundException;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.StorageException;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.StorageNotAvailableException;

public class IngredientServiceImpl {
    private IngredientDAO ingredientDAO;

    public IngredientServiceImpl(IngredientDAO ingredientDAO) {
        this.ingredientDAO = ingredientDAO;
    }

    public Ingredient createIngredient() throws StorageProblemException {
        return null;
    }

    public Ingredient getIngredient(int id) throws StorageProblemException, NoIngredientException {
        try {
            return ingredientDAO.getIngredient(id);
        }
        catch (NotFoundException e) {
            throw new NoIngredientException(e);
        }
        catch (StorageException | StorageNotAvailableException e) {
            throw new StorageProblemException(e);
        }
    }

}



