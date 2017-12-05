package com.github.dugasz1.szoftverteszteles.service.dao;

import com.github.dugasz1.szoftverteszteles.core.model.IngredientItem;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.*;

public interface IngredientItemDAO {

    IngredientItem getIngredientItem(int id) throws NotFoundException, StorageException, StorageNotAvailableException;

    boolean updateIngredientItem(int id) throws NotFoundException, StorageNotAvailableException, StorageException, AlreadyExistingException;

    boolean updateIngredientItem(IngredientItem recipe) throws NotFoundException, StorageNotAvailableException, StorageException, AlreadyExistingException;

    boolean deleteIngredientItem(int id) throws NotFoundException, StorageNotAvailableException, StorageException;

    boolean deleteIngredientItem(IngredientItem recipe) throws NotFoundException, StorageNotAvailableException, StorageException;
}
