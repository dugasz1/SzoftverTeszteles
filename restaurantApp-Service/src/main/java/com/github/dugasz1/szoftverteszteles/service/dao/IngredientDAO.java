package com.github.dugasz1.szoftverteszteles.service.dao;

import com.github.dugasz1.szoftverteszteles.core.exceptions.*;
import com.github.dugasz1.szoftverteszteles.core.model.IngredientItem;

public interface IngredientDAO {
    public IngredientItem getIngredientItem(int id) throws NoIngredientException, NoNameException, NotFoundException, StorageException, StorageNotAvaibleException;

    public boolean updateIngredientItem(int id);
    public boolean updateIngredientItem(IngredientItem recipe) throws NotFoundException, StorageNotAvaibleException, AlreadyExistingException, StorageException;

    public boolean deleteIngredientItem(int id) throws NotFoundException, StorageNotAvaibleException, StorageException;
    public boolean deleteIngredientItem(IngredientItem recipe) throws NotFoundException, StorageNotAvaibleException, StorageException;
}
