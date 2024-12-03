package org.ignacioScript.co.controller;

import org.ignacioScript.co.dto.CategoryDTO;
import org.ignacioScript.co.service.CategoryService;

public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    public void saveCategory(String name, String description){
        CategoryDTO categoryDTO = new CategoryDTO(name, description);
        categoryService.save(categoryDTO);
    }

    public void updateCategory(String name, String description, int id){
        CategoryDTO categoryDTO = new CategoryDTO(name, description);
        categoryService.update(categoryDTO, id);
    }

    public void deleteCategory(int id){
        categoryService.delete(id);
    }

    public void findAllCategories(){
        categoryService.findAll().forEach(category -> System.out.println(category.toString()));
    }

    public void findCategoryById(int id){
        System.out.println(categoryService.findById(id).toString());
    }

}
