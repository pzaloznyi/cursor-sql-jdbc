package model.builders;

import model.Order;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderBuilder implements ModelBuilder<Order> {

    @Override
    public Order build(ResultSet resultSet) throws SQLException {
        return new Order(resultSet.getInt(1), resultSet.getInt(2), resultSet.getDate(3));
    }
}
