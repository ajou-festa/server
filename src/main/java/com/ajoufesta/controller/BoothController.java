package com.ajoufesta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ajoufesta.service.BoothService;
import org.springframework.http.ResponseEntity;
import com.ajoufesta.dto.AddBoothesDto;
import com.ajoufesta.dto.BoothDto;

import java.util.List;

@RestController
@RequestMapping("/v1/boothes")
public class BoothController {
    @Autowired
    private BoothService boothService;

    @GetMapping
    public ResponseEntity<List<BoothDto>> getDayBoothesByDay(@RequestParam(required = false) Integer day,
            @RequestParam(required = false) String section) {
        return ResponseEntity.ok(boothService.getDayBoothesByDayAndSection(day, section));
    }

    @PostMapping("/admin")
    public ResponseEntity<String> addBoothes(@RequestBody AddBoothesDto dayBoothes) {
        System.out.println(dayBoothes);
        return ResponseEntity.ok(boothService.addBoothes(dayBoothes));
    }

    @PostMapping("/manager/{boothId}/info")
    public ResponseEntity<BoothDto> updateBooth(@PathVariable String boothId, @RequestBody BoothDto boothDto) {
        return ResponseEntity.ok(boothService.updateBoothInfo(boothId, boothDto));
    }

}
