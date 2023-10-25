package dev.manoj.productcatalog.InheritanceExample.MappedSuperClass;

import jakarta.persistence.Entity;

@Entity(name = "MappedSuperClass_Instructor")
public class Instructor extends User {
    private String company;
}
