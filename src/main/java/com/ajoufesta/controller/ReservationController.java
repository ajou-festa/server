package com.ajoufesta.controller;

import com.ajoufesta.dto.CancelReservationDto;
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
        List<GetReservationDto> reservation = reservationService.getReservationsByPhoneNumber(phone);

        return ResponseEntity.ok(reservation);
    }

    @GetMapping("/manager/:pubId")
    public ResponseEntity<List<GetReservationDto>> getReservationByPubId(@PathVariable String pubId) {
        List<GetReservationDto> reservation = reservationService.getReservationByPubId(pubId);

        return ResponseEntity.ok(reservation);
    }

    @PostMapping("/cancel")
    public String cancelReservation(@RequestBody CancelReservationDto cancelReservationDto) {
        return reservationService.cancelReservation(cancelReservationDto);
    }

}
