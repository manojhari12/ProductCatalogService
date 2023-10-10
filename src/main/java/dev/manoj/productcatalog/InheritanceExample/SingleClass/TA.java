package dev.manoj.productcatalog.InheritanceExample.SingleClass;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="SINGLE_TABLE_TA")
@DiscriminatorValue("1")
public class TA extends User {
    private Double rating;
}
