package com.GAB1NMACHINE.Back.register;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/register")
@RestController
public class RegisterController {

    private final RegisterServices registerService;

    @PostMapping
    public @ResponseBody RegisterDto createRegister(@RequestBody RegisterDto register) {
        return this.registerService.createRegister(register);
    }

    @DeleteMapping("/{id}")
    public void deleteRegister(@PathVariable UUID id) {
        this.registerService.deleteRegister(id);
    }
}
