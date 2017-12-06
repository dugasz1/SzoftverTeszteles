package com.github.dugasz1.szoftverteszteles.dao.mysql;

import com.github.dugasz1.szoftverteszteles.core.exceptions.*;
import com.github.dugasz1.szoftverteszteles.core.model.*;
import com.github.dugasz1.szoftverteszteles.core.model.MenuItem;
import com.github.dugasz1.szoftverteszteles.service.dao.MenuItemDAO;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.*;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import java.awt.*;
import java.sql.*;
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

    public boolean updateMenuItem(MenuItem menuItem) throws NotFoundException, StorageNotAvailableException, AlreadyExistingException, StorageException {

        String updateSQL = "UPDATE menu SET price = ? recipe_id = ? WHERE id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(updateSQL);
            ps.setFloat(1, menuItem.getPrice());
            ps.setInt(2, menuItem.getRecipe().getId());
            ps.setInt(3, menuItem.getId());

            if (ps.executeUpdate() == 0) {
                throw new NotFoundException();
            }
        }
        catch (CommunicationsException e) {
            throw new StorageNotAvailableException();
        }
        catch (SQLIntegrityConstraintViolationException e) {
            throw new AlreadyExistingException();
        }
        catch (SQLException e) {
            throw new StorageException();
        }
        return true;
    }

    public boolean deleteMenuItem(int id) throws NotFoundException, StorageNotAvailableException, StorageException {
        String deleteSQL = "DELETE FROM menu WHERE id = ?";
        //tranzitivity
        String deleteSQL_order_menu = "DELETE FROM order_menu WHERE menu_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(deleteSQL_order_menu);
            ps.setInt(1, id);
            if (ps.executeUpdate() == 0) {
                throw new NotFoundException();
            }

            PreparedStatement ps1 = conn.prepareStatement(deleteSQL);
            ps1.setInt(1, id);
            if (ps1.executeUpdate() == 0) {
                throw new NotFoundException();
            }
        }
        catch (CommunicationsException e) {
            throw new StorageNotAvailableException();
        }
        catch (SQLException e) {
            throw new StorageException();
        }
        return true;
    }

    public boolean deleteMenuItem(MenuItem menuItem) throws NotFoundException, StorageNotAvailableException, StorageException {
        String deleteSQL = "DELETE FROM menu WHERE id = ?";
        //tranzitivity
        String deleteSQL_order_menu = "DELETE FROM order_menu WHERE menu_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(deleteSQL_order_menu);
            ps.setInt(1, menuItem.getId());
            if (ps.executeUpdate() == 0) {
                throw new NotFoundException();
            }

            PreparedStatement ps1 = conn.prepareStatement(deleteSQL);
            ps1.setInt(1, menuItem.getId());
            if (ps1.executeUpdate() == 0) {
                throw new NotFoundException();
            }
        }
        catch (CommunicationsException e) {
            throw new StorageNotAvailableException();
        }
        catch (SQLException e) {
            throw new StorageException();
        }
        return true;
    }
}
