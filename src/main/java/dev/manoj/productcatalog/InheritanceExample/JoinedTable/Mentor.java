package dev.manoj.productcatalog.InheritanceExample.JoinedTable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mentor extends User {
    private Integer noOfSessions;
    private Integer noOfMentees;
}
