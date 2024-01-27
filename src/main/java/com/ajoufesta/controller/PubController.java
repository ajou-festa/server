package com.ajoufesta.controller;

import com.ajoufesta.dto.ShowDto;
import com.ajoufesta.service.ShowService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/pubs")
public class PubController {

    @Autowired
    private ShowService showService;

    @GetMapping()
    public List<ShowDto> getPubsByDay(@RequestParam @Pattern(regexp = "day1|day2|day3|today") @Valid String day) {
        return showService.getShowsByDay(day);
    }

    @GetMapping("/{pubId}")
    public List<ShowDto> getPubsById(@PathVariable @Valid String boothId) {
        return showService.getShowsByDay(boothId);
    }
}
