package ru.kremenia.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "product")
@NamedQueries({
        @NamedQuery(name = "findAllProduct", query = "Select p from Product p"),
        @NamedQuery(name = "countAllProduct", query = "Select count(p) from Product p"),
        @NamedQuery(name = "deleteProductById", query = "delete from Product p where p.id = :id")
})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "text")
    private String description;

    @Column(nullable = false)
    private double price;

    @OneToMany(mappedBy = "product")
    private List<LineItem> lineItems;

    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}