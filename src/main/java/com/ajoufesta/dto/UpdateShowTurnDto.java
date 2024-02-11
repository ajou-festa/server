package com.ajoufesta.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder()
public class UpdateShowTurnDto {
    private int day;
    private int showId;
    private String startTime;
}