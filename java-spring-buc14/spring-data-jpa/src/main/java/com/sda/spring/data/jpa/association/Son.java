package com.sda.spring.data.jpa.association;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "son")
public class Son {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Son(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Son() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Son{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
