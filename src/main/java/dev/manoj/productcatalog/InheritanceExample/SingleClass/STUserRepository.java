package dev.manoj.productcatalog.InheritanceExample.SingleClass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface STUserRepository extends JpaRepository<User, Long> {
    User save(User user);
}
