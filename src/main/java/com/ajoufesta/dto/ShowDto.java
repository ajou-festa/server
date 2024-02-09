package com.ajoufesta.dto;

import com.ajoufesta.domain.ShowStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder()
public class ShowDto {
    private Long id;

    private String showName;

    private ShowStatus status;

    private String teamName;

    private String startTime;
}
