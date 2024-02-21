package com.ajoufesta.controller;

import com.ajoufesta.dto.AddClubsDto;
import com.ajoufesta.dto.ClubDto;
import com.ajoufesta.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/clubs")
public class ClubController {
    @Autowired
    private ClubService clubService;

    @GetMapping
    public ResponseEntity<List<ClubDto>> getDayClubsByDay(@RequestParam(required = false) Integer day,
                                                          @RequestParam(required = false) String section) {
        return ResponseEntity.ok(clubService.getClubsByDayAndSection(day, section));
    }

    @PostMapping("/admin")
    public ResponseEntity<String> addBoothes(@RequestBody AddClubsDto addClubsDto) {
        System.out.println(addClubsDto);
        return ResponseEntity.ok(clubService.addBoothes(addClubsDto));
    }

    @PostMapping("/manager/{boothId}/info")
    public ResponseEntity<ClubDto> updateBooth(@PathVariable String clubId, @RequestBody ClubDto clubDto) {
        return ResponseEntity.ok(clubService.updateClubInfo(clubId, clubDto));
    }

}
