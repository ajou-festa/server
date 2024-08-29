package com.ajoufesta.controller;

import com.ajoufesta.dto.VoteResultCount;
import com.ajoufesta.dto.VoteResultDto;
import com.ajoufesta.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/vote")
@CrossOrigin(origins = "https://ajoufesta.com")
public class VoteController {

    @Autowired
    private VoteService voteService;

    @PostMapping("/submit")
    public ResponseEntity<String> submitVote(@RequestBody VoteResultDto voteResultDto) {
        voteService.saveVoteResult(voteResultDto);
        return ResponseEntity.ok("success");
    }

    @GetMapping("/statistics")
    public ResponseEntity<List<VoteResultCount>> getVoteStatistics() {
        return ResponseEntity.ok(voteService.getVoteStatistics());
    }
}
