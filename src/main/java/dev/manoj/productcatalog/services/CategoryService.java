package dev.manoj.productcatalog.services;

import dev.manoj.productcatalog.models.Category;
import dev.manoj.productcatalog.models.Product;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();

//    List<Product> getProductsInCategory(String categoryType);
}
