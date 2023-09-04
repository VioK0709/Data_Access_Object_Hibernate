package com.example.data_access_object_hibernate.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecureController {
    @GetMapping("/hello")
    public String getHello() {
        return "Hello!";
    }

    @GetMapping("/hello-read")
    @Secured("ROLE_READ")
    public String getRead() {
        return "Hello from secure app, reader!";
    }

    @GetMapping("/hello-write")
    @RolesAllowed("WRITE")
    public String getWrite() {
        return "Hello from secure app, writer!";
    }

    @GetMapping("/write-and-delete")
    @PreAuthorize("hasRole('WRITE') or hasRole('DELETE') ")
    public String getWriteOrDelete() {
        return "Hello from secure app, writer or delete!";
    }

    @GetMapping("/username")
    @PostAuthorize("#username == authentication.principal.username")
    public String getUserName(String username) {
        return "Hello from secure app, " + username + "!";
    }
}