package dev.manoj.productcatalog.clients.authenticationClient.dtos;


import lombok.*;
import org.hibernate.annotations.AnyKeyJavaClass;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String email;
    private List<Role> roles;


}
