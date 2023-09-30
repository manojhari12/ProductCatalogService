package dev.manoj.productcatalog.models;

import lombok.*;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Rating extends BaseModel{
    private Double rate;
    private Integer count;
}
