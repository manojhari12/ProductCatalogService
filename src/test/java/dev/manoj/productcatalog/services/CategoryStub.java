package dev.manoj.productcatalog.services;

import dev.manoj.productcatalog.models.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryStub implements CategoryService{
    List<Category> categories=new ArrayList<>();
    @Override
    public List<Category> getAllCategories() {
        return categories;
    }


    @Override
    public Category saveCategory(Category category) {
        categories.add(category);
        return category;
    }
}
