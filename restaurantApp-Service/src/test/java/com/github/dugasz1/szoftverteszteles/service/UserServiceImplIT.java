package com.github.dugasz1.szoftverteszteles.service;

import com.github.dugasz1.szoftverteszteles.core.service.UserService;
import com.github.dugasz1.szoftverteszteles.dao.mysql.UserDAOmysql;
import com.github.dugasz1.szoftverteszteles.service.dao.UserDAO;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.Assert.*;

public class UserServiceImplIT {
    private UserService userService;

    @Before
    public void setUp() throws Exception{
        Connection conn;
        conn = DriverManager.getConnection(System.getProperty("mysql_connection_string"));

        UserDAO userDAO = new UserDAOmysql(conn);
    }

    @Test
    public void createUser() throws Exception {
    }

    @Test
    public void getUser() throws Exception {
    }

    @Test
    public void getUser1() throws Exception {
    }

    @Test
    public void updateUser() throws Exception {
    }

    @Test
    public void deleteUser() throws Exception {
    }

    @Test
    public void deleteUser1() throws Exception {
    }

}