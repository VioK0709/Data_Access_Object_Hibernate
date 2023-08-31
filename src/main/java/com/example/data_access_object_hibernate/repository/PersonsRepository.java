package com.example.data_access_object_hibernate.repository;

import com.example.data_access_object_hibernate.entity.Persons;
import com.example.data_access_object_hibernate.entity.PersonsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonsRepository extends JpaRepository<Persons, PersonsId> {
    @Query("select p from Persons p where p.city = :city")
    List<Persons> findByCity(String city);

    @Query("select p from Persons p where p.age < :age ORDER BY p.age ASC ")
    List<Persons> findByAgeLessThanOrderByAge(Integer age);

    @Query("select p from Persons p where p.name = :name and p.surname = :surname")
    Optional<Persons> findByNameAndSurname(String name, String surname);
}