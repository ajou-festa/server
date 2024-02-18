package com.ajoufesta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ajoufesta.service.BoothService;
import com.ajoufesta.domain.DayBoothes;
import com.ajoufesta.dto.AddBoothesDto;
import com.ajoufesta.dto.BoothDto;

import java.util.List;

@RestController
@RequestMapping("/v1/boothes")
public class BoothController {
    @Autowired
    private BoothService boothService;

    @GetMapping
    public List<BoothDto> getDayBoothesByDay(@RequestParam(required = false) Integer day,
            @RequestParam(required = false) String section) {
        return boothService.getDayBoothesByDayAndSection(day, section);
    }

    @PostMapping("/admin")
    public String addBoothes(@RequestBody AddBoothesDto dayBoothes) {
        return boothService.addBoothes(dayBoothes);
    }

    @PostMapping("/manager/{boothId}/info")
    public BoothDto updateBooth(@PathVariable String boothId, @RequestBody BoothDto boothDto) {
        return boothService.updateBoothInfo(boothId, boothDto);
    }

}
