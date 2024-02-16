package com.ajoufesta.domain;

import org.springframework.data.annotation.Id;

import lombok.Builder;
import lombok.Data;

@Builder()
@Data
public class Pub {
    
    @Id
    private String pubId;
    private String pubName;
    private String teamName;
    private String phoneNum;
    private String description;
    private String menuImageSrc;
    private String link;
    private String linkIconId;
    private String pubLocation;
}