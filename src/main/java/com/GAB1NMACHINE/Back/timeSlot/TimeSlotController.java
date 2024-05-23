package com.GAB1NMACHINE.Back.timeSlot;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/api/timeslots")
@RestController
public class TimeSlotController {

    private final TimeSlotServices timeSlotServices;

    @PostMapping
    public TimeSlotDto createTimeSlots(@RequestBody TimeSlotDto newTimeslot) {
        return new TimeSlotDto(UUID.randomUUID(), newTimeslot.isAvailable(), new Date());
    }

    @GetMapping
    public List<TimeSlotDto> generateTimeSlots() {
        return this.timeSlotServices.generateTimeSlots();
    }

}
