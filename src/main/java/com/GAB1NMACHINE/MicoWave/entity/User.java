package com.GAB1NMACHINE.MicoWave.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    private String name;

    private String email;

    private String password;

    private String hashedPassword;

    public String getName() {
        return name;
    }

    public void setName(String johnDoe) {
    }
}
