package dev.manoj.productcatalog;

//import dev.manoj.productcatalog.InheritanceExample.JoinedTable.JTMentorRepository;
//import dev.manoj.productcatalog.InheritanceExample.JoinedTable.JTUserRepository;
//import dev.manoj.productcatalog.InheritanceExample.SingleClass.*;
//import dev.manoj.productcatalog.InheritanceExample.TablePerClass.Mentor;
//import dev.manoj.productcatalog.InheritanceExample.TablePerClass.TBCMentorRepository;
//import dev.manoj.productcatalog.InheritanceExample.TablePerClass.TBCUserRepository;
//import dev.manoj.productcatalog.InheritanceExample.TablePerClass.User;
import dev.manoj.productcatalog.models.Category;
import dev.manoj.productcatalog.models.Product;
import dev.manoj.productcatalog.repositories.CategoryRepository;
import dev.manoj.productcatalog.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
//import dev.manoj.productcatalog.InheritanceExample.TablePerClass.*;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductCatalogApplicationTests {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void contextLoads() {
    }


    @Test
    void savingItems(){
        Category category=new Category();
        category.setName("Mobiles");
        Category savedCategory = categoryRepository.save(category);

        Product product=new Product();
        product.setTitle("Iphone");
        product.setPrice(100000.00);
        product.setDescription("Camera Quality");
        product.setCategory(savedCategory);
        productRepository.save(product);

        Product product2=new Product();
        product2.setTitle("Samsung");
        product2.setPrice(40000.00);
        product2.setDescription("Durable");
        product2.setCategory(savedCategory);
        productRepository.save(product2);

        Product product3=new Product();
        product3.setTitle("Sony");
        product3.setPrice(60000.00);
        product3.setDescription("Strong");
        product3.setCategory(savedCategory);
        productRepository.save(product3);

        Product product4 = new Product();
        product4.setTitle("Vivo");
        product4.setPrice(20000.00);
        product4.setDescription("AI enhancement");
        product4.setCategory(savedCategory);
        productRepository.save(product4);

        Category category2=new Category();
        category2.setName("Laptop");
        Category laptopCategory = categoryRepository.save(category2);

        Product product5 = new Product();
        product5.setTitle("DELL");
        product5.setPrice(50000.00);
        product5.setDescription("Windows");
        product5.setCategory(laptopCategory);
        productRepository.save(product5);

        Product product6 = new Product();
        product6.setTitle("Apple MAC Book");
        product6.setPrice(150000.00);
        product6.setDescription("MAC");
        product6.setCategory(laptopCategory);
        productRepository.save(product6);

    }

    @Test
    @Transactional
    void queryMethods(){
        //find products less than 50000
        System.out.println("Products less than 50000");
        List<Product> productsBelow50K = productRepository.findByPriceLessThan(50000.00);
        for(Product product : productsBelow50K){
            System.out.println(product.getTitle()+" "+product.getPrice());
        }

        //find products under category "Laptop"
        System.out.println("Fetching laptops");
        List<Product> laptops =  productRepository.findByCategory_Name("Laptop");
        for(Product product : laptops){
            System.out.println(product.getTitle()+" "+product.getPrice());
        }

        System.out.println("Sorting Mobiles by Price Ascending");
        List<Product> MobilesLowToHigh = productRepository.findByCategory_NameOrderByPrice("Mobiles");
        for(Product product : MobilesLowToHigh){
            System.out.println(product.getTitle()+" "+product.getPrice());
        }
    }


    @Test
    @Transactional
    @Commit
    void testingCascadingTypes(){
        Category category=new Category();
        category.setName("Watches");
        category.setDescription("Time won't wait");

        Product product=new Product();
        product.setTitle("Rolex");
        product.setImageUrl("Rolex watch image");
        product.setDescription("Call me Sir");
        product.setCategory(category);
        productRepository.save(product);

        Product product2=new Product();
        product2.setTitle("Titan");
        product2.setImageUrl("Titan Image");
        product2.setDescription("Strong");
        product2.setCategory(category);
        productRepository.save(product2);

        Product product3=new Product();
        product3.setTitle("Fastrack");
        product3.setImageUrl("Fastrack Image");
        product3.setDescription("Durable");
        product3.setCategory(category);
        productRepository.save(product3);

        Category category1=new Category();
        category1.setName("Fashion");
        categoryRepository.save(category1);

//        categoryRepository.deleteById(3L);



    }

    @Test
    void deleteCategoryByID(){
        categoryRepository.deleteById(7L);
    }

    @Test
    void testQueryAnnotation(){
        Product product = productRepository.findProductById(19L);
        String productName = productRepository.fetchOnlyProductName(20L);
        System.out.println("Fetched product : "+productName);


    }

}
