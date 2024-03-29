package com.example.restjpa.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.opnu.springlab2.Entity.PropertyType;
import ua.opnu.springlab2.Services.PropertyTypeService;

import java.util.List;

@RestController
public class PropertyTypeControllers {
    private final PropertyTypeService propertyTypeService;

    public PropertyTypeControllers(PropertyTypeService propertyTypeService) {
        this.propertyTypeService = propertyTypeService;
    }

 @GetMapping("/get_types")
    public List<PropertyType> propertyTypes(){
        return propertyTypeService.propertyTypes();
    }

    @GetMapping("/top-three-with-properties")
    public List<PropertyType> getTopThreeWithProperties() {
        return propertyTypeService.getTopThreeWithProperties();
    }
}
