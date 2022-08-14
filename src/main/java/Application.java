import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.LinkedList;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

public class Application {

    public static void main(String[] args) {
        try {
            String url = "jdbc:sqlserver://localhost:1433;database=WideWorldImporters;encrypt=true;trustServerCertificate=true;";
            String user = "sa";
            String password = "mssql1Ipw";

            DriverManager.registerDriver(new SQLServerDriver());
            Connection connection = DriverManager.getConnection(url, user, password);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT TOP 10 StockItemID, StockItemName FROM WideWorldImporters.Warehouse.StockItems ORDER BY StockItemID");

            var products = new AtomicReference<>(new LinkedList<Product>());
            while (resultSet.next()) {
                products.get().add(buildProduct(resultSet));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Properties loadProperties() {
        var properties = new Properties();
        try (InputStream input = Application.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Unable to find config.properties");
                return properties;
            }

            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    private static Product buildProduct(ResultSet resultSet) throws SQLException {
        var product = new Product();
        product.setStockItemId(resultSet.getInt(1));
        product.setStockItemName(resultSet.getString(2));
        return product;
    }
}
