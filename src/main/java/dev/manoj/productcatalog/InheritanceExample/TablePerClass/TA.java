package dev.manoj.productcatalog.InheritanceExample.TablePerClass;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_TA")
public class TA extends User{
    private Double rating;
}
