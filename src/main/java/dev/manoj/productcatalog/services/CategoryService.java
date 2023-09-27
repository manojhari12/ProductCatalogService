package dev.manoj.productcatalog.services;

import dev.manoj.productcatalog.models.Product;

import java.util.List;

public interface CategoryService {
    String[] getAllCategories();

    List<Product> getProductsInCategory(String categoryType);
}
