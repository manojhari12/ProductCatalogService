package dev.manoj.productcatalog.controllers;

import dev.manoj.productcatalog.dtos.ProductDto;
import dev.manoj.productcatalog.exceptions.NotFoundException;
import dev.manoj.productcatalog.models.Category;
import dev.manoj.productcatalog.models.Product;
import dev.manoj.productcatalog.services.CategoryService;
import dev.manoj.productcatalog.services.ProductService;
import dev.manoj.productcatalog.services.SelfCategoryService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class StubProductService implements ProductService {

    @Mock
    private SelfCategoryService categoryService;


    @Override
    public Page<Product> getProducts(String query, int offset, int noOfResults) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public ResponseEntity<Product> getSingleProduct(Long productId) throws NotFoundException {
        return null;
    }

    @Override
    public Product addNewProduct(ProductDto productDto) {
        Category category = Category.builder()
                        .name("Lifestyle")
                        .build();
//        Mockito.when(categoryService.getCategoryById(ArgumentMatchers.any())).thenReturn(category);
//        Category fetchedCategory = categoryService.getCategoryById(productDto.getCategoryId());
        Category fetchedCategory = category;
        return Product.builder()
                .title(productDto.getTitle())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .category(fetchedCategory)
                .build();
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(Long productId) throws NotFoundException {
        return null;
    }

    @Override
    public List<Product> getProductsInCategory(String categoryType) {
        return null;
    }
}
