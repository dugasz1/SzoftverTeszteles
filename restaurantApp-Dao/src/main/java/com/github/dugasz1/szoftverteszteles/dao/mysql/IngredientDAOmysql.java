package com.github.dugasz1.szoftverteszteles.dao.mysql;


import com.github.dugasz1.szoftverteszteles.core.exceptions.NoIngredientException;
import com.github.dugasz1.szoftverteszteles.core.exceptions.NoNameException;
import com.github.dugasz1.szoftverteszteles.core.model.IngredientItem;

import com.github.dugasz1.szoftverteszteles.core.model.Nutritions;
import com.github.dugasz1.szoftverteszteles.core.model.User;
import com.github.dugasz1.szoftverteszteles.service.*;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import java.sql.*;

public class IngredientDAOmysql implements IngredientDAO {
    private Connection conn;


    public IngredientDAOmysql (Connection conn){

        this.conn = conn;

    }


    public IngredientItem getIngredientItem(int id) throws NoIngredientException, NoNameException, NotFoundException, DatabaseNotAvaibleException, DatabaseException {
        String selectSQL = "SELECT * FROM ingredient WHERE id = ?";
        PreparedStatement ps = null;
        IngredientItem ingredient = null;
        try
        {
            ps = conn.prepareStatement(selectSQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            boolean isExist = rs.next();
            if (isExist)
            {
                ingredient = new IngredientItem(rs.getInt("id"), rs.getString("name"),
                        new Nutritions(rs.getFloat("energy"), rs.getFloat("fat"),rs.getFloat("carbohydrate"),
                                rs.getFloat("protein"),rs.getFloat("salt")),
                        rs.getString("unit"));
            }
            else {
                throw new NotFoundException();
            }
        }
        catch (CommunicationsException e)
        {
            throw new DatabaseNotAvaibleException();
        }
        catch (SQLException e) {
            throw new DatabaseException();
        }
        return ingredient;
    }


    public boolean updateIngredientItem(int id) {
        return false;

    }


    public boolean updateIngredientItem(IngredientItem recipe) throws NotFoundException, DatabaseNotAvaibleException, AlreadyExistingException, DatabaseException {
        String updateSQL = "UPDATE ingredient SET name = ?, energy = ?, fat = ?, carbohydrate = ?, protein = ?, salt = ?, unit = ?  WHERE id = ?";
        try
        {
            PreparedStatement ps = conn.prepareStatement(updateSQL);
            ps.setString(1,recipe.getName());
            ps.setFloat(2, recipe.getNutrions().getEnergy());
            ps.setFloat(3, recipe.getNutrions().getFat());
            ps.setFloat(4, recipe.getNutrions().getCarbohydrate());
            ps.setFloat(5, recipe.getNutrions().getProtein());
            ps.setFloat(6, recipe.getNutrions().getSalt());
            ps.setString(7, recipe.getUnit());
            ps.setInt(8, recipe.getId());

            if(ps.executeUpdate() == 0)
            {
                throw new NotFoundException();
            }
        }
        catch (CommunicationsException e)
        {
            throw new DatabaseNotAvaibleException();
        }
        catch(SQLIntegrityConstraintViolationException e)
        {
            throw new AlreadyExistingException();
        }
        catch (SQLException e)
        {
            throw new DatabaseException();
        }
        return true;

    }


    public boolean deleteIngredientItem(int id) throws NotFoundException, DatabaseNotAvaibleException, DatabaseException {
        String deleteSQL = "DELETE FROM ingredient WHERE id = ?";
        try
        {
            PreparedStatement ps = conn.prepareStatement(deleteSQL);
            ps.setInt(1, id);
            if(ps.executeUpdate() == 0)
            {
                throw new NotFoundException();
            }
        }
        catch (CommunicationsException e)
        {
            throw new DatabaseNotAvaibleException();
        }
        catch (SQLException e)
        {
            throw new DatabaseException();
        }
        return true;

    }


    public boolean deleteIngredientItem(IngredientItem recipe) throws NotFoundException, DatabaseNotAvaibleException, DatabaseException {
        String deleteSQL = "DELETE FROM ingredient WHERE name = ?";
        try
        {
            PreparedStatement ps = conn.prepareStatement(deleteSQL);
            ps.setString(1, recipe.getName());
            if(ps.executeUpdate() == 0)
            {
                throw new NotFoundException();
            }
        }
        catch (CommunicationsException e)
        {
            throw new DatabaseNotAvaibleException();
        }
        catch (SQLException e)
        {
            throw new DatabaseException();
        }
        return true;
    }

}