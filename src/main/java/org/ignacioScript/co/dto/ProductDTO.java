package org.ignacioScript.co.dto;

import org.ignacioScript.co.model.Category;

public class ProductDTO {

    private String name;
    private String description;
    private int quantityStock;
    private double price;
    private String category;

    public ProductDTO(String name, String description, int quantityStock, double price, String category) {
        this.name = name;
        this.description = description;
        this.quantityStock = quantityStock;
        this.price = price;
        this.category = category;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       sb.append("Product [Product Name=").append(getName())
               .append(", Description=").append(getDescription())
               .append(", QuantityStock=").append(getQuantityStock())
               .append(", Price=").append(getPrice())
               .append(", Category=").append(getCategory())
               .append("]");
       return sb.toString();
    }
}
