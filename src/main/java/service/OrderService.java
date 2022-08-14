package service;

import model.Order;
import model.builders.OrderBuilder;

import java.sql.SQLException;

public class OrderService extends DbServiceBase<Order> {
    public OrderService() throws SQLException {
        super(new OrderBuilder());
    }
}
