package org.yearup.data.mysql;

import org.springframework.stereotype.Component;
import org.yearup.data.CategoryDao;
import org.yearup.models.Category;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MySqlCategoryDao extends MySqlDaoBase implements CategoryDao
{
    private Connection connection;

    public MySqlCategoryDao(DataSource dataSource)
    {
        super(dataSource);
    }

    @Override
public void getAllCategories() {
    String getAllCategoriesQuery = "SELECT * FROM categories";
    try (PreparedStatement statement = connection.prepareStatement(getAllCategoriesQuery)) {
        ResultSet resultSet = statement.executeQuery();
    } catch (SQLException e) {
        e.printStackTrace();
    }

}

    @Override
    public Category getById(int categoryId){
        int categoryId = 1;
        String getCategoryByIdQuery = "SELECT * FROM categories WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(getCategoryByIdQuery)) {
            statement.setInt(1, categoryId);
            ResultSet resultSet = statement.executeQuery();
            // Process the result set
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


        @Override
    public Category create(Category category)
    {
        {
            String categoryName = "New Category";
            String createCategoryQuery = "INSERT INTO categories (name) VALUES (?)";
            try (PreparedStatement statement = connection.prepareStatement(createCategoryQuery)) {
                statement.setString(1, categoryName);
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return null;}
    }

    @Override
    public void update(int categoryId, Category category)
    {
        // update category
    }

    @Override
    public void delete(int categoryId)
    {
        // delete category
    }

    private Category mapRow(ResultSet row) throws SQLException
    {
        int categoryId = row.getInt("category_id");
        String name = row.getString("name");
        String description = row.getString("description");

        Category category = new Category()
        {{
            setCategoryId(categoryId);
            setName(name);
            setDescription(description);
        }};

        return category;
    }

}
