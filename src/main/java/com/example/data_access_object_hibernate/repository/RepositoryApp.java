package com.example.data_access_object_hibernate.repository;

import com.example.data_access_object_hibernate.entity.Persons;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class RepositoryApp {

    @PersistenceContext
    private EntityManager manager;

    public List<Persons> getPersonsByCity(String city) {
        var result = manager.createNamedQuery("findPersonByCity").setParameter("city", city).getResultList();
        System.out.println(result);
        return result;
    }
}