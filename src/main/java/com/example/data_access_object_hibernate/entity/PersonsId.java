package com.example.data_access_object_hibernate.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class PersonsId implements Serializable {

    private String name;
    private String surname;
    private int age;
}