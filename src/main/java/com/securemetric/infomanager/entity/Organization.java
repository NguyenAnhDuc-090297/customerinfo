package com.securemetric.infomanager.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "organization", cascade = CascadeType.ALL)
    private List<Customer> employees;

    public Organization() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Customer> getCustomers() {
        return employees;
    }

    public void setCustomers(List<Customer> employees) {
        this.employees = employees;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
