package com.github.dugasz1.szoftverteszteles.dao.mysql;


import com.github.dugasz1.szoftverteszteles.core.authorization.User;
import com.github.dugasz1.szoftverteszteles.service.DatabaseNotAvaibleException;
import com.github.dugasz1.szoftverteszteles.service.MultipleResultException;
import com.github.dugasz1.szoftverteszteles.service.UserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOmysql implements UserDAO {
    private Connection conn;

    public UserDAOmysql(Connection conn){
        this.conn = conn;
    }

    public User createUser(String name, String password) throws DatabaseNotAvaibleException {
        return null;
    }
    public User getUser(int id) throws DatabaseNotAvaibleException {
        return null;
    }

    public User getUser(String name) throws MultipleResultException, DatabaseNotAvaibleException {
        return null;
    }

    public boolean Update(User id) {
        return false;
    }

    public boolean deleteUser(int id) throws DatabaseNotAvaibleException {
        return false;
    }

    public boolean deleteUser(User user) throws DatabaseNotAvaibleException {
        return false;
    }
}
