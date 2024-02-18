package com.ajoufesta.controller;
import com.ajoufesta.dto.CodeDto;
import com.ajoufesta.security.TokenInfo;
import com.ajoufesta.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/get-tokeninfo")
    public TokenInfo addDaySchedule(@RequestBody CodeDto codeDto) {
        return authService.getTokenInfo(codeDto);
    }
}
