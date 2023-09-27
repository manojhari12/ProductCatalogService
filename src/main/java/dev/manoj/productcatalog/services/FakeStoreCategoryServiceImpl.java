package dev.manoj.productcatalog.services;

import dev.manoj.productcatalog.dtos.FakeStoreProductDto;
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
    public String[]  getAllCategories() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<String[]> AllCategoryEntities = restTemplate.getForEntity("https://fakestoreapi.com/products/categories",
                String[].class);
        return AllCategoryEntities.getBody();

    }



    @Override
    public List<Product> getProductsInCategory(String categoryType) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto[]> productFromCategory = restTemplate.getForEntity("https://fakestoreapi.com/products/category/{type}",
                FakeStoreProductDto[].class,
                categoryType);
//        System.out.println(productFromCategory);
        return getProductsFromProductList(productFromCategory);
    }


    private List<Product> getProductsFromProductList(ResponseEntity<FakeStoreProductDto[]> productFromCategory) {
        List<Product> productList=new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : productFromCategory.getBody() ){
            Product product = Product.builder()
                    .title(fakeStoreProductDto.getTitle())
                    .description(fakeStoreProductDto.getDescription())
                    .price(fakeStoreProductDto.getPrice())
                    .imageUrl(fakeStoreProductDto.getImage())
                    .rating(fakeStoreProductDto.getRating().toRating())
                    .build();
            product.setId(fakeStoreProductDto.getId());
            productList.add(product);

        }
        return productList;
    }
}
