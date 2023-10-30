package dev.manoj.productcatalog.repositories;

import dev.manoj.productcatalog.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAll();

    Product findProductById(Long productId);

    //Find Single product
    Optional<Product> findById(Long productId);

    Product save(Product product);

    List<Product> findByPriceLessThan(Double amount);

    List<Product> findByCategory_Name(String categoryName);

//    List<Product> findByCategory_NameAndOrderByPriceAsc(String CategoryName);
    List<Product> findByCategory_NameOrderByPrice(String categoryName);

    Product deleteProductById(Long ProductId);


}
