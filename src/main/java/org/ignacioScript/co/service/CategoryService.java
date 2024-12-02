package org.ignacioScript.co.service;

import org.ignacioScript.co.dao.CategoryDAO;
import org.ignacioScript.co.dto.CategoryDTO;
import org.ignacioScript.co.model.Category;
import java.util.stream.Collectors;

import java.util.List;

public class CategoryService {

    private final CategoryDAO categoryDAO;

    public CategoryService(){
        categoryDAO = new CategoryDAO();
    }

    public void save(Category category){
        categoryDAO.save(category);
    }

    public void update(Category category, int id){
        categoryDAO.update(category, id);
    }

    public void delete(int id){
        categoryDAO.delete(id);
    }

    public List<CategoryDTO> findAll(){
       return categoryDAO.findAll().stream()
                .map(category -> new CategoryDTO(
                        category.getCategoryName(),
                        category.getDescription()))
                .collect(Collectors.toList());
    }

    public CategoryDTO findById(int id){
        Category category = categoryDAO.findById(id);
        return new CategoryDTO(
                category.getCategoryName(),
                category.getDescription());
    }

}
