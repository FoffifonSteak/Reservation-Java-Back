package com.GAB1NMACHINE.Back.reservation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/api/coffee")
@RestController
public class ReservationController {

        private final ReservationService reservationService;

        @PutMapping
        public @ResponseBody ReservationDto coffeeReservation(@RequestBody ReservationDto reservation) {
            return this.reservationService.coffeeReservation(reservation);
        }
}
