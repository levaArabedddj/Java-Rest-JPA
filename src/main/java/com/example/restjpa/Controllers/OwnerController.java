package com.example.restjpa.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.opnu.springlab2.Entity.Owner;
import ua.opnu.springlab2.Services.OwnerService;

import java.util.List;
import java.util.Optional;

@RestController
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping("/owners/{ownerId}/properties")
    public Optional<Owner> getPropertiesByOwnerId(@PathVariable long ownerId) {
        return ownerService.getOwnerByPropertyId(ownerId);
    }

    @GetMapping("/owners")
    public List<Owner> getOwnersWithPropertiesGreaterThan(@RequestParam int propertyCount) {
        return ownerService.findOwnersWithPropertiesGreaterThan(propertyCount);
    }
}
