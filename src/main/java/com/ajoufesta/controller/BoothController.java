// package com.ajoufesta.controller;

// import com.ajoufesta.dto.ShowDto;
// import com.ajoufesta.service.ShowService;
// import jakarta.validation.Valid;
// import jakarta.validation.constraints.Pattern;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/v1/booths")
// public class BoothController {

//     @Autowired
//     private ShowService showService;

//     @GetMapping()
//     public List<ShowDto> getBoothsByDay(@RequestParam @Pattern(regexp = "day1|day2|day3|today") @Valid String day) {
//         return showService.getShowsByDay(day);
//     }

//     @GetMapping("/{boothId}")
//     public List<ShowDto> getBoothById(@PathVariable @Valid String boothId) {
//         System.out.println(boothId);
//         return showService.getShowsByDay(boothId);
//     }
// }

