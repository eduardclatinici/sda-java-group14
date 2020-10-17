package com.sda.spring.data.jpa.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Integer age;

    private BigDecimal salary;

    //TODO: add some validations like @Email or @NotNull
    private String email;

    public Person(String name, Integer age, BigDecimal salary, String email) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.email = email;
    }

    public Person() {

    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", salary=" + salary +
                ", email='" + email + '\'' +
                '}';
    }
}
