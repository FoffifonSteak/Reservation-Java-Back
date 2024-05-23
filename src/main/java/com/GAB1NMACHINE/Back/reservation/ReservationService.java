package com.GAB1NMACHINE.Back.reservation;


import com.GAB1NMACHINE.Back.timeSlot.TimeSlotEntity;
import com.GAB1NMACHINE.Back.timeSlot.TimeSlotRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final TimeSlotRepository timeSlotRepository;

    public ReservationDto coffeeReservation(ReservationDto reservation) {
        log.info("Start reservation for {} slot id and user {}.", reservation.timeSlot_id(), reservation.user_id());
        if (timeSlotRepository.existsById(reservation.timeSlot_id())) {
            TimeSlotEntity timeSlot = timeSlotRepository.findById(reservation.timeSlot_id()).get();
            if (!timeSlot.isAvailable()) {
                // Create the reservation
                ReservationEntity newReservation = new ReservationEntity(UUID.randomUUID(), reservation.user_id(), reservation.timeSlot_id(), false);
                reservationRepository.save(newReservation);

                // Update the time slot
                timeSlot.setAvailable(true);
                timeSlotRepository.save(timeSlot);

                return new ReservationDto(newReservation.getId(), newReservation.getUser_id(), newReservation.getTimeSlot_id(), newReservation.isAvailable());

            }
            return null;
        }
        return null;
    }
}
