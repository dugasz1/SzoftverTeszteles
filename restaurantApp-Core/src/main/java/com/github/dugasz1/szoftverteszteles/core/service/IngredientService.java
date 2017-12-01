package com.github.dugasz1.szoftverteszteles.core.service;

import com.github.dugasz1.szoftverteszteles.core.model.IngredientItem;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.ExistingProblemException;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.MissingArgumentException;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.StorageProblemException;

public interface IngredientService {

    IngredientItem getIngredientItem(int id) throws StorageProblemException, ExistingProblemException, MissingArgumentException;

    boolean updateIngredientItem(int id) throws StorageProblemException, ExistingProblemException;

    boolean updateIngredientItem(IngredientItem recipe) throws StorageProblemException, ExistingProblemException;

    boolean deleteIngredientItem(int id) throws StorageProblemException, ExistingProblemException;

    boolean deleteIngredientItem(IngredientItem recipe) throws StorageProblemException, ExistingProblemException;
}
