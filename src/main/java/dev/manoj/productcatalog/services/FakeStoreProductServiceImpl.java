package dev.manoj.productcatalog.services;


import dev.manoj.productcatalog.dtos.ProductDto;
import dev.manoj.productcatalog.models.Product;
import lombok.AllArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class FakeStoreProductServiceImpl implements ProductService {

    //Rest Template Builder is used to create instance of rest template
    //and using rest template we can do a http call to 3rd party apis
    private RestTemplateBuilder restTemplateBuilder;
    @Override
    public  List<Product> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDto[]> ProductsArray = restTemplate.getForEntity(
                "https://fakestoreapi.com/products",
                ProductDto[].class
        );
        List<Product> productList = new ArrayList<>();
        for(ProductDto productDto : ProductsArray.getBody()){
            Product product = Product.builder()
                    .title(productDto.getTitle())
                    .description(productDto.getDescription())
                    .price(productDto.getPrice())
                    .imageUrl(productDto.getImage())
                    .rating(productDto.getRating().toRating())
                    .build();
            productList.add(product);

        }
        return productList;
    }


        @Override
        public ResponseEntity<ProductDto> getSingleProduct(Long productId) {
            //Created a rest template instance to call fake store api
            RestTemplate restTemplate = restTemplateBuilder.build();
            //It will return the response entity of the product DTO from the API call
            ResponseEntity<ProductDto> productDto = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", ProductDto.class, productId);
            System.out.println("Product DTO id : "+productDto.getBody().getId());
            return productDto;
        }

    @Override
    public ProductDto addNewProduct(ProductDto productDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDto> productDto1 = restTemplate.postForEntity("https://fakestoreapi.com/products",
                productDto, //Request Body
                ProductDto.class //Return type class
                );

        return productDto1.getBody();
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public boolean deleteProduct(Long productId) {
        return false;
    }
}

