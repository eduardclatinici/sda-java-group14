package com.sda.spring.data.jpa.book;


import org.springframework.data.repository.Repository;

import java.util.Optional;

//we don't actually need to annotate this BookRepository with @Repository
//because all of the interfaces that extend or all the classes that implement Repository interface
//  will automatically be recognized as components.
//it is still a good practice to add the @Repository annotation because it helps us "wrap"
//  all the hibernate exceptions to Spring DataAccessException
@org.springframework.stereotype.Repository
public interface BookRepository extends Repository<Book, Long> {

    //If we use only a couple of methods from CrudRepository or from any other pre-defined repositories
    //we can create an interface that will extend the base Repository interface and define only the methods
    //that we need. In this case we just copied the findAll and Save method from CrudRepository and added them
    //here so that we can use. If we need any other method we can just reproduce the same steps for it.
    Iterable<Book> findAll();

    //We need only to define them because spring knows what implementation to use
    // (if we define methods with the same signature as the ones from the already defined repositories
    //      like CrudRepository or PagingAndSortingRepository)
    //we can also define our own custom methods here
    <Book extends Object> Book save(Book var1);

    Optional<Book> findById(Long var1);
}
