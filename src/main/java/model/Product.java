package model;

public class Product {
    private int stockItemId;
    private String stockItemName;

    public Product(int stockItemId, String stockItemName) {
        this.stockItemId = stockItemId;
        this.stockItemName = stockItemName;
    }

    public int getStockItemId() {
        return stockItemId;
    }

    public String getStockItemName() {
        return stockItemName;
    }
}
