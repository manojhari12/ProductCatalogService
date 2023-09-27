package dev.manoj.productcatalog.services;

import dev.manoj.productcatalog.dtos.ProductDto;
import dev.manoj.productcatalog.models.Product;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor

public class FakeStoreCategoryServiceImpl implements CategoryService {
    private RestTemplateBuilder restTemplateBuilder;

//    private RestTemplate restTemplate;

    @Override
    public String   getAllCategories() {
        return null;
    }

    @Override
    public List<Product> getProductsInCategory(String categoryType) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ProductDto[] productFromCategory = restTemplate.getForObject("https://fakestoreapi.com/products/category/{type}",
                ProductDto[].class,
                categoryType);
        System.out.println(productFromCategory);
        List<Product> productList=new ArrayList<>();
        for(ProductDto productDto : productFromCategory ){
            Product product = Product.builder()
                    .title(productDto.getTitle())
                    .description(productDto.getDescription())
                    .price(productDto.getPrice())
                    .imageUrl(productDto.getImage())
                    .rating(productDto.getRating().toRating())
                    .build();
            product.setId(productDto.getId());
            productList.add(product);

        }
        return productList;
    }
}
