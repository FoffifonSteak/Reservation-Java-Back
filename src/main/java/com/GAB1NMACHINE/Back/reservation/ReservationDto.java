package com.GAB1NMACHINE.Back.reservation;

import java.util.UUID;

public record ReservationDto(UUID reservation_id, UUID user_id, UUID timeSlot_id, boolean isAvailable) {

    public ReservationDto {
        if (user_id == null) {
            throw new IllegalArgumentException("User id cannot be null");
        }
    }

    public boolean isValid() {
        return user_id != null;
    }
}
