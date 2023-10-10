package dev.manoj.productcatalog;

import java.util.List;

public class TestingFeatures {
    public static void main(String[] args) {
        List<Integer> list = List.of(5,10,15,20,25,30,35,45,40,50);

        list.stream()
                .filter(x -> x%5==0)
                .filter(x -> x%2==0)
                .forEach(x -> System.out.println(x));
    }
}
