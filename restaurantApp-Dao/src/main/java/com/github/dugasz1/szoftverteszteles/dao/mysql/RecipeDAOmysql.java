package com.github.dugasz1.szoftverteszteles.dao.mysql;

import com.github.dugasz1.szoftverteszteles.core.model.Recipe;
import com.github.dugasz1.szoftverteszteles.service.dao.RecipeDAO;

import java.sql.Connection;

/*
 *TODO: Implement it!
 */
public class RecipeDAOmysql implements RecipeDAO {

    private Connection conn;

    public RecipeDAOmysql(Connection conn) {
        this.conn = conn;
    }

    public Recipe getRecipe(int id) {
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
