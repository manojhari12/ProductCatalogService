package dev.manoj.productcatalog.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Rating extends BaseModel{
    private Double rate;
    private Integer count;
}
