package dev.manoj.productcatalog.InheritanceExample.TablePerClass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TBCUserRepository  extends JpaRepository<User, Long> {
}
