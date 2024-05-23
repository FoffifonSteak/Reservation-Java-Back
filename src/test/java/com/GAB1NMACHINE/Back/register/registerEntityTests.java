package com.GAB1NMACHINE.Back.register;

import org.junit.jupiter.api.Test;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class registerEntityTests {

    @Test
    void shouldCreateRegisterEntityWithGivenValues() {
        RegisterEntity registerEntity = new RegisterEntity(UUID.randomUUID(), "John", "Doe", "john.doe@example.com", "password123");
        assertEquals("John", registerEntity.getName());
        assertEquals("Doe", registerEntity.getSurname());
        assertEquals("john.doe@example.com", registerEntity.getEmail());
        assertEquals("password123", registerEntity.getPassword());
    }

    @Test
    void shouldUpdateName() {
        RegisterEntity registerEntity = new RegisterEntity(UUID.randomUUID(), "John", "Doe", "john.doe@example.com", "password123");
        registerEntity.setName("Jane");
        assertEquals("Jane", registerEntity.getName());
    }

    @Test
    void shouldUpdateSurname() {
        RegisterEntity registerEntity = new RegisterEntity(UUID.randomUUID(), "John", "Doe", "john.doe@example.com", "password123");
        registerEntity.setSurname("Smith");
        assertEquals("Smith", registerEntity.getSurname());
    }

    @Test
    void shouldUpdateEmail() {
        RegisterEntity registerEntity = new RegisterEntity(UUID.randomUUID(), "John", "Doe", "john.doe@example.com", "password123");
        registerEntity.setEmail("jane.smith@example.com");
        assertEquals("jane.smith@example.com", registerEntity.getEmail());
    }

    @Test
    void shouldUpdatePassword() {
        RegisterEntity registerEntity = new RegisterEntity(UUID.randomUUID(), "John", "Doe", "john.doe@example.com", "password123");
        registerEntity.setPassword("password321");
        assertEquals("password321", registerEntity.getPassword());
    }
}