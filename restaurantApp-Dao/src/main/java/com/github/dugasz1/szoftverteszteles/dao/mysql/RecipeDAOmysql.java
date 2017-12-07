package com.github.dugasz1.szoftverteszteles.dao.mysql;

import com.github.dugasz1.szoftverteszteles.core.exceptions.*;
import com.github.dugasz1.szoftverteszteles.core.model.Category;
import com.github.dugasz1.szoftverteszteles.core.model.Ingredient;
import com.github.dugasz1.szoftverteszteles.core.model.MenuItem;
import com.github.dugasz1.szoftverteszteles.core.model.Recipe;
import com.github.dugasz1.szoftverteszteles.service.dao.CategoryDAO;
import com.github.dugasz1.szoftverteszteles.service.dao.IngredientItemDAO;
import com.github.dugasz1.szoftverteszteles.service.dao.IngredientDAO;
import com.github.dugasz1.szoftverteszteles.service.dao.MenuItemDAO;
import com.github.dugasz1.szoftverteszteles.service.dao.RecipeDAO;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.AlreadyExistingException;
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
    private IngredientDAO ingredientDAO;

    public RecipeDAOmysql(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void createRecipe(Recipe recipe) throws AlreadyExistingException, StorageException, StorageNotAvailableException {
        try {
            PreparedStatement statement = conn.prepareStatement("Insert Into recipe (name, category_id) VALUE (?,?)");
            statement.setString(1, recipe.getName());
            statement.setInt(2,recipe.getCategory().getId());
            statement.executeUpdate();

            PreparedStatement ps1 = conn.prepareStatement("insert into recipe_ingredient (recipe_id, ingredient_id, quantity) values (?,?,?)");
            for (int i = 0; i < recipe.getIngredients().size(); i++)
            {
                ps1.setInt(1, recipe.getId());
                ps1.setInt(2, recipe.getIngredients().iterator().next().getIngredientItem().getId());
                ps1.setFloat(3, recipe.getIngredients().iterator().next().getQuantity());
                ps1.executeUpdate();
            }

        }
        catch (CommunicationsException e) {
            throw new StorageNotAvailableException(e);
        }
        catch (SQLIntegrityConstraintViolationException e) {
            throw new AlreadyExistingException(e);
        }
        catch (SQLException e) {
            throw new StorageException(e);
        }

    }

    public Recipe getRecipe(int id) throws NotFoundException, StorageNotAvailableException, StorageException, NoCategoryException {
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
                recipe = new Recipe(rs.getInt("recipe.id"),rs.getString("recipe.name"), categoryDAO.getCategoryById(rs.getInt("recipe.category_id")),
                        ingredientDAO.getIngredientCollectionByRecipe(rs.getInt("recipe_ingredient.recipe_id")));
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
        catch (NoIngredientException e) {
            throw new StorageException(e);
        }
        return recipe;
    }

    public boolean updateRecipe(int id) {return false;
    }

    public boolean updateRecipe(Recipe recipe) throws StorageNotAvailableException, StorageException {
        try {
            PreparedStatement statement = conn.prepareStatement("UPDATE recipe SET id=?,name=?,category_id=? WHERE id=?");
            statement.setInt(1,recipe.getId());
            statement.setString(2,recipe.getName());
            statement.setInt(3,recipe.getCategory().getId());
            if(statement.execute())
                return true;
        } catch (SQLException e) {
            throw new StorageException(e);
        }
        return false;
    }

    public boolean deleteRecipe(int id) throws StorageNotAvailableException, StorageException {
       try {
           PreparedStatement statement = conn.prepareStatement("DELETE FROM recipe WHERE id = ?");
           statement.setInt(1,id);
           return statement.execute();
        } catch (SQLException e) {
            throw new StorageException(e);
        }
    }

    public boolean deleteRecipe(Recipe recipe) {
        return false;
    }
}
