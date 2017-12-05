package com.github.dugasz1.szoftverteszteles.dao.mysql;

import com.github.dugasz1.szoftverteszteles.service.dao.exceptions.StorageNotAvailableException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    public static Connection getConnection(String connectionString) throws StorageNotAvailableException {
        Connection conn;
        try {
            conn = DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            throw new StorageNotAvailableException(e.getMessage(), e);
        }
        return conn;
    }

}
