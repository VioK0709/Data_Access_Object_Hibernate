package com.example.data_access_object_hibernate.repository;

import com.example.data_access_object_hibernate.entity.Persons;
import com.example.data_access_object_hibernate.entity.PersonsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonsRepository extends JpaRepository<Persons, PersonsId> {

    List<Persons> findByCity(String city);

    List<Persons> findByAge(Integer age);

    Optional<Persons> findByNameAndSurname(String name, String surname);
}