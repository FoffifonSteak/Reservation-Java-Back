package com.GAB1NMACHINE.Back.register;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RegisterServicesTest {

    @Mock
    private RegisterRepository registerRepository;

    @InjectMocks
    private RegisterServices registerServices;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateRegister() {
        RegisterDto registerDto = new RegisterDto(UUID.randomUUID(), "John", "Doe", "john.doe@example.com", "password123", "password123");
        RegisterEntity registerEntity = new RegisterEntity(registerDto.id(), registerDto.name(), registerDto.surname(), registerDto.email(), registerDto.password());

        when(registerRepository.save(any(RegisterEntity.class))).thenReturn(registerEntity);

        RegisterDto createdRegisterDto = registerServices.createRegister(registerDto);

        assertEquals(registerDto.id(), createdRegisterDto.id());
        assertEquals(registerDto.name(), createdRegisterDto.name());
        assertEquals(registerDto.surname(), createdRegisterDto.surname());
        assertEquals(registerDto.email(), createdRegisterDto.email());
        assertEquals(registerDto.password(), createdRegisterDto.password());
    }

    @Test
    void shouldDeleteRegister() {
        UUID id = UUID.randomUUID();

        doNothing().when(registerRepository).deleteById(id);

        registerServices.deleteRegister(id);

        verify(registerRepository, times(1)).deleteById(id);
    }
}