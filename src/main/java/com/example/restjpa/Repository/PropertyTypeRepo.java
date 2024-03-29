package com.example.restjpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.opnu.springlab2.Entity.Property;
import ua.opnu.springlab2.Entity.PropertyType;

import java.util.List;

public interface PropertyTypeRepo extends JpaRepository<PropertyType, Long> {
    List<PropertyType> findTop3ByOrderByPropertiesDesc();

    @Query("SELECT pt, COUNT(p) as propertyCount " +
            "FROM PropertyType pt " +
            "LEFT JOIN pt.properties p " +
            "GROUP BY pt.id " +
            "ORDER BY propertyCount DESC")
    List<Object[]> findTopThreeWithProperties();
}
