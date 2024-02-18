package com.ajoufesta.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ajoufesta.service.ShowService;
import com.ajoufesta.domain.DayShows;
import com.ajoufesta.dto.AddShowsDto;
import com.ajoufesta.dto.ShowDto;
import com.ajoufesta.dto.UpdateShowTurnDto;

import java.util.List;

@RestController
@RequestMapping("/v1/shows")
public class ShowController {
    @Autowired
    private ShowService showService;

    @GetMapping
    public List<ShowDto> getDayShowsByDay(@RequestParam(required = false) Integer day) {
        return showService.getDayShowsByDay(day);
    }

    @PostMapping("/manager/show-turn")
    public Integer updateShowTurn(@RequestBody UpdateShowTurnDto nowShow) {
        return showService.updateShowTurn(nowShow);
    }

    @PostMapping("/admin")
    public String addShows(@RequestBody AddShowsDto dayShows) {
        return showService.addShows(dayShows);
    }

}
