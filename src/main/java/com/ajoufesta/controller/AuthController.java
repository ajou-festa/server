package com.ajoufesta.controller;

import com.ajoufesta.dto.ShowDto;
import com.ajoufesta.service.ShowService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    @Autowired
    private ShowService showService;

    @GetMapping("/")
    public void getAuth(@RequestBody String auth) {
        System.out.println(auth);
    }
}

