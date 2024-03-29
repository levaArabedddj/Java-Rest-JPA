package com.example.restjpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.opnu.springlab2.Entity.Property;

import java.util.List;

public interface PropertyRepo extends JpaRepository<Property, Long> {
    List<Property> findByPriceGreaterThan(double minPrice);

    @Query("SELECT p FROM Property p WHERE p.size BETWEEN :minSize AND :maxSize")
    List<Property> findBySizeBetween(double minSize, double maxSize);
}

