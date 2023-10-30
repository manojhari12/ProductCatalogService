package dev.manoj.productcatalog.repositories;

import dev.manoj.productcatalog.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    void deleteById(Long categoryId);

    Category findCategoryById(Long categoryId);

    List<Category> findAll();


}
