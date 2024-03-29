package com.example.restjpa.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity(name = "Property")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String adress;
    private BigDecimal price;
    private int size;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "typeId")
    private PropertyType typeId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ownerId")
    private Owner owner;



   // Attributes: id, address, price, size, typeId, ownerId
}
