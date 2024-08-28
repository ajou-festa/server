package com.ajoufesta.controller;

import com.ajoufesta.dto.AddClubsDto;
import com.ajoufesta.dto.ClubDto;
import com.ajoufesta.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/clubs")
@CrossOrigin(origins = "https://ajoufesta.com")
public class ClubController {
    @Autowired
    private ClubService clubService;

    @GetMapping
    public ResponseEntity<List<ClubDto>> getDayClubsByDay(@RequestParam(required = false) Integer day,
                                                          @RequestParam(required = false) String section) {
        return ResponseEntity.ok(clubService.getClubsByDayAndSection(day, section));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClubDto>> getAllClubs() {
        return ResponseEntity.ok(clubService.getAllClubs());
    }

    @GetMapping("/id")
    public ResponseEntity<ClubDto> getClubById(@RequestParam Long id) {
        Optional<ClubDto> club = clubService.findClubById(id);
        return club.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/admin")
    public ResponseEntity<String> addClubs(@RequestBody AddClubsDto addClubsDto) {
        return ResponseEntity.ok(clubService.addClubs(addClubsDto));
    }

}
