package com.github.dugasz1.szoftverteszteles.service.dao;

import com.github.dugasz1.szoftverteszteles.core.exceptions.EmptyNameException;
import com.github.dugasz1.szoftverteszteles.core.exceptions.NoIngredientException;
import com.github.dugasz1.szoftverteszteles.core.exceptions.NoIngredientItemException;
import com.github.dugasz1.szoftverteszteles.core.exceptions.NoNameException;
import com.github.dugasz1.szoftverteszteles.core.model.Ingredient;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.NotFoundException;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.StorageException;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.StorageNotAvailableException;

import java.util.Collection;

public interface IngredientDAO {

    Ingredient getIngredient(int id) throws NotFoundException, StorageException, StorageNotAvailableException;

    public Collection<Ingredient> getIngredientCollectionByRecipe(int recipe_id) throws NotFoundException, StorageNotAvailableException, StorageException;
}
