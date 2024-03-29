package com.example.restjpa.Services;

import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.opnu.springlab2.Entity.PropertyType;
import ua.opnu.springlab2.Repository.PropertyRepo;
import ua.opnu.springlab2.Repository.PropertyTypeRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyTypeService {
    @Autowired
    private PropertyTypeRepo propertyTypeRepo;

    public List<PropertyType> propertyTypes (){
        return propertyTypeRepo.findAll();
    }

    public List<PropertyType> getTopThreeWithProperties() {
        List<PropertyType> result = new ArrayList<>();

        // Получение результата из репозитория
        List<Object[]> rows = propertyTypeRepo.findTopThreeWithProperties();

        // Обработка результатов запроса
        for (Object[] row : rows) {
            PropertyType propertyType = (PropertyType) row[0];
            result.add(propertyType);
        }

        return result;
    }

}
