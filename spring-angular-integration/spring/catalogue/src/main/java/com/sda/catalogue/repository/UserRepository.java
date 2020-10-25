package com.sda.catalogue.repository;

import com.sda.catalogue.domain.Role;
import com.sda.catalogue.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select u from User u where u.userDetails.username = :username ")
    User findByUsername(String username);

    @Query(value = "select u.userDetails.role from User u where u.userDetails.username = :username")
    Role findRoleByUsername(String username);
}
