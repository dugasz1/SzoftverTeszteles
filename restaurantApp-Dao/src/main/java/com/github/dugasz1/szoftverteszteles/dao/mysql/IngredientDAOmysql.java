package com.github.dugasz1.szoftverteszteles.dao.mysql;

import com.github.dugasz1.szoftverteszteles.core.exceptions.*;
import com.github.dugasz1.szoftverteszteles.core.model.Ingredient;
import com.github.dugasz1.szoftverteszteles.core.model.IngredientItem;
import com.github.dugasz1.szoftverteszteles.core.model.Nutritions;
import com.github.dugasz1.szoftverteszteles.service.dao.IngredientItemDAO;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.NotFoundException;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.StorageException;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.StorageNotAvailableException;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class IngredientDAOmysql {
    private IngredientItemDAO ingredientItemDAO;

    private Connection conn;

    public IngredientDAOmysql(Connection conn) {
        this.conn = conn;
    }

    public Ingredient getIngredient(int id) throws NotFoundException, StorageNotAvailableException, StorageException, NoIngredientItemException {
        String selectSQL = "SELECT * FROM recipe_ingredient WHERE ingredient_id = ?";
        PreparedStatement ps;
        Ingredient ingredient;
        try {
            ps = conn.prepareStatement(selectSQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            boolean isExist = rs.next();
            if (isExist) {
                ingredient = new Ingredient(ingredientItemDAO.getIngredientItem(id), rs.getFloat("quantity"));
            } else {
                throw new NotFoundException();
            }
        } catch (CommunicationsException e) {
            throw new StorageNotAvailableException(e);
        } catch (SQLException e) {
            throw new StorageException(e);
        }
        return ingredient;
    }

    private Ingredient grabIngredient(ResultSet rs) throws SQLException, EmptyNameException, NoNameException, NoIngredientException, NoIngredientItemException {
        IngredientItem ingredientItem = new IngredientItem(rs.getInt("ingredient.id"), rs.getString("ingredient.name"),
                new Nutritions(rs.getFloat("ingredient.fat"), rs.getFloat("ingredient.energy"),
                        rs.getFloat("ingredient.carbohydrate"), rs.getFloat("ingredient.protein"),
                        rs.getFloat("ingredient.salt")),rs.getString("ingredient.unit"));
        Ingredient ingredient = new Ingredient(ingredientItem, rs.getFloat("recipe_ingredient.quantity"));
        return ingredient;
    }

    public Collection<Ingredient> getIngredientCollectionByRecipe(int recipe_id) throws NotFoundException, StorageNotAvailableException, StorageException {
        Collection<Ingredient> ingredients = new ArrayList<>();

        String selectSQL = "SELECT * FROM recipe_ingredient inner join ingredient on " +
                "recipe_ingredient.ingredient_id = ingredient.id WHERE recipe_id = ?";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(selectSQL);
            ps.setInt(1, recipe_id);
            ResultSet rs = ps.executeQuery();
            boolean isExist = rs.next();

            if (isExist) {

                ingredients.add(grabIngredient(rs));
            }
            else {
                throw new NotFoundException();
            }
        } catch (CommunicationsException e) {
            throw new StorageNotAvailableException(e);
        } catch (SQLException e) {
            throw new StorageException(e);
        }
        catch (EmptyNameException | NoNameException | NoIngredientException | NoIngredientItemException e) {
            throw new StorageException(e);
        }

        return ingredients;
    }
}
