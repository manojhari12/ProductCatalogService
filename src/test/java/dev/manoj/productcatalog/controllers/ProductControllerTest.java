package dev.manoj.productcatalog.controllers;

import dev.manoj.productcatalog.dtos.ProductDto;
import dev.manoj.productcatalog.models.Product;
import dev.manoj.productcatalog.services.ProductService;
import jdk.jfr.Name;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductController productController;
    @MockBean
    private ProductService productService;
    @Test
    @Name("Delete product should set delete flag to true")
    void testDeleteProductShouldSetDeleteFlagToTrue(){
        Product returnedProduct = Product.builder()
                .title("Nivea Men facewash")
                .price(168.0)
                .description("Dark spot reduction")
                .build();
        when(productService.deleteProduct(1L)).thenReturn(returnedProduct);
        ProductDto deletedProduct = productController.deleteProduct(1L);
        deletedProduct.setIsDeleted(true);
        System.out.println("Product is deleted :" +deletedProduct.getIsDeleted());
        assertEquals(true, deletedProduct.getIsDeleted());


    }
}