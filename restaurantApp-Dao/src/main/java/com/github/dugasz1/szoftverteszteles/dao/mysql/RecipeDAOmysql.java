package com.github.dugasz1.szoftverteszteles.dao.mysql;

import com.github.dugasz1.szoftverteszteles.core.exceptions.NoCategoryException;
import com.github.dugasz1.szoftverteszteles.core.exceptions.NoIngredientException;
import com.github.dugasz1.szoftverteszteles.core.exceptions.NoNameException;
import com.github.dugasz1.szoftverteszteles.core.model.Recipe;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.StorageException;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.StorageNotAvailableException;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.NotFoundException;
import com.github.dugasz1.szoftverteszteles.service.dao.RecipeDAO;

import java.sql.Connection;

public class RecipeDAOmysql implements RecipeDAO {
    private Connection conn;

    public RecipeDAOmysql(Connection conn){
        this.conn = conn;
    }
    public Recipe getRecipe(int id) throws NotFoundException, StorageNotAvailableException, StorageException, NoNameException, NoCategoryException, NoIngredientException {
        return null;
    }

    public boolean updateRecipe(int id) {
        return false;
    }

    public boolean updateRecipe(Recipe recipe) {
        return false;
    }

    public boolean deleteRecipe(int id) {
        return false;
    }

    public boolean deleteRecipe(Recipe recipe) {
        return false;
    }
}
