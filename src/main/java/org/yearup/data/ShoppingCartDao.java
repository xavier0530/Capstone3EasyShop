package org.yearup.data;

import org.yearup.models.Product;
import org.yearup.models.ShoppingCart;

public interface ShoppingCartDao
{
    ShoppingCart getByUserId(int userId);

    void updateProductInCart(int userId, Product product, int quantity);

    void addProductToCart(int userId, Product product);

    void clearCart(int userId);
    // add additional method signatures here
}
