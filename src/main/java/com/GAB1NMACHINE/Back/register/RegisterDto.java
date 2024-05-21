package com.GAB1NMACHINE.Back.register;

import java.util.UUID;

public record RegisterDto(UUID id, String name, String surname, String email, String password, String confirmPassword) {

    public RegisterDto {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        if (surname == null || surname.isBlank()) {
            throw new IllegalArgumentException("Surname cannot be null or blank");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or blank");
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password cannot be null or blank");
        }
        if (!password.equals(confirmPassword)) {
            throw new IllegalArgumentException("Passwords do not match");
        }
    }

    public boolean isValid() {
        return password.equals(confirmPassword);
    }
}
