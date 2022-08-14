import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import service.CustomerService;
import service.OrderService;
import service.ProductService;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Application {
    private static final String productsQuery = "SELECT TOP 10 StockItemID, StockItemName FROM WideWorldImporters.Warehouse.StockItems ORDER BY StockItemID";
    private static final String customersQuery = "SELECT TOP 10 CustomerID, CustomerName, PhoneNumber FROM Sales.Customers";
    private static final String ordersQuery = "SELECT TOP 10 OrderID, CustomerID, OrderDate FROM Sales.Orders ORDER BY OrderDate";

    public static void main(String[] args) throws SQLException {
        DriverManager.registerDriver(new SQLServerDriver());

        ProductService productService = new ProductService();
        productService.readAll(productsQuery).forEach(x -> System.out.printf("%s - %s%n", x.getStockItemId(), x.getStockItemName()));

        System.out.println();

        CustomerService customerService = new CustomerService();
        customerService.readAll(customersQuery).forEach(x -> System.out.printf("%s - %s - %s%n", x.getCustomerID(), x.getCustomerName(), x.getPhoneNumber()));

        System.out.println();

        OrderService orderService = new OrderService();
        orderService.readAll(ordersQuery).forEach(x -> System.out.printf("%s - %s - %s%n", x.getOrderId(), x.getCustomerId(), x.getOrderDate()));
    }
}
