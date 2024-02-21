package com.ajoufesta.dto;

import com.ajoufesta.enums.ShowStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder()
public class ShowDto {
    private String id;

    private String showName;

    private ShowStatus status;

    private String teamName;

    private String startTime;

}
