package com.example.restjpa.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "PropertyType")
public class PropertyType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String typeName;
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "typeId")
    private List<Property> properties;

}
