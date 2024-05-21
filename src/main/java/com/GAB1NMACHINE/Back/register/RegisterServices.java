package com.GAB1NMACHINE.Back.register;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.UUID;

@RequiredArgsConstructor
@Service
public class RegisterServices {

    private final RegisterRepository registerRepository;
    //private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public RegisterDto createRegister(RegisterDto registerDto) {
        //String encodedPassword = passwordEncoder.encode(registerDto.password());
        RegisterEntity registerEntity = new RegisterEntity(
                UUID.randomUUID(),
                registerDto.name(),
                registerDto.surname(),
                registerDto.email(),
                registerDto.password()
                //encodedPassword
        );

        RegisterEntity savedEntity = registerRepository.save(registerEntity);
        return new RegisterDto(
                savedEntity.getId(),
                savedEntity.getName(),
                savedEntity.getSurname(),
                savedEntity.getEmail(),
                savedEntity.getPassword(),
                savedEntity.getPassword()
        );
    }

    public void deleteRegister(UUID id) {
        registerRepository.deleteById(id);
    }
}
