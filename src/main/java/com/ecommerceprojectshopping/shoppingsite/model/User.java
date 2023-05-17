package com.ecommerceprojectshopping.shoppingsite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;


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
}
