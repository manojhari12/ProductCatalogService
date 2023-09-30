package dev.manoj.productcatalog.services;


import dev.manoj.productcatalog.clients.fakeStoreApi.FakeStoreClient;
import dev.manoj.productcatalog.clients.fakeStoreApi.FakeStoreProductDto;
import dev.manoj.productcatalog.exceptions.NotFoundException;
import dev.manoj.productcatalog.models.Category;
import dev.manoj.productcatalog.models.Product;
import lombok.AllArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class FakeStoreProductServiceImpl implements ProductService {

    //Rest Template Builder is used to create instance of rest template
    //and using rest template we can do a http call to 3rd party apis

    private FakeStoreClient fakeStoreClient;



    public Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto){
        Category category = new Category();
        category.setName(fakeStoreProductDto.getCategory());
        return Product.builder()
                .id(fakeStoreProductDto.getId())
                .title(fakeStoreProductDto.getTitle())
                .price(fakeStoreProductDto.getPrice())
                .imageUrl(fakeStoreProductDto.getImage())
                .category(category)
                .build();
    }

    public FakeStoreProductDto convertProductToFakeStoreDto(Product product){
        return FakeStoreProductDto.builder()
                .id(product.getId())
                .title(product.getTitle())
                .description(product.getDescription())
                .price(product.getPrice())
                .image(product.getImageUrl())
                .category(product.getCategory().getName())
                .build();
    }
    @Override
    public  List<Product> getAllProducts() {
        List<FakeStoreProductDto> fakeStoreProductList = fakeStoreClient.getAllProducts(); //Client Call
        List<Product> productList=new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductList){
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
        public ResponseEntity<Product> getSingleProduct(Long productId) {

            //It will return the response entity of the product DTO from the API call
            ResponseEntity<FakeStoreProductDto> fakeStoreProductDto = fakeStoreClient.getSingleProduct(productId);
            if(fakeStoreProductDto.getBody()==null){
                throw new NotFoundException("Product not found with id : "+productId);
            }
            Product product = convertFakeStoreProductDtoToProduct(fakeStoreProductDto.getBody());
            return new ResponseEntity<>(product,HttpStatus.OK);
        }

    @Override
    public Product addNewProduct(FakeStoreProductDto fakeStoreProductDto) {
            ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity = fakeStoreClient.addNewProduct(fakeStoreProductDto);
            Product product = convertFakeStoreProductDtoToProduct(fakeStoreProductDtoResponseEntity.getBody());
            return product;
    }

    @Override
    //Put request
    public Product replaceProduct(Long productId, Product product) {
        FakeStoreProductDto fakeStoreProductDto = fakeStoreClient.replaceProduct(productId, convertProductToFakeStoreDto(product)).getBody();
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    //PATCH Request
    public Product updateProduct(Long productId, Product product) {
       FakeStoreProductDto fakeStoreProductDto = fakeStoreClient.updateProduct(productId, convertProductToFakeStoreDto(product)).getBody();
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override

    public Product deleteProduct(Long productId) {
        Product product = getSingleProduct(productId).getBody();
        product.setIsDeleted(true);
        return product;
    }

    //RequestForEntity methods

}

