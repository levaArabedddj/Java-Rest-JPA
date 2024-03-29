package com.example.restjpa.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.springlab2.Entity.Owner;
import ua.opnu.springlab2.Entity.Property;
import ua.opnu.springlab2.Services.OwnerService;
import ua.opnu.springlab2.Services.PropertyService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/properties")
public class PropertyControllers {
    private final PropertyService propertyService;

    private final OwnerService ownerService;

    @Autowired
    public PropertyControllers(PropertyService propertyService, OwnerService ownerService) {
        this.propertyService = propertyService;
        this.ownerService = ownerService;
    }

    @PostMapping("/")
    public ResponseEntity<Property> createProperty(@RequestBody Property property){
        Property createdProperty = propertyService.createProperty(property);
        return ResponseEntity.created(URI.create("/api/properties/" + createdProperty.getId())).body(createdProperty);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Property> getPropertyByid(@PathVariable Long id){
        Property property = propertyService.getPropertyBuId(id);
        return ResponseEntity.ok().body(property);
    }

    @GetMapping("/owner_details")
    public List<Owner> getAllPropertiesWithOwners() {
        return ownerService.getAllPropertiesWithOwners();
    }

    @GetMapping("/specific_price")
    public List<Property>getPropertyAbovePrice(@RequestParam double minPrice){
        return propertyService.getPropertyAbovePrice(minPrice);
    }


    @GetMapping("/betweenSize")
    public List<Property> getBetweemSize(
            @RequestParam("minSize") int minSize,
            @RequestParam("maxSize") int maxSize)
    {
        return propertyService.getBetweenSize(minSize, maxSize);
    }

}
