package dev.manoj.productcatalog.InheritanceExample.SingleClass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="SINGLE_TABLE_INSTRUCTOR")
@DiscriminatorValue("3")
public class Instructor extends User {
    private String company;
}
