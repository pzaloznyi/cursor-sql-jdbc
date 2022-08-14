package model.builders;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ModelBuilder<T> {
    T build(ResultSet resultSet) throws SQLException;
}
