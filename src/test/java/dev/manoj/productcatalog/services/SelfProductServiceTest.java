package dev.manoj.productcatalog.services;

import dev.manoj.productcatalog.dtos.ProductDto;
import dev.manoj.productcatalog.exceptions.NotFoundException;
import dev.manoj.productcatalog.models.Category;
import dev.manoj.productcatalog.models.Product;
import dev.manoj.productcatalog.repositories.ProductRepository;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
//@SpringBootTest

@ExtendWith(MockitoExtension.class)
public class SelfProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private SelfCategoryService categoryService;

    @InjectMocks
    private SelfProductService selfProductService;

    @Test
    public void testAddNewProductShouldReturnProduct(){
        ProductDto productDto=ProductDto.builder().title("Vicks Inhaler")
                .description("Provides quick relief")
                .price(67.00)
                .categoryId(1L)
                .build();

        Category category=Category.builder().name("Medicine").build();

        when(categoryService.getCategoryById(1L)).thenReturn(category);

        Category fetchedCategory = categoryService.getCategoryById(1L);
        Product product = Product.builder()
                .title(productDto.getTitle())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .category(fetchedCategory)
                .build();

        when(productRepository.save(isA(Product.class))).thenReturn(product);

        Product resultProduct = productRepository.save(product);

        assertThat(product).isNotNull();


    }



}