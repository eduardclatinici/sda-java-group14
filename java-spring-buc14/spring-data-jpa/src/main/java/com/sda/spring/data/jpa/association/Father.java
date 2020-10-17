package com.sda.spring.data.jpa.association;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "father")
public class Father {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    //this is an example of a one-to-many relation:
    // a father can have more sons and a number of sons can have the same father
    //cascade= what operations on this entity should be cascaded (also executed)
    //  on the target of the association (e.g.: if we save a father that has 2 sons inside, then the sons should be saved too)
    //orphanRemoval= all the sons that remain without a father should be deleted
    //fetch = How the associated entities will be fetched
    //@JoinColumn will specify the column that will be created in the associated entity(Son)
    //      to make the conection(this means that it will be a foreign key) back to this entity(Father)
    //https://thorben-janssen.com/ultimate-guide-association-mappings-jpa-hibernate/
    //https://www.baeldung.com/spring-data-rest-relationships
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "father_id")
    private List<Son> sons = new ArrayList<>();
    //TODO: create another association relation (e.g. @OneToOne - bidrectional mapping, @ManyToMany)

    public Father(Long id, String name, List<Son> sons) {
        this.id = id;
        this.name = name;
        this.sons = sons;
    }

    public Father() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSons(List<Son> sons) {
        this.sons = sons;
    }

    public List<Son> getSons() {
        return sons;
    }

    @Override
    public String toString() {
        return "Father{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sons=" + sons +
                '}';
    }
}

