package dev.manoj.productcatalog.controllers;

import dev.manoj.productcatalog.dtos.CategoryDto;
import dev.manoj.productcatalog.models.Category;
import dev.manoj.productcatalog.services.CategoryStub;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryControllerTest {

    @Autowired
    private CategoryController categoryController;

    @Autowired
    private CategoryStub categoryStub;
    @Test
    void testGetAllCategories(){
        CategoryDto categoryDto =  CategoryDto.builder()
                .name("Laptops")
                .description("Gaming")
                .build();

        Category category=Category.builder()
                .name(categoryDto.getName())
                .description(categoryDto.getDescription())
                .build();
        categoryStub.saveCategory(category);
        List<Category> categories = categoryStub.getAllCategories();

        assertEquals(1, categories.size());
    }
}