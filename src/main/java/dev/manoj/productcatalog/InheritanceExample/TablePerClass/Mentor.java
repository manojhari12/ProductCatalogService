package dev.manoj.productcatalog.InheritanceExample.TablePerClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_mentor")
public class Mentor extends User{
    private Integer noOfSessions;
    private Integer noOfMentees;
}
