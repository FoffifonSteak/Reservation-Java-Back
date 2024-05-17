package com.gab1machine.fridge.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository

public interface StorageRepository extends JpaRepository<StorageEntity, UUID> {
    /*boolean existsByLabel(String label);*/
}