package com.github.dugasz1.szoftverteszteles.core.service;

import com.github.dugasz1.szoftverteszteles.core.model.Recipe;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.ExistingProblemException;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.MissingArgumentException;
import com.github.dugasz1.szoftverteszteles.core.service.exceptions.StorageProblemException;

public interface RecipeService {
    Recipe getRecipe(int id) throws StorageProblemException, ExistingProblemException, MissingArgumentException;

    boolean updateRecipe(int id) throws StorageProblemException, ExistingProblemException;

    boolean updateRecipe(Recipe recipe) throws StorageProblemException, ExistingProblemException;

    boolean deleteRecipe(int id) throws StorageProblemException, ExistingProblemException;

    boolean deleteRecipe(Recipe recipe) throws StorageProblemException, ExistingProblemException;
}
