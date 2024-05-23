package com.GAB1NMACHINE.Back.register;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class registerRepositoryTests {

    @Autowired
    private RegisterRepository registerRepository;

    @Test
    void shouldReturnEmptyOptionalForNonExistentId() {
        Optional<RegisterEntity> fetchedEntity = registerRepository.findById(UUID.randomUUID());

        assertFalse(fetchedEntity.isPresent());
    }
}
