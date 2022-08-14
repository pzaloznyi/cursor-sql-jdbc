package service;

import model.builders.ModelBuilder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public abstract class DbServiceBase<T> implements DbService<T> {
    ConnectionManager connectionManager;
    private final ModelBuilder<T> modelBuilder;

    protected DbServiceBase(ModelBuilder<T> modelBuilder) throws SQLException {
        connectionManager = new ConnectionManager();
        this.modelBuilder = modelBuilder;
    }

    @Override
    public List<T> readAll(String query) throws SQLException {
        try (var statement = connectionManager.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            var products = new LinkedList<T>();
            while (resultSet.next())
                products.add(modelBuilder.build(resultSet));

            return products;
        }
    }
}
