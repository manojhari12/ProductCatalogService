package dev.manoj.productcatalog.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
//Product categories
public class Category extends BaseModel {
    private String name;
    private String description;
    private List<Product> products;
}
