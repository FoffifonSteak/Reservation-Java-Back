package com.gab1machine.fridge.reservation;

import com.gab1machine.fridge.storage.StorageDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/reservations")
@RestController
public class ReservationController {
    private final ReservationServices reservationServices;

    @Operation(summary = "Get all reservations")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retreived successfully",
                    content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = ReservationDto.class))
                            )
                    }),
    })
    @GetMapping
    public @ResponseBody ResponseEntity<List<ReservationDto>> getReservations() {
        return ResponseEntity.ok(this.reservationServices.getAll());
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<ReservationOutputDto> getReservation(@PathVariable @RequestParam(name = "id", required = false) UUID id) {
        if (id != null) {
            Optional<ReservationDto> dto = this.reservationServices.getReservation(id);
            return dto.map(reservationDto -> ResponseEntity.ok(this.reservationServices.dtoToODto(reservationDto))).orElseGet(() -> ResponseEntity.badRequest().build());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Create a Reservation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created successfully",
                content = {
                    @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ReservationDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid Informations (date or storage invalid)",
                    content = @Content
            ),
    })
    @PostMapping
    public @ResponseBody ResponseEntity<ReservationOutputDto> postStorage(@RequestBody ReservationDto requestDto) {
        Optional<ReservationDto> dto = this.reservationServices.createReservation(requestDto);
        return dto.map(reservationDto -> ResponseEntity.ok(this.reservationServices.dtoToODto(reservationDto))).orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
