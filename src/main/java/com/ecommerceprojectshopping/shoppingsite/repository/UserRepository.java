package com.ecommerceprojectshopping.shoppingsite.repository;

import com.ecommerceprojectshopping.shoppingsite.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
