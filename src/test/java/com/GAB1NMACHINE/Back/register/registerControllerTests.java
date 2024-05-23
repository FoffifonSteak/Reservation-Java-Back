package com.GAB1NMACHINE.Back.register;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class registerControllerTests {

    @Mock
    private RegisterServices registerService;

    @InjectMocks
    private RegisterController registerController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(registerController).build();
    }

    @Test
    void shouldCreateRegister() throws Exception {
        RegisterDto registerDto = new RegisterDto(UUID.randomUUID(), "John", "Doe", "john.doe@example.com", "password123", "password123");
        when(registerService.createRegister(any(RegisterDto.class))).thenReturn(registerDto);

        mockMvc.perform(post("/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"John\",\"surname\":\"Doe\",\"email\":\"john.doe@example.com\",\"password\":\"password123\",\"confirmPassword\":\"password123\"}"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldDeleteRegister() throws Exception {
        UUID id = UUID.randomUUID();
        mockMvc.perform(delete("/register/" + id.toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}