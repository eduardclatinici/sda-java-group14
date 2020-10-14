package com.sda.spring.data.jpa.association;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//we can use all the methods already declared in CrudRepository without declaring them here
@Repository
public interface FatherRepository extends CrudRepository<Father, Long> {
}
