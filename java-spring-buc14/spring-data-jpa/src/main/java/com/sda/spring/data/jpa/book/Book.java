package com.sda.spring.data.jpa.book;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
//@Table annotation is optionally. We use it when we want to change the name
// of the table from the database that is mapped to this object in Java
//example: we could name this class "MyClass" and map it to @Table("my_fancy_table") in the database
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //TODO: play with @Column, @Table, GenerationTypes for id

    private String title;

    private String author;

    private LocalDate published;

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublished() {
        return published;
    }

    public void setPublished(LocalDate published) {
        this.published = published;
    }

    //we override toString() method to print what we want from this object when we use something like
    // System.out.println(book)
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", published=" + published +
                '}';
    }
}
