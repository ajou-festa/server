package com.ajoufesta.dto;

import com.ajoufesta.enums.ShowStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder()
public class ShowDto {
    private String id;

    private String teamName;

    private String startTime;

    private String endTime;

    private ShowStatus status;
}
