package com.shoppingcart.userprofile.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shoppingcart.userprofile.model.ERole;
import com.shoppingcart.userprofile.model.Role;



public interface RoleRepository extends MongoRepository<Role, String> {
  Optional<Role> findByName(ERole name);
}
