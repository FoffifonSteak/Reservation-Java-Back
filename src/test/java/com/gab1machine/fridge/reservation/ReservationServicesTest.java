package com.gab1machine.fridge.reservation;

import com.gab1machine.fridge.common.NamedAPIResourceServices;
import com.gab1machine.fridge.storage.StorageServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ReservationServicesTest {

    @Mock
    private ReservationRepository reservationRepository;

    @Mock
    private NamedAPIResourceServices namedAPIResourceServices;

    @Mock
    private StorageServices storageServices;

    @InjectMocks
    private ReservationServices reservationServices;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetReservation() {
        UUID id = UUID.randomUUID();
        ReservationEntity entity = new ReservationEntity();
        entity.setId(id);
        entity.setDate(new Date());
        entity.setSize(10);
        entity.setStorage(UUID.randomUUID());

        when(reservationRepository.findById(id)).thenReturn(Optional.of(entity));

        Optional<ReservationDto> result = reservationServices.getReservation(id);

        assertTrue(result.isPresent());
        assertEquals(id, result.get().id());
    }

    @Test
    public void testCreateReservationWhenStorageDoesNotExist() {
        ReservationDto dto = new ReservationDto(UUID.randomUUID(), new Date(), 10, UUID.randomUUID());

        when(storageServices.exist(dto.storage())).thenReturn(false);
        when(reservationRepository.save(any(ReservationEntity.class))).thenReturn(new ReservationEntity());

        Optional<ReservationDto> result = reservationServices.createReservation(dto);

        assertTrue(result.isPresent());
        verify(reservationRepository, times(1)).save(any(ReservationEntity.class));
    }

    @Test
    public void testCreateReservationWhenStorageExists() {
        ReservationDto dto = new ReservationDto(UUID.randomUUID(), new Date(), 10, UUID.randomUUID());

        when(storageServices.exist(dto.storage())).thenReturn(true);

        Optional<ReservationDto> result = reservationServices.createReservation(dto);

        assertTrue(result.isEmpty());
    }
}
