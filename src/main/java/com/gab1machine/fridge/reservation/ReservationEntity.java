package com.gab1machine.fridge.reservation;

import com.gab1machine.fridge.storage.StorageEntity;

import com.gab1machine.fridge.user.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@Entity
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private Date date;
    @Column(nullable = false)
    private Integer size;
    private UUID storage;
}
