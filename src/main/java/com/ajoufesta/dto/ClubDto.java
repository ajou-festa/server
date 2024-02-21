package com.ajoufesta.dto;

import com.ajoufesta.enums.LinkType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder()
public class ClubDto {
    private Long clubId;
    private String clubName;
    private String clubDetail;
    private String[] clubActivities;
    private String link;
    private LinkType linkIconId;
    private String section;
}
