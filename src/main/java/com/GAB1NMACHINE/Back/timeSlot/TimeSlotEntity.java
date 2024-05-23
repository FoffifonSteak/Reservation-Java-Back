package com.GAB1NMACHINE.Back.timeSlot;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TimeSlot")
public class TimeSlotEntity {

    @Id
    @Column(name = "timeSlot_id")
    private UUID id;

    @Column(name = "is_available", nullable = false)
    private boolean available;

    @Column(name = "date", nullable = false)
    private Date date;

}
