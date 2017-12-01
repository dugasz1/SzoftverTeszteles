package com.github.dugasz1.szoftverteszteles.service.dao;

import com.github.dugasz1.szoftverteszteles.core.model.Recipe;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.*;

public interface RecipeDAO {

    Recipe getRecipe(int id) throws NotFoundException, StorageException, StorageNotAvailableException, WrongFormatException;

    boolean updateRecipe(int id) throws NotFoundException, StorageNotAvailableException, StorageException, AlreadyExistingException;

    boolean updateRecipe(Recipe recipe) throws NotFoundException, StorageNotAvailableException, StorageException, AlreadyExistingException;

    boolean deleteRecipe(int id) throws NotFoundException, StorageNotAvailableException, StorageException;

    boolean deleteRecipe(Recipe recipe) throws NotFoundException, StorageNotAvailableException, StorageException;
}
