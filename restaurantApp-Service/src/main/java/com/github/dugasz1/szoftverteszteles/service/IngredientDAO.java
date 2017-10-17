package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.exceptions.NoIngredientException;
import com.github.dugasz1.szoftverteszteles.core.exceptions.NoNameException;
import com.github.dugasz1.szoftverteszteles.core.model.IngredientItem;

public interface IngredientDAO {
    public IngredientItem getIngredientItem(int id) throws NoIngredientException, NoNameException, NotFoundException, DatabaseException, DatabaseNotAvaibleException;

    public boolean updateIngredientItem(int id);
    public boolean updateIngredientItem(IngredientItem recipe) throws NotFoundException, DatabaseNotAvaibleException, AlreadyExistingException, DatabaseException;

    public boolean deleteIngredientItem(int id) throws NotFoundException, DatabaseNotAvaibleException, DatabaseException;
    public boolean deleteIngredientItem(IngredientItem recipe) throws NotFoundException, DatabaseNotAvaibleException, DatabaseException;
}
