package com.example.restjpa.Services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.opnu.springlab2.Entity.Owner;
import ua.opnu.springlab2.Entity.Property;
import ua.opnu.springlab2.Repository.OwnerRepo;
import ua.opnu.springlab2.Repository.PropertyRepo;
import ua.opnu.springlab2.Repository.PropertyTypeRepo;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {
    @Autowired
    private PropertyRepo propertyRepo;

    @Autowired
    private PropertyTypeRepo propertyTypeRepository;

    @Autowired
    private OwnerRepo ownerRepository;


    public Property getPropertyBuId(Long id){
        return propertyRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Property not found with id:" + id));
    }

    public Property createProperty(Property property){
        return propertyRepo.save(property);
    }

    public List<Property> getAllPropertiesWithOwners() {
        return propertyRepo.findAll(); // Предполагается, что у вас есть метод findAll() в вашем репозитории
    }

    public List<Property> getPropertyAbovePrice(double minPrice) {
        return propertyRepo.findByPriceGreaterThan(minPrice);
    }

    public List<Property> getBetweenSize(int minSize, int maxSize){
        return propertyRepo.findBySizeBetween(minSize, maxSize);
    }

}
