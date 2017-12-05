package com.github.dugasz1.szoftverteszteles.dao.mysql;


import com.github.dugasz1.szoftverteszteles.core.exceptions.EmptyNameException;
import com.github.dugasz1.szoftverteszteles.core.exceptions.NoIngredientException;
import com.github.dugasz1.szoftverteszteles.core.exceptions.NoNameException;
import com.github.dugasz1.szoftverteszteles.core.model.IngredientItem;
import com.github.dugasz1.szoftverteszteles.core.model.Nutritions;
import com.github.dugasz1.szoftverteszteles.service.dao.IngredientItemDAO;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.*;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import java.sql.*;

public class IngredientItemDAOmysql implements IngredientItemDAO {

    private Connection conn;

    public IngredientItemDAOmysql(Connection conn) {
        this.conn = conn;
    }


    public IngredientItem getIngredientItem(int id) throws NotFoundException, StorageNotAvailableException, StorageException {
        String selectSQL = "SELECT * FROM ingredient WHERE id = ?";
        PreparedStatement ps;
        IngredientItem ingredient;
        try {
            ps = conn.prepareStatement(selectSQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            boolean isExist = rs.next();
            if (isExist) {
                ingredient = new IngredientItem(rs.getInt("id"), rs.getString("name"),
                        new Nutritions(rs.getFloat("energy"), rs.getFloat("fat"), rs.getFloat("carbohydrate"),
                                rs.getFloat("protein"), rs.getFloat("salt")),
                        rs.getString("unit"));
            } else {
                throw new NotFoundException();
            }
        } catch (CommunicationsException e) {
            throw new StorageNotAvailableException(e);
        } catch (SQLException e) {
            throw new StorageException(e);
        } catch (EmptyNameException | NoNameException | NoIngredientException e) {
            throw new StorageException(e);
        }
        return ingredient;
    }


    public boolean updateIngredientItem(int id) {
        return false;
    }


    public boolean updateIngredientItem(IngredientItem recipe) throws NotFoundException, StorageNotAvailableException, StorageException, AlreadyExistingException {
        String updateSQL = "UPDATE ingredient SET name = ?, energy = ?, fat = ?, carbohydrate = ?, protein = ?, salt = ?, unit = ?  WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(updateSQL);
            ps.setString(1, recipe.getName());
            ps.setFloat(2, recipe.getNutritions().getEnergy());
            ps.setFloat(3, recipe.getNutritions().getFat());
            ps.setFloat(4, recipe.getNutritions().getCarbohydrate());
            ps.setFloat(5, recipe.getNutritions().getProtein());
            ps.setFloat(6, recipe.getNutritions().getSalt());
            ps.setString(7, recipe.getUnit());
            ps.setInt(8, recipe.getId());

            if (ps.executeUpdate() == 0) {
                throw new NotFoundException();
            }
        } catch (CommunicationsException e) {
            throw new StorageNotAvailableException();
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new AlreadyExistingException();
        } catch (SQLException e) {
            throw new StorageException();
        }
        return true;
    }


    public boolean deleteIngredientItem(int id) throws NotFoundException, StorageNotAvailableException, StorageException {
        String deleteSQL = "DELETE FROM ingredient WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(deleteSQL);
            ps.setInt(1, id);
            if (ps.executeUpdate() == 0) {
                throw new NotFoundException();
            }
        } catch (CommunicationsException e) {
            throw new StorageNotAvailableException();
        } catch (SQLException e) {
            throw new StorageException();
        }
        return true;

    }


    public boolean deleteIngredientItem(IngredientItem recipe) throws NotFoundException, StorageNotAvailableException, StorageException {
        String deleteSQL = "DELETE FROM ingredient WHERE name = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(deleteSQL);
            ps.setString(1, recipe.getName());
            if (ps.executeUpdate() == 0) {
                throw new NotFoundException();
            }
        } catch (CommunicationsException e) {
            throw new StorageNotAvailableException();
        } catch (SQLException e) {
            throw new StorageException();
        }
        return true;
    }

}