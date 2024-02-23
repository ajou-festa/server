package com.ajoufesta.domain;

import com.ajoufesta.enums.ShowStatus;
import lombok.Builder;
import lombok.Data;

import org.springframework.data.annotation.Id;

@Builder()
@Data
public class Show {

    @Id
    private final String id;
    private final String teamName;
    private final String startTime;
    private final String endTime;
    private ShowStatus status;
}