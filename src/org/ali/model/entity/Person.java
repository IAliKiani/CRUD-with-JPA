package org.ali.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "person")
@Table(name = "person")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(columnDefinition = "VARCHAR2(10)", unique = true, nullable = false)
    private String nationalCode;
    @Column(columnDefinition = "VARCHAR2(20)", nullable = false)
    private String name;
    @Column(columnDefinition = "VARCHAR2(20)", nullable = false)
    private String family;
    @Column(columnDefinition = "number(2)", nullable = false)
    private int age;
    @Version
    private int version;

    public Person(long id, String name, String family, int age,int version) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.age = age;
        this.version = version;
    }

    public Person (String name, String family, int age, String nationalCode) {
        this.name = name;
        this.family = family;
        this.age = age;
        this.nationalCode = nationalCode;
    }

    public Person (long id, int version) {
        this.id = id;
        this.version = version;
    }

    public Person() {}

    public long getId() {
        return id;
    }

    public Person setId(long id) {
        this.id = id;
        return this;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public Person setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getFamily() {
        return family;
    }

    public Person setFamily(String family) {
        this.family = family;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    public int getVersion() {
        return version;
    }
}
