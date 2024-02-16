package com.ajoufesta.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder()
public class BoothDto {
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
