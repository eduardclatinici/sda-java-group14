package com.sda.spring.data.jpa.config;

import com.sda.spring.data.jpa.association.Father;
import com.sda.spring.data.jpa.association.FatherRepository;
import com.sda.spring.data.jpa.association.Son;
import com.sda.spring.data.jpa.association.SonRepository;
import com.sda.spring.data.jpa.book.Book;
import com.sda.spring.data.jpa.book.BookRepository;
import com.sda.spring.data.jpa.domain.Person;
import com.sda.spring.data.jpa.exception.NotFoundException;
import com.sda.spring.data.jpa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Configuration
public class AppConfig {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private FatherRepository fatherRepository;

    @Autowired
    private SonRepository sonRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ConfigurableApplicationContext context;

    @Bean
    @Order(1)
    public CommandLineRunner testData() {
        return args -> {
//            testBookPlainRepository();
//            testAssociations();
//            testPagination();
//            testSorting();
            testPaginationAndSorting();
            //stop runner as soon as it finishes the job
//            System.exit(SpringApplication.exit(context));
        };
    }

    @Bean
    @Order(2)
    public CommandLineRunner testData1() {
        return args -> {
//            testBookPlainRepository();
            testAssociations();
//            testPagination();
//            testSorting();
//            testPaginationAndSorting();
            //stop runner as soon as it finishes the job
//            System.exit(SpringApplication.exit(context));
        };
    }


    private void testBookPlainRepository() {
        Book book1 = new Book();
        book1.setAuthor("author");
        book1.setTitle("1000 de leghe");
        book1.setPublished(LocalDate.now());

        Book book2 = new Book();
        book2.setAuthor("author2");
        book2.setTitle("2000 de leghe");
        book2.setPublished(LocalDate.now().plusWeeks(1));

        bookRepository.save(book1);
        bookRepository.save(book2);
        System.out.println(bookRepository.findAll());

        getBookFromOptionalWithGet();
        getBookFromOpionalOrElse();
    }

    private void getBookFromOptionalWithGet() {
        //we simply check if savedBookOptional has a value inside it and we take it does, we take it
        //if savedBookOptional has no value, book will remain null
        //try changing the id with a non existing id
        Optional<Book> savedBookOptional = bookRepository.findById(1L);
        Book book = null;
        if (savedBookOptional.isPresent()) {
            book = savedBookOptional.get();
        } else {
            throw new NotFoundException("book not found");
        }
        System.out.println("Book found with optionalWithGet: " + book);
    }

    private void getBookFromOpionalOrElse() {
        //we try to take the value from the optional and if the optional does not contain any value
        //then we will throw a custom exception and the execution thread will stop there
        //try changing the id with a non existing id
        Book foundBook = bookRepository.findById(1L)
                .orElseThrow(() -> new NotFoundException("book not found"));
        System.out.println("Book found with optionalOrElse:" + foundBook);
    }

    private void testAssociations() {
        Son son1 = new Son();
        son1.setName("George");

        Son son2 = new Son();
        son2.setName("Ionel");

        Father father = new Father();
        father.setName("Alexandru");

        father.getSons().add(son1);
        father.getSons().add(son2);

        fatherRepository.save(father);

        System.out.println(fatherRepository.findAll());

        System.out.println();

        System.out.println(sonRepository.findAll());

    }

    private void testPagination() {
        loadPaginationAndSortingData();
        //interface pageable - pagination info
        //abstract page request - abstract class
        //page request - implementaion class

        //split all the elements in pages of 2 elements per page and take the first one
        PageRequest firstPageWithTwoElements = PageRequest.of(0, 2);
        //split the elements in pages of 1 element per page and take the second page
        //  if we look at the result it will give us the person with the name "C" and it might seem weird at first
        //  because the person with the name "C" should be on the first page
        //  but JPA thinks that we already "took" the first page at line 129 of this file
        //  and that the second page it is considered to be first and the third page is considered to be the second
        //  so if we split in pages of 1 element we will get: page 0 : A, page 1: B, page 2: C etc
        //  and if we consider page 0 to be already consumed that leaves page 1 as page 0 page 2 as page 1
        //  this happens because we do both of the find operations in the same transaction and they are requesting
        //  pages that are one after another (first and second)
        PageRequest secondPageWithOneElement = PageRequest.of(1, 1);

        Page<Person> page = personRepository.findAll(firstPageWithTwoElements);

        printPageContents(page);

        System.out.println();

        Page<Person> peopleAge32Page = personRepository.findAllByAge(32, secondPageWithOneElement);
        printPageContents(peopleAge32Page);
    }

    private void loadPaginationAndSortingData() {
        personRepository.save(new Person("A", 34, new BigDecimal("223.4"), "23@email.com"));
        personRepository.save(new Person("B", 32, new BigDecimal("432.3"), "24@email.com"));
        personRepository.save(new Person("C", 32, new BigDecimal("555.2"), "25@email.com"));
        personRepository.save(new Person("D", 33, new BigDecimal("63527.2"), "26@email.com"));
        personRepository.save(new Person("E", 31, new BigDecimal("22.2"), "27@email.com"));
    }

    private void printPageContents(Page<Person> page) {
        page.getContent().forEach(System.out::println);
        System.out.println();
    }

    private void testSorting() {
        loadPaginationAndSortingData();
        Sort sortByName = Sort.by("salary");

        //find all the people sorted asc by salary
        Iterable<Person> sortedPeople = personRepository.findAll(sortByName);
        sortedPeople.forEach(System.out::println);
        System.out.println();
    }

    private void testPaginationAndSorting() {
        loadPaginationAndSortingData();
        //If we are requesting the same page (e.g. the first page as in this case) the pages numbers
        //  will "reset". This is why if we try to retrieve page 0 3 times, then every time the data in page
        //  with number 0 will start from the beginning (no data is considered consumed as oposed to the example in
        //     testPagination() )
        Pageable firstPageSortedBySalary = PageRequest.of(0, 5, Sort.by("salary"));
        Pageable firstPageSortedByAgeDesc = PageRequest.of(0, 4, Sort.by("age").descending());
        Pageable firstPageSortedByAgeAscAndSalaryDesc = PageRequest.of(0, 5,
                Sort.by("age").ascending()
                        .and(Sort.by("salary").descending())
        );

        Page<Person> peopleSortedByName = personRepository.findAll(firstPageSortedBySalary);
        Page<Person> peopleSortedByAgeDescending = personRepository.findAll(firstPageSortedByAgeDesc);
        Page<Person> peopleSortedByAgeDescendingAndNameAscending = personRepository.findAll(firstPageSortedByAgeAscAndSalaryDesc);

        printPageContents(peopleSortedByName);
        printPageContents(peopleSortedByAgeDescending);
        printPageContents(peopleSortedByAgeDescendingAndNameAscending);
    }

}
