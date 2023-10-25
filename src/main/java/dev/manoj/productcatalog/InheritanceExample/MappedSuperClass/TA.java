package dev.manoj.productcatalog.InheritanceExample.MappedSuperClass;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "MappedSuperClass_TA")
public class TA extends User {
    private Double rating;
}
