package dev.manoj.productcatalog.services;

import dev.manoj.productcatalog.exceptions.NotFoundException;
import dev.manoj.productcatalog.models.Product;
import dev.manoj.productcatalog.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
//@SpringBootTest
public class SelfProductServiceTest {
//    @Autowired
    private SelfProductService selfProductService;

//    @MockBean
    private ProductRepository productRepository;
//    @Test
    void testGetSingleProductShouldReturnProduct(){
        //In the single product I have an external dependency
        // I need to mock this
        //Mocking
        Product dummyProduct = Product.builder()
                        .title("ROLEX")
                        .description("Call me Sir")
                        .build();

        Optional<Product> optionalProduct =Optional.of(dummyProduct);
        //Whichever method inside this test method calls product repository then a
        //dummy product will be returned
        when(productRepository.findById(any())).thenThrow(new NotFoundException("Product Not Found"));

        assertAll(
//                () -> assertEquals("ROLEX", selfProductService.getSingleProduct(1L).getBody().getTitle()),
                () -> assertThrows(NotFoundException.class, () -> selfProductService.getSingleProduct(1L).getBody()),
                () -> assertEquals(2, 2*1)

        );

//        assertThrows(NotFoundException.class, () -> selfProductService.getSingleProduct(2L).getBody());

    }



}