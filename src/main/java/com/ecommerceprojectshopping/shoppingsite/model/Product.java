package com.ecommerceprojectshopping.shoppingsite.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;

import java.math.BigDecimal;

@Entity
@Data
@Builder
@Table(name="product")
@Scope("session")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description_of_product;
    //so the product class has a many to one relationship with category
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = true)
    //@JoinColumns annotation, the category_id refers to the id column in the Category class.
    // This implies that category_id
    // is a foreign key in the Product class, establishing a relationship between the two entities.
    private Category category;//prevents primitive obessession code smell
    //@ManyToOne(fetch = FetchType.LAZY): This is an annotation used to specify a many-to-one
    //relationship between two entities. It indicates that the Product class (the "many" side)
    //is associated with multiple instances of the current class (the "one" side).
    //The fetch attribute determines how the related entity is loaded from the database when this
    //association is accessed. In this case, FetchType.LAZY is used, which means that the Category
    //entity will be loaded from the database only when it is explicitly accessed for the first time.
    private BigDecimal price;
    @Column(name="image")
    private String image_of_product;


}
