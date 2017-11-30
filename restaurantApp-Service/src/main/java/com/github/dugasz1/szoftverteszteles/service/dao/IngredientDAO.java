package com.github.dugasz1.szoftverteszteles.service.dao;

import com.github.dugasz1.szoftverteszteles.core.model.IngredientItem;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.*;

public interface IngredientDAO {
    IngredientItem getIngredientItem(int id) throws NotFoundException, StorageException, StorageNotAvailableException, WrongFormatException;

    boolean updateIngredientItem(int id);

    boolean updateIngredientItem(IngredientItem recipe) throws NotFoundException, StorageNotAvailableException, StorageException, AlreadyExistingException;

    boolean deleteIngredientItem(int id) throws NotFoundException, StorageNotAvailableException, StorageException;

    boolean deleteIngredientItem(IngredientItem recipe) throws NotFoundException, StorageNotAvailableException, StorageException;
}
