package org.yearup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;
import org.yearup.data.CategoryDao;
import org.yearup.data.ProductDao;
import org.yearup.models.Category;
import org.yearup.models.Product;

import java.util.List;
@RestController
@RequestMapping("/Categories")
@CrossOrigin

// add the annotations to make this a REST controller
// add the annotation to make this controller the endpoint for the following url
    // http://localhost:8080/categories
// add annotation to allow cross site origin requests
public class CategoriesController {
    private CategoryDao categoryDao;
    private ProductDao productDao;



    @Autowired
    public CategoriesController(CategoryDao categoryDao, ProductDao productDao){
    this.categoryDao= categoryDao;
    this.productDao = productDao;


}
@GetMapping("/{categoryId}")
    public List<Category> getAll(){
       return categoryDao.getAllCategories();
    }

    // add the appropriate annotation for a get action
    public Category getById(@PathVariable int id) {
        return categoryDao.getById(id);
    }

    // the url to return all products in category 1 would look like this
    // https://localhost:8080/categories/1/products
    @GetMapping("/{categoryId}/products")
    public List<Product> getProductsById(@PathVariable int categoryId)
    {

        return productDao.getProductsById(categoryId);
    }

    @PostMapping
    @ResponseStatus(value= HttpStatus.CREATED)
    public Category addCategory(@RequestBody Category category)
    {

        return categoryDao.create(category);
    }
    @PutMapping

    // add annotation to call this method for a PUT (update) action - the url path must include the categoryId
    // add annotation to ensure that only an ADMIN can call this function
    public void updateCategory(@PathVariable int id, @RequestBody Category category)
    {
        // update the category by id
    }


    // add annotation to call this method for a DELETE action - the url path must include the categoryId
    // add annotation to ensure that only an ADMIN can call this function
    public void deleteCategory(@PathVariable int id)
    {
        // delete the category by id
    }
}
