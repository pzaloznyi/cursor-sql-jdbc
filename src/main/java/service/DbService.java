package service;

import java.sql.SQLException;
import java.util.List;

public interface DbService<T> {
    List<T> readAll(String query) throws SQLException;
}
