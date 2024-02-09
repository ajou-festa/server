package com.ajoufesta.domain;

import org.springframework.data.annotation.Id;

import lombok.Builder;
import lombok.Data;


@Builder()
@Data
public class Pub {
    
    @Id
    private final Long pubId;
    private final String pubName;
    private final String teamName;
    private final String phoneNum;
    private final String description;
    private final String menuImageSrc;
    private final String link;
    private final String linkIconId;
    private final String pubLocation;
}