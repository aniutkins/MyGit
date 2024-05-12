package org.example.entities;

import jakarta.persistence.*;
import lombok.*;


import java.math.BigDecimal;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "products", schema = "public")

public class Products{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;


    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;


    @Column(name = "price")
    private BigDecimal price;


    @Column(name = "quantity")
    private int quantity;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "products_categories",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    private Set<Categories> categories;

//    @ManyToOne(fetch = FetchType.EAGER,
//            cascade = CascadeType.ALL)
//    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
//    private Suppliers supplier;

     @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "product")
    private Set<Orders> orders;


}
