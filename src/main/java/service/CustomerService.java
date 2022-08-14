package service;

import model.Customer;
import model.builders.CustomerBuilder;

import java.sql.SQLException;

public class CustomerService extends DbServiceBase<Customer> {
    public CustomerService() throws SQLException {
        super(new CustomerBuilder());
    }
}

