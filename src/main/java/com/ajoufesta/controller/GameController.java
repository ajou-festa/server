package com.ajoufesta.controller;

import com.ajoufesta.domain.Ranking;
import com.ajoufesta.dto.AddClubsDto;
import com.ajoufesta.dto.AddRankingDto;
import com.ajoufesta.dto.ClubDto;
import com.ajoufesta.dto.RankingDto;
import com.ajoufesta.service.ClubService;
import com.ajoufesta.service.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/game")
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<RankingDto>> getDayClubsByDay() {
        return ResponseEntity.ok(gameService.getRanking());
    }

    // @PostMapping("/admin")
    // public ResponseEntity<String> addClubs(@RequestBody AddClubsDto addClubsDto) {
    //     return ResponseEntity.ok(gameService.addClubs(addClubsDto));
    // }

    @PostMapping("/manager")
    public ResponseEntity<String> updateBooth(@RequestBody AddRankingDto addRankingDto) {
        return ResponseEntity.ok(gameService.addRanking(addRankingDto));
    }

    @GetMapping("/manager")
    public ResponseEntity<List<Ranking>> updateBooth() {
        return ResponseEntity.ok(gameService.getAllRanking());
    }

}
