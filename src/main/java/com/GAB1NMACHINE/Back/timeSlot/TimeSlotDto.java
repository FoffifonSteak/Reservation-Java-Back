package com.GAB1NMACHINE.Back.timeSlot;

import java.util.Date;
import java.util.UUID;

public record TimeSlotDto(UUID id, boolean isAvailable, Date date) {

}
