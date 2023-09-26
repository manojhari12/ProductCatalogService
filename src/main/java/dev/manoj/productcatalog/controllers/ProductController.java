package dev.manoj.productcatalog.controllers;


import dev.manoj.productcatalog.dtos.ProductDto;
import dev.manoj.productcatalog.models.Product;
import dev.manoj.productcatalog.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
//@AllArgsConstructor
//@NoArgsConstructor

public class ProductController {
    private ProductService productService;
    public ProductController( ProductService productService) {
        this.productService = productService;
    }
    @GetMapping()
    public List<Product> getAllProducts() {
        return null;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable Long productId) {
        MultiValueMap<String, String> headers=new LinkedMultiValueMap<>();
        headers.add("auth-token","permission-granted");
        headers.add("auth-token","Temporary access");

        ProductDto productDto = productService.getSingleProduct(productId).getBody();
        Product product = Product.builder()
                .title(productDto.getTitle())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .imageUrl(productDto.getImage())
                .rating(productDto.getRating().toRating())
                .build();
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(product,headers, HttpStatus.OK);

        return responseEntity;
//        return productService.getSingleProduct(productId).getBody();
    }


    @PostMapping()
    public ResponseEntity<Product> addNewProduct(@RequestBody ProductDto product) {
        ProductDto productDto = productService.addNewProduct(product);
        Product postProduct = Product.builder()
                .title(productDto.getTitle())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .imageUrl(productDto.getImage())
                .build();
        postProduct.setId(product.getId());
        return new ResponseEntity<>(postProduct, HttpStatus.OK);

    }

    @PutMapping("/{productId}")
    public String updateProduct(@PathVariable("productId") Long productId) {
        return "Updating product";
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId) {
        return "Deleting a product with id: " + productId;
    }
}
