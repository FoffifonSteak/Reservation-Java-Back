package com.gab1machine.fridge.reservation;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.UUID;
import com.gab1machine.fridge.reservation.ReservationDto;

@ExtendWith(MockitoExtension.class)
public class ReservationServicesTests {
    @Mock
    private ReservationRepository repositoryMock;
    @InjectMocks
    private ReservationServices service;

    @Test
    void createSeason() {
        // Given
        ReservationDto reservationDto = new ReservationDto(null, new Date(2024-05-17), 2, null);
        BDDMockito.given(this.repositoryMock.existsById(BDDMockito.any(UUID.class))).willReturn(false);
        BDDMockito.given(this.repositoryMock.save(BDDMockito.any())).willAnswer(AdditionalAnswers.returnsFirstArg());

        // When
        ReservationDto createdReservation = this.service.createReservation(reservationDto).orElseThrow();

        // Then
        Assertions.assertThat(createdReservation)
                .isNotNull()
                .extracting("date")
                .isEqualTo(reservationDto.date());
    }

}


