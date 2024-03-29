package com.example.restjpa.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.opnu.springlab2.Entity.Owner;
import ua.opnu.springlab2.Repository.OwnerRepo;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {
    @Autowired
     private final OwnerRepo ownerRepo;

    public OwnerService(OwnerRepo ownerRepo) {
        this.ownerRepo = ownerRepo;
    }

    public List<Owner> getAllPropertiesWithOwners(){
        return ownerRepo.findAll();
    }

    public Optional<Owner> getOwnerByPropertyId(long propertyId) {
        return ownerRepo.findById(propertyId);
    }

    public List<Owner> findOwnersWithPropertiesGreaterThan(int propertyCount) {
        return ownerRepo.findOwnersWithPropertiesGreaterThan(propertyCount);
    }
}
