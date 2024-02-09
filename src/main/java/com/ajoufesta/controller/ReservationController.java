package com.ajoufesta.controller;

import com.ajoufesta.dto.CreateReservationDto;
import com.ajoufesta.dto.GetReservationDto;
import com.ajoufesta.service.ReservationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public ResponseEntity<String> createReservation(@RequestBody CreateReservationDto reservationDto) {
        String reservationId = reservationService.createReservation(reservationDto);
        return ResponseEntity.ok(reservationId);
    }

    @GetMapping("/my-reservation")
    public ResponseEntity<List<GetReservationDto>> getReservationByPhoneNumber(@RequestParam(required = false) String phone) {
        List<GetReservationDto> reservation = reservationService.findReservationsByPhoneNumber(phone);

        return ResponseEntity.ok(reservation);
    }
}
