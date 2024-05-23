package com.GAB1NMACHINE.Back.register;

import org.junit.jupiter.api.Test;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class registerDtoTests {

    @Test
    void shouldCreateValidRegisterDto() {
        RegisterDto registerDto = new RegisterDto(UUID.randomUUID(), "John", "Doe", "john.doe@example.com", "password123", "password123");
        assertTrue(registerDto.isValid());
    }

    @Test
    void shouldThrowExceptionWhenNameIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new RegisterDto(UUID.randomUUID(), null, "Doe", "john.doe@example.com", "password123", "password123"));
    }

    @Test
    void shouldThrowExceptionWhenSurnameIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new RegisterDto(UUID.randomUUID(), "John", null, "john.doe@example.com", "password123", "password123"));
    }

    @Test
    void shouldThrowExceptionWhenEmailIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new RegisterDto(UUID.randomUUID(), "John", "Doe", null, "password123", "password123"));
    }

    @Test
    void shouldThrowExceptionWhenPasswordIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new RegisterDto(UUID.randomUUID(), "John", "Doe", "john.doe@example.com", null, "password123"));
    }

    @Test
    void shouldThrowExceptionWhenConfirmPasswordIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new RegisterDto(UUID.randomUUID(), "John", "Doe", "john.doe@example.com", "password123", null));
    }

    @Test
    void shouldThrowExceptionWhenPasswordsDoNotMatch() {
        assertThrows(IllegalArgumentException.class, () -> new RegisterDto(UUID.randomUUID(), "John", "Doe", "john.doe@example.com", "password123", "password321"));
    }
}

