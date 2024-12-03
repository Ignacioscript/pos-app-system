package org.ignacioScript.co.model;


import org.ignacioScript.co.interfaces.DataTransferObject;

public class Product implements DataTransferObject {

    private int productId;
    private String name;
    private String description;
    private int quantityStock;
    private double price;
    private Category category;


    public Product(int productId, String name, String description, int quantityStock, double price, Category category) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.quantityStock = quantityStock;
        this.price = price;
        this.category = category;
    }

    public Product(String name, String description, int quantityStock, double price, Category category) {
        this.name = name;
        this.description = description;
        this.quantityStock = quantityStock;
        this.price = price;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantityStock() {
        return quantityStock;
    }

    public void setQuantityStock(int quantityStock) {
        this.quantityStock = quantityStock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}