package com.ecommerceprojectshopping.shoppingsite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;

import java.math.BigDecimal;


@Data
@Builder
@Entity
@Table(name="user_table")
@Scope("session")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String email;
    private String username;
    private String password;
    private String confirmPassword;
    private int age;
    private Role role;
    private Gender gender;
    private BigDecimal balance;
    //can represent decimal numbers with virtually unlimited precision.
    //It allows for precise calculations without loss of precision due to limited number of bits,
    //double: The double type in Java is a 64-bit floating-point
//int: The int type in Java is a 32-bit signed integer
}
