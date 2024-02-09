package com.ajoufesta.domain;

import org.springframework.data.annotation.Id;

import lombok.Builder;
import lombok.Data;


@Builder()
@Data
public class Booth {
    
    @Id
    private final Long boothId;
    private final String boothName;
    private final String teamName;
    private final String openTime;
    private final String closeTime;
    private final String description;
    private final String link;
    private final String linkIconId;
    private final String boothLocation;
}