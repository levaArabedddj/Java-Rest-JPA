package com.example.restjpa.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "Owner")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String contactNumber;
    private String email;

    @OneToMany(mappedBy = "owner")
    private List<Property> properties;

//    Attributes: id, name, contactNumber, email
//    Relations: One to Many with Property
}
