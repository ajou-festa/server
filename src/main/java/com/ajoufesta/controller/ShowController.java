package com.ajoufesta.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ajoufesta.service.ShowService;
import org.springframework.http.ResponseEntity;
import com.ajoufesta.dto.AddShowsDto;
import com.ajoufesta.dto.ShowDto;

import java.util.List;

@RestController
@RequestMapping("/v1/shows")
@CrossOrigin(origins = "https://ajoufesta.com")
public class ShowController {
    @Autowired
    private ShowService showService;

    @GetMapping
    public ResponseEntity<List<ShowDto>> getDayShowsByDay(@RequestParam(required = false) Integer day) {
        return ResponseEntity.ok(showService.getDayShowsByDay(day));
    }

    @PostMapping("/admin")
    public ResponseEntity<String> addShows(@RequestBody AddShowsDto dayShows) {
        return ResponseEntity.ok(showService.addShows(dayShows));
    }

}
