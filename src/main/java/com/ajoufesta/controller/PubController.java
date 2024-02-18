package com.ajoufesta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ajoufesta.service.PubService;
import com.ajoufesta.domain.DayPubs;
import com.ajoufesta.dto.AddPubsDto;
import com.ajoufesta.dto.PubDto;

import java.util.List;

@RestController
@RequestMapping("/v1/pubs")
public class PubController {
    @Autowired
    private PubService pubService;

    @GetMapping
    public List<PubDto> getDayBoothesByDay(@RequestParam(required = false) Integer day,
            @RequestParam(required = false) String section) {
        return pubService.getDayPubsByDayAndSection(day, section);
    }

    @PostMapping("/admin")
    public String addDaySchedule(@RequestBody AddPubsDto dayPubs) {
        return pubService.addDaySchedule(dayPubs);
    }

    @PostMapping("/manager/{pubId}/info")
    public PubDto postMethodName(@PathVariable String pubId, @RequestBody PubDto pubDto) {
        return pubService.updatePubInfo(pubId, pubDto);
    }
}
