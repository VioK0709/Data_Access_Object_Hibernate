package com.example.data_access_object_hibernate.service;

import com.example.data_access_object_hibernate.entity.Persons;
import com.example.data_access_object_hibernate.repository.RepositoryApp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ServiceApp {

    private final RepositoryApp repositoryApp;

    public List<Persons> getCityOfLiving(String city) {
        return repositoryApp.getPersonsByCity(city);
    }
}