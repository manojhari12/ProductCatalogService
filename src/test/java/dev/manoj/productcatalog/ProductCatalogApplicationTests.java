package dev.manoj.productcatalog;

import dev.manoj.productcatalog.InheritanceExample.JoinedTable.JTMentorRepository;
import dev.manoj.productcatalog.InheritanceExample.JoinedTable.JTUserRepository;
import dev.manoj.productcatalog.InheritanceExample.SingleClass.*;
import dev.manoj.productcatalog.InheritanceExample.TablePerClass.Mentor;
import dev.manoj.productcatalog.InheritanceExample.TablePerClass.TBCMentorRepository;
import dev.manoj.productcatalog.InheritanceExample.TablePerClass.TBCUserRepository;
import dev.manoj.productcatalog.InheritanceExample.TablePerClass.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import dev.manoj.productcatalog.InheritanceExample.TablePerClass.*;
@SpringBootTest
class ProductCatalogApplicationTests {

    @Autowired
    private TBCUserRepository tbcUserRepository;
    @Autowired
    private TBCMentorRepository tbcMentorRepository;
    @Autowired
    private STInstructorRepository stInstructorRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testingInheritanceTypes(){
        User user=new User();
        user.setName("Manoj");
        user.setPassword("111");
        tbcUserRepository.save(user);

        Mentor mentor=new Mentor();
        mentor.setName("Latha");
        mentor.setPassword("1121");
        mentor.setNoOfMentees(50);
        mentor.setNoOfSessions(1);
        tbcMentorRepository.save(mentor);

    }

}
