package dev.manoj.productcatalog.services;

public interface CategoryService {
    String getAllCategories();

    String getProductsInCategory(Long categoryId);
}
