package com.ajoufesta.service;

import com.ajoufesta.dto.CodeDto;
import com.ajoufesta.security.JwtTokenProvider;
import com.ajoufesta.security.SecurityUtil;
import com.ajoufesta.security.TokenInfo;
import org.json.simple.JSONObject;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
public class AuthService {
    private final JwtTokenProvider jwtTokenProvider;

    public AuthService(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public TokenInfo getTokenInfo(CodeDto codeDto) {
        JSONObject jsonObject = SecurityUtil.findByCode(codeDto.getCode());
        Collection<? extends GrantedAuthority> authorities;
        if(jsonObject == null) {
            return null;
        }
        else {
            if(jsonObject.get("type") == "booth") {
                authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_BOOTH"));
            }
            else {
                authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_PUB"));
            }
        }
        Authentication authentication = new UsernamePasswordAuthenticationToken(codeDto.getCode(), codeDto.getCode(), authorities);
        TokenInfo tokenInfo = jwtTokenProvider.generateToken(authentication);
        tokenInfo.setName((String) jsonObject.get("name"));
        tokenInfo.setMemberRole((String) jsonObject.get("type"));
        return tokenInfo;

    }
}
