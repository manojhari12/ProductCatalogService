package dev.manoj.productcatalog.InheritanceExample.MappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "MappedSuperClass_Mentor")
public class Mentor extends User {
    private Integer noOfSessions;
    private Integer noOfMentees;
}
