package dev.manoj.productcatalog.InheritanceExample.SingleClass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="SINGLE_TABLE_MENTOR")
@DiscriminatorValue("2")
public class Mentor extends User {
    private Integer noOfSessions;
    private Integer noOfMentees;
}
