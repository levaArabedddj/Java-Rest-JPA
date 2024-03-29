package com.example.restjpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.opnu.springlab2.Entity.Owner;

import java.util.List;

public interface OwnerRepo extends JpaRepository<Owner, Long> {

    @Query("SELECT o FROM Owner o WHERE SIZE(o.properties) > :propertyCount")
    List<Owner> findOwnersWithPropertiesGreaterThan(int propertyCount);
}
