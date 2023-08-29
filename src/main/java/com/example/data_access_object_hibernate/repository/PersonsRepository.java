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
    @Query("select * from persons where city = :city")
    List<Persons> findByCity(String city);

    @Query("select * from persons where age < :age ORDER BY age ASC ")
    List<Persons> findByAge(Integer age);

    @Query("select * from persons where name, surname =: name, surname")
    Optional<Persons> findByNameAndSurname(String name, String surname);
}