package com.ajoufesta.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ajoufesta.service.ShowService;
import com.ajoufesta.domain.DaySchedule;

import java.util.List;

@RestController
@RequestMapping("/v1/shows")
public class ShowController {
    @Autowired
    private ShowService service;

    @PostMapping
    public DaySchedule addDaySchedule(@RequestBody DaySchedule daySchedule) {
        return service.saveDaySchedule(daySchedule);
    }

    @GetMapping
    public List<DaySchedule> getAllDaySchedules() {
        return service.getAllDaySchedules();
    }

    @GetMapping("/{id}")
    public DaySchedule getDayScheduleById(@PathVariable String id) {
        return service.getDayScheduleById(id).orElse(null);
    }

    // 추가 엔드포인트를 구현할 수 있습니다.
}
