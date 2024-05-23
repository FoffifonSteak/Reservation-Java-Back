package com.GAB1NMACHINE.Back.timeSlot;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
@Slf4j
public class TimeSlotServices {
    private final TimeSlotRepository timeSlotRepository;

    public List<TimeSlotDto> generateTimeSlots() {
        log.info("Generating time slots");
        List<TimeSlotDto> timeSlots = new ArrayList<>();
        this.timeSlotRepository.findAll().forEach(timeSlot -> {
            TimeSlotDto newTimeSlotInput = new TimeSlotDto(timeSlot.getId(), timeSlot.isAvailable(), timeSlot.getDate());
            timeSlots.add(newTimeSlotInput);
        });

        if (timeSlots.isEmpty()) {
            log.info("No time slots found, generating new time slots");
            Calendar calendar = Calendar.getInstance();
            Date startTime = this.getTime(8, 30);
            Date endTime = this.getTime(17, 0);
            calendar.setTime(startTime);

            while (calendar.getTime().before(endTime) || calendar.getTime().equals(endTime)) {
                Date date = calendar.getTime();
                boolean isAvailable = false;
                TimeSlotEntity newTimeSlot = new TimeSlotEntity(UUID.randomUUID(), isAvailable, date);
                this.timeSlotRepository.save(newTimeSlot);
                TimeSlotDto newTimeSlotInput = new TimeSlotDto(newTimeSlot.getId(), newTimeSlot.isAvailable(), newTimeSlot.getDate());
                timeSlots.add(newTimeSlotInput);
                calendar.add(Calendar.MINUTE, 5);
            }
        }
        return timeSlots;
    }

    private Date getTime(int hour, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        return calendar.getTime();
    }
}
