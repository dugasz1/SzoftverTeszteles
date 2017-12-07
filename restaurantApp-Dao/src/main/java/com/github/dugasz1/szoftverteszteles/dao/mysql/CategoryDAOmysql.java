package com.github.dugasz1.szoftverteszteles.dao.mysql;

import com.github.dugasz1.szoftverteszteles.core.exceptions.NoNameException;
import com.github.dugasz1.szoftverteszteles.core.model.Category;
import com.github.dugasz1.szoftverteszteles.service.dao.CategoryDAO;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.AlreadyExistingException;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.NotFoundException;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.StorageException;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.StorageNotAvailableException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryDAOmysql implements CategoryDAO{


    private Connection conn;

    public CategoryDAOmysql(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void createCategory(Category category) throws AlreadyExistingException, StorageNotAvailableException {
        try {
            PreparedStatement statement = conn.prepareStatement("Insert Into Category(id,name) VALUE (?,?)");
            statement.setInt(1,category.getId());
            statement.setString(2,category.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new StorageNotAvailableException("Something went wrong");
        }

    }

    @Override
    public void deleteCategory(int id) throws NotFoundException, StorageNotAvailableException {
        try {
            PreparedStatement statement = conn.prepareStatement("DELETE FROM category Where id = ?");
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new StorageNotAvailableException("Something went wrong");
        }
    }

    @Override
    public void updateCategory(Category category) throws NotFoundException, StorageNotAvailableException {
        try {
            PreparedStatement statement = conn.prepareStatement("Update category Set id = ? , name = ? where id = ?");
            statement.setInt(1,category.getId());
            statement.setString(2,category.getName());
            statement.setInt(3,category.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new StorageNotAvailableException("Something went wrong");
        }
    }

    @Override
    public Category getCategoryById(int id) throws NotFoundException, StorageNotAvailableException, StorageException {
        Category category = null;
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM category where id = ?");
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                category = new Category(resultSet.getInt("id"),resultSet.getString("name"));
            }
        } catch (SQLException e) {
            throw new StorageNotAvailableException("Something went wrong");
        } catch (NoNameException e) {
            throw new StorageException(e);
        }
        return category;
    }


}
