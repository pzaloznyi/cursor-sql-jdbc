package model.builders;

import model.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerBuilder implements ModelBuilder<Customer> {
    @Override
    public Customer build(ResultSet resultSet) throws SQLException {
        return new Customer(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
    }
}
