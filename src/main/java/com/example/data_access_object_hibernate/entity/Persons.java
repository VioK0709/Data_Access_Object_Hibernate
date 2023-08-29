package com.example.data_access_object_hibernate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@Entity
@IdClass(PersonsId.class)
@Table(name = "persons", schema = "hibernate")
@AllArgsConstructor
@NoArgsConstructor
public class Persons implements Serializable {

    @Id
    @Column(nullable = false)
    private String name;
    @Id
    @Column(nullable = false)
    private String surname;
    @Id
    @Column(nullable = false)
    private int age;

    private int phoneNumber;
    @Column(name = "city_of_living")
    private String city;
}