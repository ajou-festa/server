package com.ajoufesta.controller;

import com.ajoufesta.dto.ShowDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import com.ajoufesta.service.ShowService;

import java.util.List;

@RestController
@RequestMapping("/v1/shows")
public class ShowController {

    @Autowired
    private ShowService showService;

    @GetMapping()
    public List<ShowDto> getShowsByDay(@RequestParam @Pattern(regexp = "day1|day2|day3|today") @Valid String day) {
        return showService.getShowsByDay(day);
    }
}
