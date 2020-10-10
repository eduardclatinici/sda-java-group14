package com.example.javabuc14example.repository;

import com.example.javabuc14example.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User getUserByUsername(String username);

    @Modifying
    @Query(value = "delete from user where username = :usernameToDelete", nativeQuery = true)
    void deleteByUsername(@Param("usernameToDelete") String usernameToDelete);
}
