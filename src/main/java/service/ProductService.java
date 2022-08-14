package service;

import model.Product;
import model.builders.ProductBuilder;

import java.sql.SQLException;

public class ProductService extends DbServiceBase<Product> {

    public ProductService() throws SQLException {
        super(new ProductBuilder());
    }
}

