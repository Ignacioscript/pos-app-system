package org.ignacioScript.co.service;

import org.ignacioScript.co.dao.ProductDAO;
import org.ignacioScript.co.dto.CategoryDTO;
import org.ignacioScript.co.dto.ProductDTO;
import org.ignacioScript.co.model.Category;
import org.ignacioScript.co.model.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    private final ProductDAO productDAO;
    private final CategoryService categoryService;

    public ProductService(ProductDAO productDAO, CategoryService categoryService) {
        this.productDAO = productDAO;
        this.categoryService = categoryService;
    }

    public void saveProduct(ProductDTO productDTO, CategoryDTO categoryDTO) {
        Category category = categoryService.createCategoryFromDTO(categoryDTO);
        Product product = createProductFromDTO(productDTO, category);
        productDAO.save(product);
    }

    public void updateProduct(ProductDTO productDTO, CategoryDTO categoryDTO, int id) {
        Category category = categoryService.createCategoryFromDTO(categoryDTO);
        Product product = createProductFromDTO(productDTO, category);
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

    //Helper methods

    private Product createProductFromDTO(ProductDTO productDTO, Category category) {
        return new Product(
                productDTO.getName(),
                productDTO.getDescription(),
                productDTO.getQuantityStock(),
                productDTO.getPrice(),
                category
        );
    }
}
