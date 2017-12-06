package com.github.dugasz1.szoftverteszteles.dao.mysql;

import com.github.dugasz1.szoftverteszteles.core.exceptions.EmptyNameException;
import com.github.dugasz1.szoftverteszteles.core.exceptions.NoIngredientException;
import com.github.dugasz1.szoftverteszteles.core.exceptions.NoIngredientItemException;
import com.github.dugasz1.szoftverteszteles.core.exceptions.NoNameException;
import com.github.dugasz1.szoftverteszteles.core.model.Ingredient;
import com.github.dugasz1.szoftverteszteles.core.model.IngredientItem;
import com.github.dugasz1.szoftverteszteles.core.model.Nutritions;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.NotFoundException;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.StorageException;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.StorageNotAvailableException;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IngredientDAOmysql {

    private Connection conn;

    public IngredientDAOmysql(Connection conn) {
        this.conn = conn;
    }

    public Ingredient getIngredient(int id) throws NotFoundException, StorageNotAvailableException, StorageException, NoIngredientItemException {
        String selectSQL = "SELECT * FROM ingredient inner join recipe_ingredient WHERE id = ?";
        PreparedStatement ps;
        Ingredient ingredient;
        try {
            ps = conn.prepareStatement(selectSQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            boolean isExist = rs.next();
            if (isExist) {
                ingredient = new Ingredient(new IngredientItem(rs.getInt("id"), rs.getString("name"),
                        new Nutritions(rs.getFloat("energy"), rs.getFloat("fat"), rs.getFloat("carbohydrate"),
                                rs.getFloat("protein"), rs.getFloat("salt")),
                        rs.getString("unit")), rs.getFloat("quantity"));
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
}
