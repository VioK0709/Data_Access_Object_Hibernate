package com.example.data_access_object_hibernate.controller;

import com.example.data_access_object_hibernate.entity.Persons;
import com.example.data_access_object_hibernate.service.ServiceApp;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ControllerApp {

    private final ServiceApp serviceApp;

    public ControllerApp(ServiceApp serviceApp) {
        this.serviceApp = serviceApp;
    }

    @GetMapping("/persons/by-city")
    @ResponseBody
    public List<Persons> getPersonsByCity(@RequestParam("city") String city) {
        return serviceApp.getPersonsByCity(city);
    }

    @GetMapping("/persons/by-age")
    @ResponseBody
    public List<Persons> getPersonsByAge(@RequestParam("age") Integer age) {
        return serviceApp.getPersonsByAge(age);
    }

    @GetMapping("/persons/by-name-and-surname")
    @ResponseBody
    public Optional<Persons> getPersonsByNameAndSurname(@RequestParam("name") String name, @RequestParam() String surname) {
        return serviceApp.getPersonsByNameAndSurname(name, surname);
    }
}

//localhost:8080/persons/by-city?city=Irkutsk
//localhost:8080/persons/by-age?age=33
//localhost:8080/persons/by-name-and-surname?name=Каземир&surname=Зорин