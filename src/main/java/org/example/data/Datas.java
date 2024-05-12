package org.example.data;

import org.example.entities.Categories;
import org.example.entities.Products;


import java.util.List;
import java.util.Set;

import java.math.BigDecimal;


public interface Datas {
     static List<Categories> categoriesData(){
        return List.of(
                Categories.builder()
                        .name("Electronics")
                        .description("Super electronics devices")
                        .build(),

                Categories.builder()
                        .name("Computers")
                        .description("Best computers for your life")
                        .build(),

                Categories.builder()
                        .name("Art")
                        .description("Art for Heart")
                        .build(),

                Categories.builder()
                        .name("Jets")
                        .description("Boeing and Antonov Jets")
                        .build(),

                Categories.builder()
                        .name("Cars")
                        .description("Sport ad classic cars")
                        .build(),

                Categories.builder()
                        .name("Books")
                        .description("Premium books")
                        .build()
        );
    }

     static List<Products> productsData(List<Categories> categories) {
        return List.of(
                Products.builder()
                        .name("Laptop")
                        .price(new BigDecimal("125000.11"))
                        .quantity(25)
                        .categories( Set.of(
                                categories.stream()
                                        .filter(category -> category.getName().equals("Electronics")).findFirst()
                                        .orElseThrow(IllegalArgumentException::new),
                                categories.stream()
                                        .filter(category -> category.getName().equals("Computers"))
                                        .findFirst()
                                        .orElseThrow(IllegalArgumentException::new)))
                        .build(),

                Products.builder()
                        .name("Maserati")
                        .quantity(10)
                        .price(new BigDecimal("2500000"))
                        .categories( Set.of(categories.stream()
                                .filter(category -> category.getName().equals("Cars"))
                                .findFirst()
                                .orElseThrow(IllegalArgumentException::new)))
                        .build(),

                Products.builder()
                        .name("BMW")
                        .quantity(100)
                        .price(new BigDecimal("1500000"))
                        .categories( Set.of(categories.stream()
                                .filter(category -> category.getName().equals("Cars"))
                                .findFirst()
                                .orElseThrow(IllegalArgumentException::new)))
                        .build(),

                Products.builder()
                        .name("Private Jet")
                        .quantity(5)
                        .price(new BigDecimal("12500000"))
                        .categories( Set.of(categories.stream()
                                .filter(category -> category.getName().equals("Jets"))
                                .findFirst()
                                .orElseThrow(IllegalArgumentException::new)))
                        .build(),

                Products.builder()
                        .name("Martin Fowler. Refactoring")
                        .quantity(10)
                        .price(new BigDecimal("1250"))
                        .categories( Set.of(categories.stream()
                                .filter(category -> category.getName().equals("Books"))
                                .findFirst()
                                .orElseThrow(IllegalArgumentException::new)))
                        .build(),

                Products.builder()
                        .name("creativity kit")
                        .quantity(10)
                        .price(new BigDecimal("4500"))
                        .categories( Set.of(categories.stream()
                                .filter(category -> category.getName().equals("Art"))
                                .findFirst()
                                .orElseThrow(IllegalArgumentException::new)))
                        .build()
        );
    }
}
