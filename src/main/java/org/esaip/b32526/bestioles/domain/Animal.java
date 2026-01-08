package org.esaip.b32526.bestioles.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "animal", schema = "bestioles")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "color", length = 50)
    private String color;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "sex", nullable = false)
    private String sex;

    @ManyToOne
    @JoinColumn(name = "species_id")
    private Species species;
    @ManyToMany(mappedBy = "animals")
    private Set<Person> persons;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}