package com.github.dugasz1.szoftverteszteles.dao.mysql;

import com.github.dugasz1.szoftverteszteles.core.exceptions.*;
import com.github.dugasz1.szoftverteszteles.core.model.*;
import com.github.dugasz1.szoftverteszteles.core.model.MenuItem;
import com.github.dugasz1.szoftverteszteles.service.dao.MenuItemDAO;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.NotFoundException;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.StorageException;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.StorageNotAvailableException;
//import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.WrongFormatException;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;


public class MenuItemDAOmysql implements MenuItemDAO {
    private Connection conn;

    public MenuItemDAOmysql(Connection conn) {
        this.conn = conn;
    }

    public void createMenuItem(MenuItem menuItem) {

    }

    private Ingredient grabIngredientItem(ResultSet rs) throws SQLException, EmptyNameException, NoNameException, NoIngredientException, NoIngredientItemException {
        IngredientItem ingredientItem = new IngredientItem(rs.getInt("ingredient.id"), rs.getString("ingredient.name"),
                new Nutritions(rs.getFloat("ingredient.fat"), rs.getFloat("ingredient.energy"), rs.getFloat("carbohydrate"), rs.getFloat("protein"),
                        rs.getFloat("salt")),rs.getString("unit"));
        Ingredient ingredient = new Ingredient(ingredientItem, rs.getFloat("quantity"));
        return ingredient;
    }

    public MenuItem getMenuItem(int id) throws NotFoundException, StorageNotAvailableException, StorageException, NoCategoryException {
        String selectSQL = "select * from menu inner join recipe on menu.recipe_id = recipe.id \n" +
                "inner join category on recipe.category_id = category.id \n" +
                "inner join recipe_ingredient on recipe.id = recipe_ingredient.recipe_id \n" +
                "inner join ingredient on recipe_ingredient.ingredient_id = ingredient.id WHERE menu.id = ?";
        PreparedStatement ps;

        MenuItem menuItem = null;

        try {
            ps = conn.prepareStatement(selectSQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            boolean isExist = rs.next();
            if (isExist) {
                Collection<Ingredient> ingredients = new ArrayList<>();
                ingredients.add(grabIngredientItem(rs));
                while (rs.next()){
                    ingredients.add(grabIngredientItem(rs));
                }
                Category category = new Category(rs.getInt("category.id"), rs.getString("category.name"));
                Recipe recipe = new Recipe(rs.getInt("recipe.id"),category, ingredients);
                menuItem = new MenuItem(rs.getInt("menu.id"), rs.getFloat("menu.price"), recipe);
            } else {
                throw new NotFoundException();
            }
        }
        catch (CommunicationsException e) {
            throw new StorageNotAvailableException();
        }
        catch (SQLException e) {
            throw new StorageException(e);
        }
        catch (EmptyNameException | NoNameException | NoIngredientException | NoIngredientItemException | NoRecipeException e) {
            throw new StorageException(e);
        }
        return menuItem;
    }

    public boolean updateMenuItem(MenuItem menuItem) {
        return false;
    }

    public boolean deleteMenuItem(int id) {
        return false;
    }

    public boolean deleteMenuItem(MenuItem menuItem) {
        return false;
    }
}
