package dev.manoj.productcatalog.models;


import jakarta.persistence.Entity;

@Entity
public class Dummy extends BaseModel {
    private String name;
    private String address;
    private Integer age;
}
