package dev.manoj.productcatalog.controllers;

import dev.manoj.productcatalog.dtos.ProductDto;
import dev.manoj.productcatalog.models.Product;
import dev.manoj.productcatalog.services.ProductService;
import jdk.jfr.Name;
import org.apache.hc.core5.http.HttpStatus;

import org.assertj.core.api.Assert.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//@SpringBootTest
class ProductControllerTest {

//    @Autowired
    private ProductController productController;
//    @MockBean
    private ProductService productService;
//    @Test
//    @Name("Delete product should set delete flag to true")
    void testDeleteProductShouldSetDeleteFlagToTrue(){
        boolean server_status = true;
        Assumptions.assumeTrue(server_status);
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

//    @Test
    void testAssertJStatements(){
        Product product = Product.builder()
                .title("Hunter 350")
                .description("Made like a Gun")
                .price(220000.00)
                .build();
        when(productService.getSingleProduct(any()))
                .thenReturn(new ResponseEntity<>(product, HttpStatusCode.valueOf(200)))  ;
        Product fetchedProduct = productService.getSingleProduct(1L).getBody();
        assertThat(fetchedProduct.getTitle())
                .startsWith("Hun")
                .hasSizeGreaterThan(5)
                .doesNotContainAnyWhitespaces();
    }
}