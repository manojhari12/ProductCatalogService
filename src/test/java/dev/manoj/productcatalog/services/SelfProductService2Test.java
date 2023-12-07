package dev.manoj.productcatalog.services;

import dev.manoj.productcatalog.exceptions.NotFoundException;
import dev.manoj.productcatalog.models.Product;
import dev.manoj.productcatalog.repositories.ProductRepository;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assumptions.*;
//@SpringBootTest
class SelfProductService2Test {

//    @Autowired
    private ProductService productService;

//    @MockBean
    private ProductRepository productRepository;

//    @Test
    void testGetSingleProductShouldReturnProduct(){
        Product product = Product.builder()
                .title("Lenovo Thinkbook")
                        .price(36000.00)
                                .description("Compact")
                                        .build();

        Optional<Product> optionalProduct= Optional.of(product);
        //Mocking
        when(productRepository.findById(1L)).thenReturn(optionalProduct);

        when(productRepository.findById(5L)).thenThrow(new NotFoundException("Missing"));
//        ResponseEntity<Product> responseProduct = productService.getSingleProduct(1L);

//        System.out.println("Product returns : "+productService.getSingleProduct(1L).getBody());

//        assertThrows(NotFoundException.class, () -> productService.getSingleProduct(1L));

        assertAll("Checking All get Single method functionalities",
                () -> assertThrows(NotFoundException.class, () -> productService.getSingleProduct(5L)), //Should fail
                () -> assertEquals("Compact", productService.getSingleProduct(1L).getBody().getDescription()),
                () -> assertEquals(HttpStatus.OK,productService.getSingleProduct(1L).getStatusCode())
//                () -> assertNotNull(productService.getSingleProduct(1L).getBody())
                );




    }



}