package com.github.dugasz1.szoftverteszteles.dao.mysql;

import com.github.dugasz1.szoftverteszteles.core.exceptions.*;
import com.github.dugasz1.szoftverteszteles.core.model.Category;
import com.github.dugasz1.szoftverteszteles.core.model.Ingredient;
import com.github.dugasz1.szoftverteszteles.core.model.MenuItem;
import com.github.dugasz1.szoftverteszteles.core.model.Recipe;
import com.github.dugasz1.szoftverteszteles.service.dao.CategoryDAO;
import com.github.dugasz1.szoftverteszteles.service.dao.IngredientItemDAO;
import com.github.dugasz1.szoftverteszteles.service.dao.MenuItemDAO;
import com.github.dugasz1.szoftverteszteles.service.dao.RecipeDAO;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.NotFoundException;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.StorageException;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.StorageNotAvailableException;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

/*
 *TODO: Implement it!
 */
public class RecipeDAOmysql implements RecipeDAO {

    private Connection conn;
    private CategoryDAO categoryDAO;
    private IngredientItemDAO ingredientItemDAO;

    public RecipeDAOmysql(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void createRecipe(Recipe recipe) {

    }

    public Recipe getRecipe(int id) throws NotFoundException, StorageNotAvailableException, StorageException {
        String selectSQL = "select * from recipe inner join recipe_ingredient on recipe.id = recipe_ingredient.recipe_id" +
                " where id = ?";
        PreparedStatement ps;

        Recipe recipe = null;

        try {
            ps = conn.prepareStatement(selectSQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            boolean isExist = rs.next();
            if (isExist)
            {
                //recipe = new Recipe(rs.getInt("id"), categoryDAO.getCategoryById(rs.getInt("category_id")), );
            }
            else
            {
                throw new NotFoundException();
            }
        }
        catch (CommunicationsException e) {
            throw new StorageNotAvailableException(e);
        }
        catch (SQLException e) {
            throw new StorageException(e);
        }
        /*catch (EmptyNameException | NoNameException | NoIngredientException | NoIngredientItemException | NoRecipeException e) {
            throw new StorageException(e);
        }*/
        return recipe;
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
