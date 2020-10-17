package com.sda.spring.data.jpa.repository;

import com.sda.spring.data.jpa.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Page<Person> findAllByAge(int age, Pageable firstPageWithTwoElements);

    List<Person> findAllByNameEndingWith(String nameEnding);

    @Query(value = "select * from person where name like '%:nameEnding'",nativeQuery = true)
    List<Person> findAllByNameNativeQuery(@Param("nameEnding") String nameEnding);

    @Query(value = "select p from Person p where p.name like '%:nameEnding'")
    List<Person> findAllByNameJPQL(@Param("nameEnding") String nameEnding);

    //TODO: try to create different queries using queryByMethodName, nativeQuery, JPQL (make use of join, where, maybe some aggregation functions)
}
