package com.github.dugasz1.szoftverteszteles.dao.mysql;

import com.github.dugasz1.szoftverteszteles.core.model.Recipe;
import com.github.dugasz1.szoftverteszteles.service.dao.RecipeDAO;

import java.sql.*;

/*
 *TODO: Implement it!
 */
public class RecipeDAOmysql implements RecipeDAO {

    private Connection conn;

    public RecipeDAOmysql(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void createRecipe(Recipe recipe) {

    }

    public Recipe getRecipe(int id) {
        /*try {
            PreparedStatement stmt = conn.prepareStatement("Select * from recipe where id=?");
            stmt.setInt(1,id);
            ResultSet resultSet = stmt.executeQuery();
            while(resultSet.next())
            {
                Recipe recipe = new Recipe(resultSet.getInt("id"),,"")
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/return null;




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
