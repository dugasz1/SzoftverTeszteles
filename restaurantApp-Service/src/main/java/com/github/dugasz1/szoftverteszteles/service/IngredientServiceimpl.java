package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.model.IngredientItem;
import com.github.dugasz1.szoftverteszteles.core.service.IngredientService;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.ExistingProblemException;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.MissingArgumentException;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.StorageProblemException;
import com.github.dugasz1.szoftverteszteles.service.dao.IngredientDAO;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.*;

public class IngredientServiceImpl implements IngredientService {

    private IngredientDAO ingredientDAO;

    public IngredientServiceImpl(IngredientDAO ingredientDAO) {
        this.ingredientDAO = ingredientDAO;
    }

    public IngredientItem getIngredientItem(int id) throws ExistingProblemException, StorageProblemException, MissingArgumentException {
        try {
            return ingredientDAO.getIngredientItem(id);
        } catch (NotFoundException e) {
            throw new ExistingProblemException();
        } catch (StorageException | StorageNotAvailableException e) {
            throw new StorageProblemException();
        } catch (WrongFormatException e) {
            throw new MissingArgumentException();
        }
    }

    public boolean updateIngredientItem(int id) {
        return ingredientDAO.updateIngredientItem(id);
    }

    public boolean updateIngredientItem(IngredientItem recipe) throws ExistingProblemException, StorageProblemException {
        try {
            return ingredientDAO.updateIngredientItem(recipe);
        } catch (NotFoundException | AlreadyExistingException e) {
            throw new ExistingProblemException();
        } catch (StorageNotAvailableException | StorageException e) {
            throw new StorageProblemException();
        }
    }

    public boolean deleteIngredientItem(int id) throws ExistingProblemException, StorageProblemException {
        try {
            return ingredientDAO.deleteIngredientItem(id);
        } catch (NotFoundException e) {
            throw new ExistingProblemException();
        } catch (StorageNotAvailableException | StorageException e) {
            throw new StorageProblemException();
        }
    }

    public boolean deleteIngredientItem(IngredientItem recipe) throws ExistingProblemException, StorageProblemException {
        try {
            return ingredientDAO.deleteIngredientItem(recipe);
        } catch (NotFoundException e) {
            throw new ExistingProblemException();
        } catch (StorageNotAvailableException | StorageException e) {
            throw new StorageProblemException();
        }
    }
}
