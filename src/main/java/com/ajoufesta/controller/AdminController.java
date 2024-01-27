package com.ajoufesta.controller;

import com.ajoufesta.dto.ShowDto;
import com.ajoufesta.service.ShowService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admin")
public class AdminController {

    @Autowired
    private ShowService showService;

    @GetMapping("/shows/show-turn")
    public String getShowTurn() {
        return "Get Show Turn";
    }

    @GetMapping("/booth/{boothId}/info")
    public String getBoothInfo(@PathVariable String boothId) {
        return "Get Booth Info for boothId: " + boothId;
    }

    @GetMapping("/pub/{pubId}/menu")
    public String getPubMenu(@PathVariable String pubId) {
        return "Get Menu for pubId: " + pubId;
    }

    @GetMapping("/pub/{pubId}/info")
    public String getPubInfo(@PathVariable String pubId) {
        return "Get Info for pubId: " + pubId;
    }

    @GetMapping("/pub/{pubId}/reservations")
    public String getPubReservations(@PathVariable String pubId) {
        return "Get Reservations for pubId: " + pubId;
    }

    @GetMapping("/pub/{pubId}/reservation/{reservationId}")
    public String getReservationDetails(@PathVariable String pubId, @PathVariable String reservationId) {
        return "Get Reservation Details for barId: " + pubId + ", reservationId: " + reservationId;
    }
}

