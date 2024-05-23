package com.GAB1NMACHINE.Back.reservation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Reservation")
public class ReservationEntity {

    @Id
    @Column(name = "reservation_id")
    private UUID id;

    @Column(name = "user_id", nullable = false)
    private UUID user_id;

    @Column(name = "timeSlot_id", nullable = false)
    private UUID timeSlot_id;

    @Column(name = "Is_available", nullable = false)
    private boolean isAvailable;
}
