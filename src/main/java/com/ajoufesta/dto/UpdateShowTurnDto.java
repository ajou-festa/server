package com.ajoufesta.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder()
public class UpdateShowTurnDto {
    private int day;
    private Integer showId;
    private String startTime;
}