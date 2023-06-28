package org.yearup.data;

import org.yearup.models.Category;

public interface CategoryDao

{

    void getAllCategories();

    Category getById(int categoryId);

    Category create(Category category);
    void update(int categoryId, Category category);
    void delete(int categoryId);

}
