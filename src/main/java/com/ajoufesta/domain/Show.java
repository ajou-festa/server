package com.ajoufesta.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Builder()
public class Show {

    @Id
    private final Long id;
    private final String showName;
    private final String teamName;
    private final LocalDateTime startTime;
    private final String status;
}