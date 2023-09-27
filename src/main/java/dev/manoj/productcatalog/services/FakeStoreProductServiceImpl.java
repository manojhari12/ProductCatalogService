package dev.manoj.productcatalog.services;


import dev.manoj.productcatalog.dtos.FakeStoreProductDto;
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
        ResponseEntity<FakeStoreProductDto[]> ProductsArray = restTemplate.getForEntity(
                "https://fakestoreapi.com/products",
                FakeStoreProductDto[].class
        );
        List<Product> productList = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : ProductsArray.getBody()){
            Product product = Product.builder()
                    .title(fakeStoreProductDto.getTitle())
                    .description(fakeStoreProductDto.getDescription())
                    .price(fakeStoreProductDto.getPrice())
                    .imageUrl(fakeStoreProductDto.getImage())
                    .rating(fakeStoreProductDto.getRating().toRating())
                    .build();
            productList.add(product);

        }
        return productList;
    }


        @Override
        public ResponseEntity<FakeStoreProductDto> getSingleProduct(Long productId) {
            //Created a rest template instance to call fake store api
            RestTemplate restTemplate = restTemplateBuilder.build();
            //It will return the response entity of the product DTO from the API call
            ResponseEntity<FakeStoreProductDto> fakeStoreProductDto = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", FakeStoreProductDto.class, productId);
            System.out.println("Product DTO id : "+fakeStoreProductDto.getBody().getId());
            return fakeStoreProductDto;
        }

    @Override
    public FakeStoreProductDto addNewProduct(FakeStoreProductDto fakeStoreProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDto1 = restTemplate.postForEntity("https://fakestoreapi.com/products",
                fakeStoreProductDto, //Request Body
                FakeStoreProductDto.class //Return type class
                );

        return fakeStoreProductDto1.getBody();
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

