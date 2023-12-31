package dev.manoj.productcatalog.services;

import static org.junit.jupiter.api.Assertions.*;

import static  org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TestService {

    ServiceDemo serviceDemo;


    @BeforeEach
    public void setup(){
//        System.out.println(ServiceDemo.counter);
        serviceDemo=new ServiceDemo();
    }
    @Test
    public void checkMultiply(){
        int result = serviceDemo.multiple(2,3);
        System.out.println(ServiceDemo.counter);
        assertEquals(6, result);
    }


    @Test
    public void testPrinting(){

        System.out.println(serviceDemo.multiple(2,3));
        System.out.println(ServiceDemo.counter);
        String str = null;


//        assertThrows(NullPointerException.class,
//                () -> System.out.println(str.length())
//                );

        assertThatCode(() -> System.out.println(str.length()))
                .isInstanceOf(NullPointerException.class);

        assertThat("Manoj").startsWith("Maa").endsWith("j").contains("no");


    }
}
