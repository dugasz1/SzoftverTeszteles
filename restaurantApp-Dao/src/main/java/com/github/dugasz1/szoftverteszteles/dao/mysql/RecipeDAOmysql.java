package com.github.dugasz1.szoftverteszteles.dao.mysql;

import com.github.dugasz1.szoftverteszteles.core.exceptions.NoCategoryException;
import com.github.dugasz1.szoftverteszteles.core.exceptions.NoIngredientException;
import com.github.dugasz1.szoftverteszteles.core.exceptions.NoNameException;
import com.github.dugasz1.szoftverteszteles.core.model.Category;
import com.github.dugasz1.szoftverteszteles.core.model.Recipe;
import com.github.dugasz1.szoftverteszteles.core.model.User;
import com.github.dugasz1.szoftverteszteles.core.model.Ingredient;
import com.github.dugasz1.szoftverteszteles.service.DatabaseException;
import com.github.dugasz1.szoftverteszteles.service.DatabaseNotAvaibleException;
import com.github.dugasz1.szoftverteszteles.service.NotFoundException;
import com.github.dugasz1.szoftverteszteles.service.RecipeDAO;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecipeDAOmysql implements RecipeDAO {
    private Connection conn;

    public RecipeDAOmysql(Connection conn){
        this.conn = conn;
    }
    public Recipe getRecipe(int id) throws NotFoundException, DatabaseNotAvaibleException, DatabaseException, NoNameException, NoCategoryException, NoIngredientException {
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
