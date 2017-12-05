package com.github.dugasz1.szoftverteszteles.dao.mysql;

import com.github.dugasz1.szoftverteszteles.core.model.User;
import com.github.dugasz1.szoftverteszteles.service.dao.UserDAO;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.AlreadyExistingException;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.NotFoundException;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.StorageException;
import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.StorageNotAvailableException;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import java.sql.*;

public class UserDAOmysql implements UserDAO {

    private Connection conn;

    public UserDAOmysql(Connection conn) {
        this.conn = conn;
    }

    public User createUser(String name) throws StorageNotAvailableException, AlreadyExistingException, StorageException {
        String insertSQL = "Insert into user (username) VALUES (?)";
        int last_id = 0;
        User user;

        try {
            //Insert a row and return with Id
            PreparedStatement ps = conn.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, name);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                last_id = rs.getInt(1);
            }
            user = new User(last_id, name);
        } catch (CommunicationsException e) {
            throw new StorageNotAvailableException();
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new AlreadyExistingException();
        } catch (SQLException e) {
            throw new StorageException();
        }
        return user;
    }

    public User getUser(int id) throws StorageNotAvailableException, StorageException, NotFoundException {
        String name;
        User user;
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("SELECT username FROM user WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            boolean isExist = rs.next();
            if (isExist) {
                name = rs.getString("username");
            } else {
                throw new NotFoundException();
            }
            user = new User(id, name);
        } catch (CommunicationsException e) {
            throw new StorageNotAvailableException(e.getMessage(), e);
        } catch (SQLException e) {
            throw new StorageException(e.getMessage(), e);
        }
        return user;
    }

    public User getUser(String name) throws StorageNotAvailableException, NotFoundException, StorageException {
        int id;
        User user;
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("SELECT * FROM user WHERE username = ?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            boolean isExist = rs.next();
            if (isExist) {
                id = rs.getInt("id");
            } else {
                throw new NotFoundException();
            }
            user = new User(id, name);
        } catch (CommunicationsException e) {
            throw new StorageNotAvailableException(e);
        } catch (SQLException e) {
            throw new StorageException(e);
        }
        return user;
    }

    public boolean updateUser(User user) throws StorageNotAvailableException, AlreadyExistingException, StorageException, NotFoundException {
        String updateSQL = "UPDATE user SET username = ? WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(updateSQL);
            ps.setString(1, user.getName());
            ps.setInt(2, user.getId());
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

    public boolean deleteUser(int id) throws StorageNotAvailableException, StorageException, NotFoundException {
        String deleteSQL = "DELETE FROM user WHERE id = ?";
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

    public boolean deleteUser(User user) throws StorageNotAvailableException, NotFoundException, StorageException {
        String deleteSQL = "DELETE FROM user WHERE username = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(deleteSQL);
            ps.setString(1, user.getName());
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
