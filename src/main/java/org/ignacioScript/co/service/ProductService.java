package org.ignacioScript.co.service;

import org.ignacioScript.co.dao.ProductDAO;
import org.ignacioScript.co.dto.ProductDTO;
import org.ignacioScript.co.model.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    private final ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = new ProductDAO();
    }

    public void saveProduct(Product product) {
        productDAO.save(product);
    }

    public void updateProduct(Product product, int id) {
        productDAO.update(product, id);
    }

    public void deleteProduct(int id) {
        productDAO.delete(id);
    }

    public List<ProductDTO> getAllProducts() {
        return productDAO.findAll().stream()
                .map(product -> new ProductDTO(
                        product.getName(),
                        product.getDescription(),
                        product.getQuantityStock(),
                        product.getPrice(),
                        product.getCategory().getCategoryName()))
                .collect(Collectors.toList());
    }

    public ProductDTO getProductById(int id) {
        Product product = productDAO.findById(id);
        return new ProductDTO(
                product.getName(),
                product.getDescription(),
                product.getQuantityStock(),
                product.getPrice(),
                product.getCategory().getCategoryName());
    }

//    public List<ProductDTO> getProductsByCategory(String category) {
//        return productDAO.findByCategory(category).stream()
//                .map(product -> new ProductDTO(
//                        product.getName(),
//                        product.getDescription(),
//                        product.getQuantityStock(),
//                        product.getPrice(),
//                        product.getCategory().getCategoryName()))
//                .collect(Collectors.toList());
//    }
}
