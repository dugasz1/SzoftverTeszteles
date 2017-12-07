package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.model.IngredientItem;
import com.github.dugasz1.szoftverteszteles.core.service.IngredientItemService;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.*;
import com.github.dugasz1.szoftverteszteles.service.dao.IngredientItemDAO;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.*;

public class IngredientItemServiceImpl implements IngredientItemService {

    private IngredientItemDAO ingredientItemDAO;

    public IngredientItemServiceImpl(IngredientItemDAO ingredientItemDAO) {
        this.ingredientItemDAO = ingredientItemDAO;
    }


    @Override
    public IngredientItem createIngredientItem() throws StorageProblemException, IngredientItemAlreadyExistException {
        return null;
    }

    @Override
    public IngredientItem getIngredientItem(int id) throws StorageProblemException, IngredientItemNotFoundException {
        try {
            return ingredientItemDAO.getIngredientItem(id);
        } catch (NotFoundException e) {
            throw new IngredientItemNotFoundException(e);
        } catch (StorageException | StorageNotAvailableException e) {
            throw new StorageProblemException(e);
        }
    }

    public boolean updateIngredientItem(int id) throws StorageProblemException, IngredientItemNotFoundException {
        try {
            return ingredientItemDAO.updateIngredientItem(id);
        } catch (NotFoundException | AlreadyExistingException e) {
            throw new IngredientItemNotFoundException(e);
        } catch (StorageNotAvailableException | StorageException e) {
            throw new StorageProblemException(e);
        }
    }

    public boolean updateIngredientItem(IngredientItem recipe) throws StorageProblemException, IngredientItemNotFoundException{
        try {
            return ingredientItemDAO.updateIngredientItem(recipe);
        } catch (NotFoundException | AlreadyExistingException e) {
            throw new IngredientItemNotFoundException(e);
        } catch (StorageNotAvailableException | StorageException e) {
            throw new StorageProblemException(e);
        }
    }

    public boolean deleteIngredientItem(int id) throws StorageProblemException, IngredientItemNotFoundException{
        try {
            return ingredientItemDAO.deleteIngredientItem(id);
        } catch (NotFoundException e) {
            throw new IngredientItemNotFoundException(e);
        } catch (StorageNotAvailableException | StorageException e) {
            throw new StorageProblemException(e);
        }
    }

    public boolean deleteIngredientItem(IngredientItem recipe) throws StorageProblemException, IngredientItemNotFoundException{
        try {
            return ingredientItemDAO.deleteIngredientItem(recipe);
        } catch (NotFoundException e) {
            throw new IngredientItemNotFoundException(e);
        } catch (StorageNotAvailableException | StorageException e) {
            throw new StorageProblemException(e);
        }
    }
}
