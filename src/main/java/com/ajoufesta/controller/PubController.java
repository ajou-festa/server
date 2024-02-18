package com.ajoufesta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ajoufesta.service.PubService;
import org.springframework.http.ResponseEntity;
import com.ajoufesta.dto.AddPubsDto;
import com.ajoufesta.dto.PubDto;

import java.util.List;

@RestController
@RequestMapping("/v1/pubs")
public class PubController {
    @Autowired
    private PubService pubService;

    @GetMapping
    public ResponseEntity<List<PubDto>> getDayBoothesByDay(@RequestParam(required = false) Integer day,
            @RequestParam(required = false) String section) {
        return ResponseEntity.ok(pubService.getDayPubsByDayAndSection(day, section));
    }

    @PostMapping("/admin")
    public ResponseEntity<String> addDaySchedule(@RequestBody AddPubsDto dayPubs) {
        return ResponseEntity.ok(pubService.addDaySchedule(dayPubs));
    }

    @PostMapping("/manager/{pubId}/info")
    public ResponseEntity<PubDto> postMethodName(@PathVariable String pubId, @RequestBody PubDto pubDto) {
        return ResponseEntity.ok(pubService.updatePubInfo(pubId, pubDto));
    }
}
