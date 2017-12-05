package com.github.dugasz1.szoftverteszteles.core.service;

import com.github.dugasz1.szoftverteszteles.core.model.IngredientItem;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.*;

public interface IngredientItemService {

    IngredientItem createIngredientItem() throws StorageProblemException, IngredientItemAlreadyExistException;

    IngredientItem getIngredientItem(int id) throws StorageProblemException, IngredientItemNotFoundException;

    boolean updateIngredientItem(IngredientItem recipe) throws StorageProblemException, IngredientItemNotFoundException;

    boolean deleteIngredientItem(int id) throws StorageProblemException, IngredientItemNotFoundException;

    boolean deleteIngredientItem(IngredientItem recipe) throws StorageProblemException, IngredientItemNotFoundException;
}
