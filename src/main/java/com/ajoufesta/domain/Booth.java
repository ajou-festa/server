package com.ajoufesta.domain;

import org.springframework.data.annotation.Id;

import lombok.Builder;
import lombok.Data;

@Builder()
@Data
public class Booth {
    
    @Id
    private String boothId;
    private String boothName;
    private String teamName;
    private String openTime;
    private String closeTime;
    private String description;
    private String link;
    private String linkIconId;
    private String boothLocation;
}