package com.github.dugasz1.szoftverteszteles.dao.mysql;

import com.github.dugasz1.szoftverteszteles.service.*;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import com.github.dugasz1.szoftverteszteles.core.model.User;

import java.sql.*;

public class UserDAOmysql implements UserDAO {
    private Connection conn;

    public UserDAOmysql(Connection conn){
        this.conn = conn;
    }

    public User createUser(String name, String password) throws DatabaseNotAvaibleException, AlreadyExistingException, DatabaseException {
        String insertSQL = "Insert into user (username) VALUES (?)";
        int last_id = 0;
        User user = null;

        try
        {
            //Insert a row and return with Id
            PreparedStatement ps = conn.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, name);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next())
            {
                last_id = rs.getInt(1);
            }
            user = new User(last_id, name);
        }
        catch (CommunicationsException e)
        {
            throw new DatabaseNotAvaibleException();
        }
        catch(SQLIntegrityConstraintViolationException e){
            throw new AlreadyExistingException();
        }
        catch (SQLException e)
        {
            throw new DatabaseException();
        }

        return user;
    }
    public User getUser(int id) throws DatabaseNotAvaibleException, DatabaseException, NotFoundException {
        String name = null;
        User user = null;
        PreparedStatement ps = null;
        try
        {
            ps = conn.prepareStatement("SELECT username FROM user WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            boolean isExist = rs.next();
            if (isExist)
            {
                name = rs.getString("username");
            }
            else {
                throw new NotFoundException();
            }
            user = new User(id, name);
        }
        catch (CommunicationsException e)
        {
            throw new DatabaseNotAvaibleException();
        }
        catch (SQLException e) {
            throw new DatabaseException();
        }
        return user;
    }

    public User getUser(String name) throws DatabaseNotAvaibleException, NotFoundException, DatabaseException {
        int id;
        User user = null;
        PreparedStatement ps = null;
        try
        {
            ps = conn.prepareStatement("SELECT username FROM user WHERE username = ?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            boolean isExist = rs.next();
            if (isExist)
            {
                id = rs.getInt("id");
            }
            else
            {
                throw new NotFoundException();
            }
            user = new User(id, name);
        }
        catch (CommunicationsException e)
        {
            throw new DatabaseNotAvaibleException();
        }
        catch (SQLException e) {
            throw new DatabaseException();
        }
        return user;
    }

    public boolean Update(User user) throws DatabaseNotAvaibleException, AlreadyExistingException, DatabaseException, NotFoundException {
        String updateSQL = "UPDATE user SET username = ? WHERE id = ?";
        try
        {
            PreparedStatement ps = conn.prepareStatement(updateSQL);
            ps.setString(1, user.getName());
            ps.setInt(2, user.getId());
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

    public boolean deleteUser(int id) throws DatabaseNotAvaibleException, DatabaseException, NotFoundException {
        String deleteSQL = "DELETE FROM user WHERE id = ?";
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

    public boolean deleteUser(User user) throws DatabaseNotAvaibleException, NotFoundException, DatabaseException {
        String deleteSQL = "DELETE FROM user WHERE username = ?";
        try
        {
            PreparedStatement ps = conn.prepareStatement(deleteSQL);
            ps.setString(1, user.getName());
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
