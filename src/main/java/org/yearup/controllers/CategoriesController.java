package org.yearup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;
import org.yearup.data.CategoryDao;
import org.yearup.data.ProductDao;
import org.yearup.models.Category;
import org.yearup.models.Product;

import java.util.HashMap;
import java.util.List;
@RestController
@RequestMapping("/Categories")
@CrossOrigin
public class CategoriesController {
    private CategoryDao categoryDao;
    private ProductDao productDao;


    @Autowired
    public CategoriesController(CategoryDao categoryDao, ProductDao productDao) {
        this.categoryDao = categoryDao;
        this.productDao = productDao;


    }

    @GetMapping("/{categoryId}")
    public List<Category> getAll() {
        return categoryDao.getAllCategories();
    }

    public Category getById(@PathVariable int id) {
        return categoryDao.getById(id);
    }

    // the url to return all products in category 1 would look like this
    // https://localhost:8080/categories/1/products
    @GetMapping("/categories/1/products")
    public List<Product> getProductsById(@PathVariable int categoryId) {

        return productDao.getProductsById(categoryId);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Category addCategory(@RequestBody Category category) {

        return categoryDao.create(category);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    // add annotation to ensure that only an ADMIN can call this function
    public void updateCategory(@PathVariable int id, @RequestBody Category category) {
        categoryDao.update(id, category);
    }

    @DeleteMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    // add annotation to ensure that only an ADMIN can call this function
    public void deleteCategory(@PathVariable int id) {
        categoryDao.delete(id);

    }
}
