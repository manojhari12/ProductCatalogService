package dev.manoj.productcatalog;

import dev.manoj.productcatalog.InheritanceExample.JoinedTable.JTMentorRepository;
import dev.manoj.productcatalog.InheritanceExample.JoinedTable.JTUserRepository;
import dev.manoj.productcatalog.InheritanceExample.JoinedTable.Mentor;
import dev.manoj.productcatalog.InheritanceExample.JoinedTable.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductCatalogApplicationTests {

    @Autowired
    private JTUserRepository jtUserRepository;
    @Autowired
    private JTMentorRepository jtMentorRepository;
    @Test
    void contextLoads() {
    }

    @Test
    void testingInheritanceTypes(){
        User user= User.builder()
                        .name("Manoj")
                        .password("secret")
                        .build();
        jtUserRepository.save(user);

        Mentor mentor = new Mentor();
        mentor.setNoOfMentees(25);
        mentor.setNoOfSessions(10);
        mentor.setName("Sam");
        mentor.setPassword("2708");
        jtMentorRepository.save(mentor);
    }

}
