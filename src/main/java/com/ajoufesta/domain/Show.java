package com.ajoufesta.domain;

import lombok.Builder;
import lombok.Data;

import org.springframework.data.annotation.Id;
import java.time.LocalDateTime;

@Builder()
@Data
public class Show {

    @Id
    private final String id;
    private final String showName;
    private final String teamName;
    private final LocalDateTime startTime;
    private ShowStatus status;
}