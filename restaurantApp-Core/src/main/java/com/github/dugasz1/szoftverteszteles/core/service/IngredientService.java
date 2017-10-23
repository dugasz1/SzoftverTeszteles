package com.github.dugasz1.szoftverteszteles.core.service;

import com.github.dugasz1.szoftverteszteles.core.exceptions.*;
import com.github.dugasz1.szoftverteszteles.core.model.IngredientItem;

public interface IngredientService {
    public IngredientItem getIngredientItem(int id) throws NoNameException, StorageNotAvaibleException, StorageException, NoIngredientException, NotFoundException;

    public boolean updateIngredientItem(int id);
    public boolean updateIngredientItem(IngredientItem recipe) throws AlreadyExistingException, StorageException, StorageNotAvaibleException, NotFoundException;

    public boolean deleteIngredientItem(int id) throws StorageNotAvaibleException, StorageException, NotFoundException;
    public boolean deleteIngredientItem(IngredientItem recipe) throws StorageNotAvaibleException, StorageException, NotFoundException;
}
