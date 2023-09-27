package dev.manoj.productcatalog.controllers;


import dev.manoj.productcatalog.models.Product;
import dev.manoj.productcatalog.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products/category")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public String getAllCategories() {
        return "Getting all categories";
    }

    @GetMapping("/{categoryType}")
    public List<Product> getProductsInCategory(@PathVariable String categoryType) {
        return categoryService.getProductsInCategory(categoryType);
    }
}
