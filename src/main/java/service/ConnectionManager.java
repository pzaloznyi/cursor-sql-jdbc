package service;

import config.DbConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private final Connection connection;

    public ConnectionManager() throws SQLException {
        DbConfig dbConfig = new DbConfig();

        connection = DriverManager.getConnection(dbConfig.getUrl(), dbConfig.getUser(), dbConfig.getPassword());
    }

    public Connection getConnection() {
        return connection;
    }
}
