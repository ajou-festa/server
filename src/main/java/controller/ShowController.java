package com.ajoufesta.controller;

import com.ajoufesta.dto.ShowDto;
import com.ajoufesta.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import java.util.List;

@RestController
@RequestMapping("/v1/shows")
public class ShowController {

    @Autowired
    private ShowService showService;

    @GetMapping("/{day}")
    public List<ShowDto> getShowsByDay(@PathVariable @Pattern(regexp = "day1|day2|day3|today") @Valid String day) {
        return showService.getShowsByDay(day);
    }
    
    // 예를 들어, ShowDto를 요청 본문으로 받는 POST 요청 처리 메소드
    @PostMapping
    public ShowDto createShow(@RequestBody @Valid ShowDto showDto) {
        // ShowDto 처리 로직
        return showDto;
    }
}
