package model.builders;

import model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductBuilder implements ModelBuilder<Product> {
    @Override
    public Product build(ResultSet resultSet) throws SQLException {
        return new Product(resultSet.getInt(1), resultSet.getString(2));
    }
}
